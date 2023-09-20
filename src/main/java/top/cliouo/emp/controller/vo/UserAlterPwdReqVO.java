package top.cliouo.emp.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAlterPwdReqVO {
    String oldPassword;
    String newPassword;
}
