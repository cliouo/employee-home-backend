package top.cliouo.emp.controller.job.vo;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class JobBaseVO {

    @NotBlank(message = "职位名称不能为空")
    private String name;

    private String remark;

}
