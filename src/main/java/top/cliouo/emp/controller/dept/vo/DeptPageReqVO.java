package top.cliouo.emp.controller.dept.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.cliouo.emp.common.PageParam;


@EqualsAndHashCode(callSuper = true)
@Data
public class DeptPageReqVO extends PageParam {

    private String name;

}
