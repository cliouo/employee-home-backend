package top.cliouo.emp.service.user;


import top.cliouo.emp.controller.user.vo.UserAlterPwdReqVO;
import top.cliouo.emp.controller.user.vo.UserLoginReqVO;
import top.cliouo.emp.controller.user.vo.UserLoginRespVO;

public interface UserService {

    UserLoginRespVO login(UserLoginReqVO reqVO);

    Object alterPwd(UserAlterPwdReqVO reqVO);

    Boolean checkPassword(String username, String password);

    Object faceRegister(String face);

    Object faceLogin(String face);

    Object logout();
}
