package top.cliouo.emp.mapper;

import top.cliouo.emp.mapper.dataobject.EmployeeDO;

/**
* @author cliouo
* @description 针对表【system_employee(员工表)】的数据库操作Mapper
* @createDate 2023-09-19 22:24:15
* @Entity top.cliouo.emp.mapper.dataobject.EmployeeDO
*/
public interface EmployeeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(EmployeeDO record);

    int insertSelective(EmployeeDO record);

    EmployeeDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EmployeeDO record);

    int updateByPrimaryKey(EmployeeDO record);

}
