package top.cliouo.emp.controller.notice.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class NoticeDetailRespVO extends NoticeBaseVO {
    private Long id;

    private String nickname;

    private Date createTime;
}
