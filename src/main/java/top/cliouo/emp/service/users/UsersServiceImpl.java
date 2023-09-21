package top.cliouo.emp.service.users;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cliouo.emp.controller.user.vo.UsersAddReqVO;
import top.cliouo.emp.controller.user.vo.UsersDetailRespVO;
import top.cliouo.emp.controller.user.vo.UsersPageReqVO;
import top.cliouo.emp.controller.user.vo.UsersUpdateReqVO;
import top.cliouo.emp.convert.UserConvert;
import top.cliouo.emp.exception.ServiceException;
import top.cliouo.emp.exception.enums.ServiceExceptionCode;
import top.cliouo.emp.mapper.UserMapper;
import top.cliouo.emp.mapper.dataobject.UserDO;
import top.cliouo.emp.util.PageResult;

import java.util.List;

import static top.cliouo.emp.exception.enums.ServiceExceptionCode.*;


@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UsersDetailRespVO userDetail(Long id) {
        // 校验用户存在
        UserDO userDO = checkUserExist(id);
        return UserConvert.INSTANCE.convert(userDO);
    }

    @Override
    public Object save(UsersAddReqVO reqVO) {
        UserDO userSelectDO = userMapper.selectByUsername(reqVO.getUsername());
        if (userSelectDO != null) {
            throw new ServiceException(ServiceExceptionCode.USERNAME_HAS_EXISTED);
        }
        UserDO userDO = UserConvert.INSTANCE.convert(reqVO);
        if (userMapper.insertSelective(userDO) != 1) {
            throw new ServiceException(ServiceExceptionCode.USER_SAVE_ERROR);
        }
        return true;
    }

    @Override
    public Object delete(Long id) {
        // 校验用户存在
        checkUserExist(id);
        if (userMapper.deleteByPrimaryKey(id) != 1) {
            throw new ServiceException(ServiceExceptionCode.USER_DELETE_ERROR);
        }
        return true;
    }

    @Override
    public Object modify(Long id, UsersUpdateReqVO reqVO) {
        // 校验用户存在
        UserDO oldUserDO = checkUserExist(id);
        String oldUsername = oldUserDO.getUsername();
        String newUsername = reqVO.getUsername();

        UserDO userDO = UserConvert.INSTANCE.convert(reqVO);
        userDO.setId(id);
        if (oldUsername.equals(newUsername)) {
            // 新旧用户名相同，不修改用户名
            userDO.setUsername(null);
        } else {
            // 校验新的用户名是否重复
            checkUsernameExist(newUsername);
        }

        if (userMapper.updateByPrimaryKeySelective(userDO) != 1) {
            throw new ServiceException(ServiceExceptionCode.USER_UPDATE_ERROR);
        }
        UserDO userBackDO = userMapper.selectByPrimaryKey(id);
        return UserConvert.INSTANCE.convert(userBackDO);
    }

    @Override
    public PageResult<UsersDetailRespVO> userPage(UsersPageReqVO reqVO) {

//        PageHelper.startPage(1, 10);

        List<UserDO> userDOList = userMapper.selectPage(reqVO);
        PageInfo<UserDO> page = new PageInfo(userDOList);

        //测试PageInfo全部属性
        //PageInfo包含了非常全面的分页属性
        System.out.println("getPageNum(): " + page.getPageNum());
        System.out.println("getPageSize(): " + page.getPageSize());
        System.out.println("getStartRow(): " + page.getStartRow());
        System.out.println("getEndRow(): " + page.getEndRow());
        System.out.println("getTotal(): " + page.getTotal());
        System.out.println("getPages(): " + page.getPages());
//        System.out.println("getFirstPage(): " + page.getFirstPage());
//        System.out.println("getLastPage(): " + page.getLastPage());
        System.out.println("isFirstPage(): " + page.isIsFirstPage());
        System.out.println("isLastPage(): " + page.isIsLastPage());
        System.out.println("isHasPreviousPage(): " + page.isHasPreviousPage());
        System.out.println("isHasNextPage(): " + page.isHasNextPage());

        return UserConvert.INSTANCE.convertPage(page);
    }

    public UserDO checkUserExist(Long id) {
        UserDO userDO = userMapper.selectByPrimaryKey(id);
        if (userDO == null)
            throw new ServiceException(USER_NOT_FOUND);
        return userDO;
    }

    public void checkUsernameExist(String username) {
        UserDO userDO = userMapper.selectByUsername(username);
        if (userDO != null)
            throw new ServiceException(USERNAME_HAS_EXISTED);
    }
}
