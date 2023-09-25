package top.cliouo.emp.controller.employee.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeDetailRespVO extends EmployeeBaseVO{
    private Long id;
}
