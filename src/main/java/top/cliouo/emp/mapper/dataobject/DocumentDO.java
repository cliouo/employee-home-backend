package top.cliouo.emp.mapper.dataobject;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName system_document
 */
@Data
public class DocumentDO implements Serializable {
    private Long id;

    private String title;

    private String fileName;

    private String remark;

    private Date createTime;

    private Long userId;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}