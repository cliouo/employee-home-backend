package top.cliouo.emp.controller.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
public class UserAlterPwdReqVO {

    @NotBlank(message = "旧密码不能为空")
    String oldPassword;

    @Pattern(regexp = "^(?=.*[0-9a-zA-Z@#$%^&+=_\\-!?*.]).{7,17}$", message = "密码只能包含数字、小写字母、大写字母、特殊字符（@#$%^&+=_\\-!?*.），并且长度至少为6个字符")
    String newPassword;
}
