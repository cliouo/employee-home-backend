package top.cliouo.emp.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
