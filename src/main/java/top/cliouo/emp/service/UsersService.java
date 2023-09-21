package top.cliouo.emp.service;

import top.cliouo.emp.controller.vo.UserAddReqVO;
import top.cliouo.emp.controller.vo.UserDetailRespVO;
import top.cliouo.emp.controller.vo.UserUpdateReqVO;

public interface UsersService {
    UserDetailRespVO userDetail(Long id);

    Object save(UserAddReqVO reqVO);

    Object delete(Long id);

    Object modify(Long id, UserUpdateReqVO reqVO);
}
