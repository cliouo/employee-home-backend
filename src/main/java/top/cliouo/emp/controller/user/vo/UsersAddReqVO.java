package top.cliouo.emp.controller.user.vo;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UsersAddReqVO extends UserBaseVO {

    @Pattern(regexp = "^(?=.*[0-9a-zA-Z@#$%^&+=_\\-!?*.]).{6,18}$", message = "密码只能包含数字、小写字母、大写字母、特殊字符（@#$%^&+=_\\-!?*.），并且长度为6-18个字符之间")
    String password;
}
