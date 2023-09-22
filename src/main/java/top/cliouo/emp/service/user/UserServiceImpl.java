package top.cliouo.emp.service.user;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cliouo.emp.controller.user.vo.UserAlterPwdReqVO;
import top.cliouo.emp.controller.user.vo.UserLoginReqVO;
import top.cliouo.emp.controller.user.vo.UserLoginRespVO;
import top.cliouo.emp.convert.UserConvert;
import top.cliouo.emp.exception.ServiceException;
import top.cliouo.emp.mapper.UserMapper;
import top.cliouo.emp.mapper.dataobject.UserDO;
import top.cliouo.emp.util.BaiduAipFace;

import static top.cliouo.emp.exception.enums.ServiceExceptionCode.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserConvert userConvert;

    @Autowired
    BaiduAipFace baiduAipFace;

    @Override
    public UserLoginRespVO login(UserLoginReqVO reqVO) {
        UserDO userDO = userMapper.selectByUsername(reqVO.getUsername());

        // 检查用户密码，正确返回true，错误抛出异常
        checkPassword(reqVO.getUsername(), reqVO.getPassword());
        // 密码正确
        StpUtil.login(userDO.getId());
        return userConvert.convert(userDO, StpUtil.getTokenInfo());
    }

    @Override
    public Object alterPwd(UserAlterPwdReqVO reqVO) {
        Long loginId = StpUtil.getLoginIdAsLong();
        UserDO userDO = userMapper.selectByPrimaryKey(loginId);
        // 检查旧密码
        checkPassword(userDO.getUsername(), reqVO.getOldPassword());
        // 检查通过，更新密码
        userMapper.updateByPrimaryKeySelective(new UserDO().builder()
                .id(loginId)
                .password(BCrypt.hashpw(reqVO.getNewPassword())) //加密
                .build());
        return null;
    }

    /**
     * 检查用户密码，正确返回true，错误抛出异常
     * @param username  用户名
     * @param password  密码
     * @return  正确返回true，错误抛出异常
     */
    @Override
    public Boolean checkPassword(String username, String password) {
        UserDO userDO = userMapper.selectByUsername(username);
        if (userDO != null) {
            // 使用checkpw方法检查被加密的字符串是否与原始字符串匹配
            if (BCrypt.checkpw(password, userDO.getPassword())) {
                // 密码正确
                return true;
            }
            throw new ServiceException(USER_PASSWORD_ERROR);
        }
        throw new ServiceException(USERNAME_NOT_FOUND);
    }

    @Override
    public Object faceRegister(String face) {
        String faceToken = baiduAipFace.faceRegister(face, "BASE64", StpUtil.getLoginIdAsString());
        if(faceToken == null){
            throw new ServiceException(FACE_REGISTER_ERROR);
        }
        // 人脸注册成功，更新用户表
        userMapper.updateByPrimaryKeySelective(new UserDO().builder()
                .id(StpUtil.getLoginIdAsLong())
                .faceStatus(1)
                .build());
        return null;
    }

    @Override
    public Object faceLogin(String face) {
        String userId = baiduAipFace.faceSearch(face, "BASE64");
        if(userId != null){
            Long userIdForLong = Long.parseLong(userId);
            StpUtil.login(userIdForLong);
            return userConvert.convert(userMapper.selectByPrimaryKey(StpUtil.getLoginIdAsLong()), StpUtil.getTokenInfo());
        }
        throw new ServiceException(FACE_LOGIN_ERROR);
    }

    @Override
    public Object logout() {
        StpUtil.logout();
        return null;
    }
}
