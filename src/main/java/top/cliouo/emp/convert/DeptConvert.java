package top.cliouo.emp.convert;


import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import top.cliouo.emp.controller.dept.vo.DeptAddReqVO;
import top.cliouo.emp.controller.dept.vo.DeptDetailRespVO;
import top.cliouo.emp.controller.dept.vo.DeptUpdateReqVO;
import top.cliouo.emp.mapper.dataobject.DeptDO;
import top.cliouo.emp.common.PageResult;

@Mapper(componentModel = "spring")
public interface DeptConvert {

    DeptDO convert(DeptAddReqVO reqVO);
    DeptDO convert(DeptUpdateReqVO reqVO);

    PageResult<DeptDetailRespVO> convertPage(PageInfo<DeptDO> page);

    DeptDetailRespVO convert(DeptDO deptDO);
}
