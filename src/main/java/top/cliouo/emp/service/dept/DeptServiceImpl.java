package top.cliouo.emp.service.dept;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cliouo.emp.controller.dept.vo.DeptAddReqVO;
import top.cliouo.emp.controller.dept.vo.DeptDetailRespVO;
import top.cliouo.emp.controller.dept.vo.DeptPageReqVO;
import top.cliouo.emp.controller.dept.vo.DeptUpdateReqVO;
import top.cliouo.emp.convert.DeptConvert;
import top.cliouo.emp.exception.ServiceException;
import top.cliouo.emp.exception.enums.ServiceExceptionCode;
import top.cliouo.emp.mapper.DeptMapper;
import top.cliouo.emp.mapper.dataobject.DeptDO;
import top.cliouo.emp.common.PageResult;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Autowired
    DeptConvert deptConvert;

    @Override
    public Object save(DeptAddReqVO reqVO) {
        DeptDO deptDO = deptConvert.convert(reqVO);
        if(deptMapper.insertSelective(deptDO) != 1){
            throw new ServiceException(ServiceExceptionCode.DEPT_SAVE_ERROR);
        }
        return null;
    }

    @Override
    public Object delete(Long id) {
        // 校验职位是否存在
        checkDeptExist(id);
        if(deptMapper.deleteByPrimaryKey(id) != 1){
            throw new ServiceException(ServiceExceptionCode.DEPT_DELETE_ERROR);
        }
        return true;
    }
    @Override
    public Object modify(Long id, DeptUpdateReqVO reqVO){
        // 校验职位是否存在
        checkDeptExist(id);

        DeptDO deptDO = deptConvert.convert(reqVO);
        deptDO.setId(id);
        if(deptMapper.updateByPrimaryKeySelective(deptDO) != 1){
            throw new ServiceException(ServiceExceptionCode.DEPT_UPDATE_ERROR);
        }
        return true;
    }
    @Override
    public DeptDO get(Long id){
        // 校验职位是否存在
        checkDeptExist(id);
        return deptMapper.selectByPrimaryKey(id);
    }
    @Override
    public PageResult<DeptDetailRespVO> deptPage(DeptPageReqVO reqVO) {
        PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize());
        List<DeptDO> deptDOList = deptMapper.selectPage(reqVO);
        PageInfo<DeptDO> page = new PageInfo(deptDOList);
        return deptConvert.convertPage(page);
    }



    // 校验职位是否存在
    public void checkDeptExist(Long id){
        if(deptMapper.selectByPrimaryKey(id) == null){
            throw new ServiceException(ServiceExceptionCode.DEPT_NOT_EXIST);
        }
    }
}
