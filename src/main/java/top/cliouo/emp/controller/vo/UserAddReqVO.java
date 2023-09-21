package top.cliouo.emp.controller.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserAddReqVO extends UserBaseVO {

    @Pattern(regexp = "^(?=.*[0-9a-zA-Z@#$%^&+=_\\-!?*.]).{6,18}$", message = "密码只能包含数字、小写字母、大写字母、特殊字符（@#$%^&+=_\\-!?*.），并且长度为6-18个字符之间")
    String password;
}
