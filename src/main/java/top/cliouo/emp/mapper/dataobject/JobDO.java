package top.cliouo.emp.mapper.dataobject;

import java.io.Serial;
import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * @TableName system_job
 */
@Data
@Builder
public class JobDO implements Serializable {
    private Long id;

    private String name;

    private String remark;

    private Integer deleted;

    @Serial
    private static final long serialVersionUID = 1L;
}