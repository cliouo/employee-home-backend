package top.cliouo.emp.convert;

import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import top.cliouo.emp.controller.employee.vo.EmployeeAddReqVO;
import top.cliouo.emp.controller.employee.vo.EmployeeDetailRespVO;
import top.cliouo.emp.controller.employee.vo.EmployeeUpdateReqVO;
import top.cliouo.emp.mapper.dataobject.EmployeeDO;
import top.cliouo.emp.util.PageResult;

@Mapper(componentModel = "spring")
public interface EmployeeConvert {

    EmployeeDetailRespVO convert(EmployeeDO employeeDO);
    PageResult<EmployeeDetailRespVO> convert(PageInfo<EmployeeDO> page);


    EmployeeDO convert(EmployeeAddReqVO reqVO);

    EmployeeDO convert(EmployeeUpdateReqVO reqVO);
}
