package top.cliouo.emp.mapper.dataobject;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * @TableName system_employee
 */
@Data
@Builder
public class EmployeeDO implements Serializable {
    private Long id;

    private Long deptId;

    private Long jobId;

    private String name;

    private String cardId;

    private Integer gender;

    private String phone;

    private String address;

    private String postCode;

    private String tel;

    private String qqNum;

    private String email;

    private String party;

    private Date birthday;

    private String race;

    private String education;

    private String speciality;

    private String hobby;

    private String remark;

    private Date createTime;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}