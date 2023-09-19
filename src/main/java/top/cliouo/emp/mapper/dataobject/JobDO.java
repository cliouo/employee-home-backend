package top.cliouo.emp.mapper.dataobject;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName system_job
 */
@Data
public class JobDO implements Serializable {
    private Long id;

    private String name;

    private String remark;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}