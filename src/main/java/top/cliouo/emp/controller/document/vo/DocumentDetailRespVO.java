package top.cliouo.emp.controller.document.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class DocumentDetailRespVO extends DocumentBaseVO{

    private Long id;
    private String fileName;

    private String creator;

    private Date createTime;
}
