package top.cliouo.emp.service.users;

import top.cliouo.emp.controller.user.vo.UsersAddReqVO;
import top.cliouo.emp.controller.user.vo.UsersDetailRespVO;
import top.cliouo.emp.controller.user.vo.UsersUpdateReqVO;

public interface UsersService {
    UsersDetailRespVO userDetail(Long id);

    Object save(UsersAddReqVO reqVO);

    Object delete(Long id);

    Object modify(Long id, UsersUpdateReqVO reqVO);
}
