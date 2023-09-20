package top.cliouo.emp.mapper.dataobject;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * @TableName system_notice
 */
@Data
@Builder
public class NoticeDO implements Serializable {
    private Long id;

    private String title;

    private String content;

    private Long userId;

    private Date createTime;

    private Integer deleted;

    @Serial
    private static final long serialVersionUID = 1L;
}