package top.cliouo.emp.controller.notice.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NoticeBaseVO {

    @NotBlank(message = "标题不能为空")
    private String title;

    private String content;
}
