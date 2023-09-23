package top.cliouo.emp.controller.document.vo;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DocumentBaseVO {
    @NotBlank(message = "文档标题不能为空")
    private String title;

    @NotBlank(message = "文档描述不能为空")
    private String remark;
}
