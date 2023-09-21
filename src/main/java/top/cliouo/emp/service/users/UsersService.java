package top.cliouo.emp.service.users;

import top.cliouo.emp.controller.user.vo.UsersAddReqVO;
import top.cliouo.emp.controller.user.vo.UsersDetailRespVO;
import top.cliouo.emp.controller.user.vo.UsersPageReqVO;
import top.cliouo.emp.controller.user.vo.UsersUpdateReqVO;
import top.cliouo.emp.mapper.dataobject.UserDO;
import top.cliouo.emp.util.PageResult;

public interface UsersService {
    UsersDetailRespVO userDetail(Long id);

    Object save(UsersAddReqVO reqVO);

    Object delete(Long id);

    Object modify(Long id, UsersUpdateReqVO reqVO);

    PageResult<UsersDetailRespVO> userPage(UsersPageReqVO reqVO);
}
