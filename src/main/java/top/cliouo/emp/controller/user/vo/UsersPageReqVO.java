package top.cliouo.emp.controller.user.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.cliouo.emp.common.PageParam;

@Data
@EqualsAndHashCode(callSuper = true)
public class UsersPageReqVO extends PageParam {

    private String nickname;

    private Integer status;
}
