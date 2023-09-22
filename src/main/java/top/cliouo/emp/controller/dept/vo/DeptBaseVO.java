package top.cliouo.emp.controller.dept.vo;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DeptBaseVO {

    @NotBlank(message = "部门名称不能为空")
    private String name;

    private String remark;

}
