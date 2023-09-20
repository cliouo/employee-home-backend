package top.cliouo.emp.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.cliouo.emp.controller.vo.UserLoginReqVO;
import top.cliouo.emp.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public Object login(@Valid @RequestBody UserLoginReqVO reqVO){
        return userService.login(reqVO);
    }

    @PostMapping("face")
    public Object faceLogin(@RequestParam("face") String face){
        return null;
    }

}
