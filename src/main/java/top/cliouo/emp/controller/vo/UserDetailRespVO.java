package top.cliouo.emp.controller.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailRespVO extends UserBaseVO{

    private Long id;

    private Boolean faceStatus;

    private Date createTime;
}
