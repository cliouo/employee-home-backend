package top.cliouo.emp.controller.document.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.cliouo.emp.common.PageParam;

@Data
@EqualsAndHashCode(callSuper = true)
public class DocumentPageReqVO extends PageParam {
    private String title;
}
