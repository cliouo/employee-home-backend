package top.cliouo.emp.controller.employee;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.cliouo.emp.controller.employee.vo.EmployeeAddReqVO;
import top.cliouo.emp.controller.employee.vo.EmployeePageReqVO;
import top.cliouo.emp.controller.employee.vo.EmployeeUpdateReqVO;
import top.cliouo.emp.convert.EmployeeConvert;
import top.cliouo.emp.service.employee.EmployeeService;

@RestController
@RequestMapping("employee")
@SaCheckLogin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeConvert employeeConvert;
    @PostMapping
    @SaCheckRole("admin")
    public Object addEmployee(@RequestBody @Valid EmployeeAddReqVO reqVO){
        return employeeService.save(reqVO);
    }
    @DeleteMapping("{id}")
    @SaCheckRole("admin")
    public Object deleteEmployee(@PathVariable Long id){
        return employeeService.delete(id);
    }
    @PutMapping("{id}")
    @SaCheckRole("admin")
    public Object updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeUpdateReqVO reqVO){
        return employeeService.modify(id, reqVO);
    }
    @GetMapping("{id}")
    public Object getEmployee(@PathVariable Long id){
        return employeeConvert.convert(employeeService.get(id));
    }
    @GetMapping
    public Object employeePage(@Valid EmployeePageReqVO reqVO){
        return employeeService.employeePage(reqVO);
    }

}
