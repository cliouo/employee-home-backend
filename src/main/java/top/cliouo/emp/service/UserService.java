package top.cliouo.emp.service;


import top.cliouo.emp.controller.vo.UserAlterPwdReqVO;
import top.cliouo.emp.controller.vo.UserLoginReqVO;
import top.cliouo.emp.controller.vo.UserLoginRespVO;

public interface UserService {

    UserLoginRespVO login(UserLoginReqVO reqVO);

    Object alterPwd(UserAlterPwdReqVO reqVO);

    Boolean checkPassword(String username, String password);

    Object faceRegister(String face);

    Object faceLogin(String face);
}
