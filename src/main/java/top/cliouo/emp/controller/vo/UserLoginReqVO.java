package top.cliouo.emp.controller.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginReqVO extends UserBaseVO{

    @NotBlank(message = "密码不能为空")
    private String password;
}
