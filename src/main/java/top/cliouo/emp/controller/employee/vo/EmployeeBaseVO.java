package top.cliouo.emp.controller.employee.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeBaseVO {

    @NotNull(message = "部门ID不能为空")
    private Long deptId;

    @NotNull(message = "职位ID不能为空")
    private Long jobId;

    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotBlank(message = "身份证号不能为空")
    private String cardId;

    @NotNull(message = "性别不能为空")
    private Integer gender;

    @NotBlank(message = "手机号不能为空")
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
}
