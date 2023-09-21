package top.cliouo.emp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cliouo.emp.controller.vo.UserDetailRespVO;
import top.cliouo.emp.convert.UserConvert;
import top.cliouo.emp.exception.ServiceException;
import top.cliouo.emp.exception.enums.ServiceExceptionCode;
import top.cliouo.emp.mapper.UserMapper;
import top.cliouo.emp.mapper.dataobject.UserDO;
import top.cliouo.emp.service.UsersService;

import static top.cliouo.emp.exception.enums.ServiceExceptionCode.USER_NOT_FOUND;


@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetailRespVO userDetail(Long id) {
        UserDO userDO = userMapper.selectByPrimaryKey(id);
        if(userDO == null)
            throw new ServiceException(USER_NOT_FOUND);
        return UserConvert.INSTANCE.convert(userDO);
    }
}
