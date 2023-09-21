package top.cliouo.emp.mapper.dataobject;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName system_user
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDO implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private Integer status;

    private Integer faceStatus;

    private Date createTime;

    private Integer deleted;

    @Serial
    private static final long serialVersionUID = 1L;
}