package top.cliouo.emp.controller.user.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class UserLoginReqVO{

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;
}
