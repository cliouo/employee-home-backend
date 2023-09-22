package top.cliouo.emp.controller.job.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.cliouo.emp.common.PageParam;


@EqualsAndHashCode(callSuper = true)
@Data
public class JobPageReqVO extends PageParam {

    private String name;

}
