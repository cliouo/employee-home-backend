package top.cliouo.emp.controller.notice.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.cliouo.emp.common.PageParam;

@EqualsAndHashCode(callSuper = true)
@Data
public class NoticePageReqVO extends PageParam {

    private String title;

    private String content;
}
