package top.cliouo.emp.controller.user;

import cn.dev33.satoken.annotation.SaCheckLogin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.cliouo.emp.controller.user.vo.UserAlterPwdReqVO;
import top.cliouo.emp.controller.user.vo.UserLoginReqVO;
import top.cliouo.emp.service.user.UserService;

@RestController
@RequestMapping("user")
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("token")
    public Object login(@RequestBody @Valid UserLoginReqVO reqVO){
        return userService.login(reqVO);
    }

    @DeleteMapping("token")
    public Object logout(){
        return userService.logout();
    }

    @SaCheckLogin
    @PostMapping("face")
    public Object faceRegister(@RequestBody @Valid String face){
        return userService.faceRegister(face);
    }

    @PostMapping("face/token")
    public Object faceLogin(@RequestBody @Valid String face){
        return userService.faceLogin(face);
    }

    @SaCheckLogin
    @PutMapping("password")
    public Object alterPassword(@RequestBody @Valid UserAlterPwdReqVO reqVO){
        return userService.alterPwd(reqVO);
    }

}
