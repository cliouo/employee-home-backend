package top.cliouo.emp.mapper.dataobject;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName system_notice
 */
@Data
public class NoticeDO implements Serializable {
    private Long id;

    private String title;

    private String content;

    private Long userId;

    private Date createTime;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}