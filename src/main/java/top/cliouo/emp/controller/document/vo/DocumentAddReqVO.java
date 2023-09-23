package top.cliouo.emp.controller.document.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DocumentAddReqVO extends DocumentBaseVO{

    @NotBlank(message = "文档文件不能为空")
    private String fileName;
}
