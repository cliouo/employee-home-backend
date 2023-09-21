package top.cliouo.emp.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.cliouo.emp.controller.vo.UserAlterPwdReqVO;
import top.cliouo.emp.controller.vo.UserLoginReqVO;
import top.cliouo.emp.service.UserService;

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

    @PostMapping("face")
    public Object faceRegister(@RequestBody @Valid String face){
        return userService.faceRegister(face);
    }

    @PostMapping("face/token")
    public Object faceLogin(@RequestBody @Valid String face){
        return userService.faceLogin(face);
    }
    @PutMapping("password")
    public Object alterPassword(@RequestBody @Valid UserAlterPwdReqVO reqVO){
        return userService.alterPwd(reqVO);
    }

}
