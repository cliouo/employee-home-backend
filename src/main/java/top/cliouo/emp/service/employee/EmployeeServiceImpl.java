package top.cliouo.emp.service.employee;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cliouo.emp.controller.employee.vo.EmployeeAddReqVO;
import top.cliouo.emp.controller.employee.vo.EmployeeDetailRespVO;
import top.cliouo.emp.controller.employee.vo.EmployeePageReqVO;
import top.cliouo.emp.controller.employee.vo.EmployeeUpdateReqVO;
import top.cliouo.emp.convert.EmployeeConvert;
import top.cliouo.emp.exception.ServiceException;
import top.cliouo.emp.mapper.EmployeeMapper;
import top.cliouo.emp.mapper.dataobject.EmployeeDO;
import top.cliouo.emp.common.PageResult;
import top.cliouo.emp.exception.enums.ServiceExceptionCode;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    EmployeeConvert employeeConvert;

    @Override
    public Object save(EmployeeAddReqVO reqVO) {
        EmployeeDO employeeDO = employeeConvert.convert(reqVO);
        if (employeeMapper.insertSelective(employeeDO)!=1) {
            throw new ServiceException(ServiceExceptionCode.EMPLOYEE_SAVE_ERROR);
        }
        return true;
    }

    @Override
    public Object delete(Long id) {
        checkEmployeeExist(id);
        if (employeeMapper.deleteByPrimaryKey(id)!=1) {
            throw new ServiceException(ServiceExceptionCode.EMPLOYEE_DELETE_ERROR);
        }
        return true;
    }

    @Override
    public Object modify(Long id, EmployeeUpdateReqVO reqVO) {
        checkEmployeeExist(id);
        EmployeeDO employeeDO = employeeConvert.convert(reqVO);
        employeeDO.setId(id);
        if (employeeMapper.updateByPrimaryKeySelective(employeeDO)!=1) {
            throw new ServiceException(ServiceExceptionCode.EMPLOYEE_UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public EmployeeDO get(Long id) {
        checkEmployeeExist(id);

        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult<EmployeeDetailRespVO> employeePage(EmployeePageReqVO reqVO) {
        PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize());
        List<EmployeeDO> employeeDOS = employeeMapper.selectPage(reqVO);
        PageInfo<EmployeeDO> page = new PageInfo<>(employeeDOS);
        return employeeConvert.convert(page);
    }

    public void checkEmployeeExist(Long id){
        if (employeeMapper.selectByPrimaryKey(id)==null) {
            throw new ServiceException(ServiceExceptionCode.EMPLOYEE_NOT_EXIST);
        }
    }
}
