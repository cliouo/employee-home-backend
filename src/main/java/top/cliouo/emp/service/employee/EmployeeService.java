package top.cliouo.emp.service.employee;


import top.cliouo.emp.controller.employee.vo.EmployeeAddReqVO;
import top.cliouo.emp.controller.employee.vo.EmployeeDetailRespVO;
import top.cliouo.emp.controller.employee.vo.EmployeePageReqVO;
import top.cliouo.emp.controller.employee.vo.EmployeeUpdateReqVO;
import top.cliouo.emp.mapper.dataobject.EmployeeDO;
import top.cliouo.emp.util.PageResult;

public interface EmployeeService {

    Object save(EmployeeAddReqVO reqVO);

    Object delete(Long id);

    Object modify(Long id, EmployeeUpdateReqVO reqVO);

    EmployeeDO get(Long id);

    PageResult<EmployeeDetailRespVO> employeePage(EmployeePageReqVO reqVO);
    
}
