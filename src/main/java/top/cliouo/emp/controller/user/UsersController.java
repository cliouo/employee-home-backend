package top.cliouo.emp.controller.user;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.cliouo.emp.controller.user.vo.UsersAddReqVO;
import top.cliouo.emp.controller.user.vo.UsersDetailRespVO;
import top.cliouo.emp.controller.user.vo.UsersPageReqVO;
import top.cliouo.emp.controller.user.vo.UsersUpdateReqVO;
import top.cliouo.emp.convert.UserConvert;
import top.cliouo.emp.service.users.UsersService;
import top.cliouo.emp.util.PageResult;

@RestController
@RequestMapping("users")
@SaCheckLogin
public class UsersController {

    @Autowired
    UsersService usersService;

    @Autowired
    UserConvert userConvert;

    @GetMapping("{id}")
    public Object userDetail(@PathVariable("id") Long id){
        return userConvert.convert(usersService.userDetail(id));
    }

    @GetMapping
    public PageResult<UsersDetailRespVO> userPage(@Valid UsersPageReqVO reqVO){

        return usersService.userPage(reqVO);
    }

    @SaCheckRole("admin")
    @PutMapping("{id}")
    public Object userUpdate(@PathVariable("id") Long id, @RequestBody @Valid UsersUpdateReqVO reqVO){
        return usersService.modify(id, reqVO);
    }


    @SaCheckRole("admin")
    @PostMapping()
    public Object userAdd(@RequestBody @Valid UsersAddReqVO reqVO){
        return usersService.save(reqVO);
    }

    @SaCheckRole("admin")
    @DeleteMapping("{id}")
    public Object userDelete(@PathVariable("id") Long id){
        return usersService.delete(id);
    }
}
