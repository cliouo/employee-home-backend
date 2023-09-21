package top.cliouo.emp.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.cliouo.emp.controller.vo.UserAddReqVO;
import top.cliouo.emp.service.UsersService;

@RestController
@RequestMapping("users")
@SaCheckLogin
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("{id}")
    public Object userDetail(@PathVariable("id") Long id){
        return usersService.userDetail(id);
    }

    @PostMapping()
    public Object userAdd(@RequestBody @Valid UserAddReqVO reqVO){
        return usersService.save(reqVO);
    }
}
