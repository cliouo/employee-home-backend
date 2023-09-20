package top.cliouo.emp.controller.vo;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBaseVO {

    @NotBlank(message = "用户名不能为空")
    private String username;

}
