package top.cliouo.emp.controller.user.vo;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
public class UserBaseVO {

    @Length(min = 4, max = 16, message = "账号长度为 4-16 位")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "账号格式为数字以及字母")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Length(min = 4, max = 16, message = "昵称长度为 4-16 位")
    @NotBlank(message = "昵称不能为空")
    private String nickname;

    @Range(min=1, max=2, message = "用户角色只能为1或2")
    @NotNull(message = "用户角色不能为空")
    private Integer status;
}
