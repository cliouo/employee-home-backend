package top.cliouo.emp.controller.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginReqVO extends UserBaseVO{

    @NotBlank(message = "密码不能为空")
    private String password;
}
