package top.cliouo.emp.controller.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class UserLoginRespVO {

    private Long id;

    private String username;

    private String nickname;

    private Integer status;

    private Boolean faceStatus;

    private String tokenName;

    private String tokenValue;

    private Date tokenExpireTime;

}
