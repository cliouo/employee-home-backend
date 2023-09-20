package top.cliouo.emp.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cliouo.emp.controller.vo.UserLoginReqVO;
import top.cliouo.emp.controller.vo.UserLoginRespVO;
import top.cliouo.emp.convert.UserConvert;
import top.cliouo.emp.exception.UserNotFoundException;
import top.cliouo.emp.mapper.UserMapper;
import top.cliouo.emp.mapper.dataobject.UserDO;
import top.cliouo.emp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public UserLoginRespVO login(UserLoginReqVO reqVO) {
        UserDO userDO = userMapper.selectByUsername(reqVO.getUsername());
        if(userDO != null){
            // 使用checkpw方法检查被加密的字符串是否与原始字符串匹配
            if(BCrypt.checkpw(reqVO.getPassword(), userDO.getPassword())){
                // 密码正确
                StpUtil.login(userDO.getId());
                return UserConvert.INSTANCE.convert(userDO, StpUtil.getTokenInfo());
            }
        }else{
            throw new UserNotFoundException("用户不存在");
        }
        System.out.println("密码错误");
        return null;
    }
}