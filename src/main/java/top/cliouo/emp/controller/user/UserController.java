package top.cliouo.emp.controller.user;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.cliouo.emp.controller.user.vo.UserAlterPwdReqVO;
import top.cliouo.emp.controller.user.vo.UserLoginReqVO;
import top.cliouo.emp.convert.UserConvert;
import top.cliouo.emp.service.user.UserService;
import top.cliouo.emp.service.users.UsersService;

@RestController
@RequestMapping("user")
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UsersService usersService;

    @Autowired
    UserConvert userConvert;

    @PostMapping("token")
    public Object login(@RequestBody @Valid UserLoginReqVO reqVO){
        return userService.login(reqVO);
    }

    @DeleteMapping("token")
    public Object logout(){
        return userService.logout();
    }

    @GetMapping()
    @SaCheckLogin
    public Object userDetail(){
        return userConvert.convert(usersService.userDetail(StpUtil.getLoginIdAsLong()));
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
