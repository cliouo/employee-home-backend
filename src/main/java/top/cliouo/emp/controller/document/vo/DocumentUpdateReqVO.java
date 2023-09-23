package top.cliouo.emp.controller.document.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DocumentUpdateReqVO extends DocumentBaseVO{
    private String fileName;
}
