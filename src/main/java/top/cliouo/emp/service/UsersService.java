package top.cliouo.emp.service;

import top.cliouo.emp.controller.vo.UserAddReqVO;
import top.cliouo.emp.controller.vo.UserDetailRespVO;

public interface UsersService {
    UserDetailRespVO userDetail(Long id);

    Object save(UserAddReqVO reqVO);
}
