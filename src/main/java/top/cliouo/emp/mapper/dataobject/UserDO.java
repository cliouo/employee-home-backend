package top.cliouo.emp.mapper.dataobject;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName system_user
 */
@Data
public class UserDO implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private Integer status;

    private String faceToken;

    private String facePath;

    private Date createTime;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}