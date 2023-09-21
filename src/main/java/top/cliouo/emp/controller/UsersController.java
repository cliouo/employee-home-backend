package top.cliouo.emp.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.cliouo.emp.controller.vo.UserAddReqVO;
import top.cliouo.emp.controller.vo.UserUpdateReqVO;
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

    @SaCheckRole("user:update")
    @PutMapping("{id}")
    public Object userUpdate(@PathVariable("id") Long id, @RequestBody @Valid UserUpdateReqVO reqVO){
        return usersService.modify(id, reqVO);
    }


    @SaCheckRole("user:add")
    @PostMapping()
    public Object userAdd(@RequestBody @Valid UserAddReqVO reqVO){
        return usersService.save(reqVO);
    }

    @SaCheckRole("user:delete")
    @DeleteMapping("{id}")
    public Object userDelete(@PathVariable("id") Long id){
        return usersService.delete(id);
    }
}
