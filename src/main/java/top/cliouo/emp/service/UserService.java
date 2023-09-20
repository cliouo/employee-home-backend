package top.cliouo.emp.service;


import top.cliouo.emp.controller.vo.UserLoginReqVO;
import top.cliouo.emp.controller.vo.UserLoginRespVO;

public interface UserService {

    UserLoginRespVO login(UserLoginReqVO reqVO);
}
