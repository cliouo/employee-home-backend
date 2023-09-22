package top.cliouo.emp.mapper;

import top.cliouo.emp.controller.dept.vo.DeptPageReqVO;
import top.cliouo.emp.mapper.dataobject.DeptDO;

import java.util.List;

/**
* @author cliouo
* @description 针对表【system_dept(部门表)】的数据库操作Mapper
* @createDate 2023-09-19 22:24:15
* @Entity top.cliouo.emp.mapper.dataobject.DeptDO
*/
public interface DeptMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DeptDO record);

    int insertSelective(DeptDO record);

    DeptDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DeptDO record);

    int updateByPrimaryKey(DeptDO record);

    List<DeptDO> selectPage(DeptPageReqVO reqVO);

}
