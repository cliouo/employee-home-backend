package top.cliouo.emp.controller.user.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class UsersDetailRespVO extends UserBaseVO{

    private Long id;

    private Boolean faceStatus;

    private Date createTime;
}
