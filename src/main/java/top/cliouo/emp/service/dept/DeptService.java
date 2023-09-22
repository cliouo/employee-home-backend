package top.cliouo.emp.service.dept;

import top.cliouo.emp.controller.dept.vo.DeptAddReqVO;
import top.cliouo.emp.controller.dept.vo.DeptDetailRespVO;
import top.cliouo.emp.controller.dept.vo.DeptPageReqVO;
import top.cliouo.emp.controller.dept.vo.DeptUpdateReqVO;
import top.cliouo.emp.mapper.dataobject.DeptDO;
import top.cliouo.emp.util.PageResult;

public interface DeptService {

    Object save(DeptAddReqVO reqVO);

    Object delete(Long id);

    Object modify(Long id, DeptUpdateReqVO reqVO);

    DeptDO get(Long id);

    PageResult<DeptDetailRespVO> deptPage(DeptPageReqVO reqVO);
}
