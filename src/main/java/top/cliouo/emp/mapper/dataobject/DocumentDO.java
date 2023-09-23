package top.cliouo.emp.mapper.dataobject;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * @TableName system_document
 */
@Data
@Builder
public class DocumentDO implements Serializable {
    private Long id;

    private String title;

    private String fileName;

    private String remark;

    private Date createTime;

    private Long userId;


    @Serial
    private static final long serialVersionUID = 1L;
}