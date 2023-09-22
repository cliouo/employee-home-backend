package top.cliouo.emp.service.job;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cliouo.emp.controller.job.vo.JobAddReqVO;
import top.cliouo.emp.controller.job.vo.JobDetailRespVO;
import top.cliouo.emp.controller.job.vo.JobPageReqVO;
import top.cliouo.emp.controller.job.vo.JobUpdateReqVO;
import top.cliouo.emp.convert.JobConvert;
import top.cliouo.emp.exception.ServiceException;
import top.cliouo.emp.mapper.JobMapper;
import top.cliouo.emp.mapper.dataobject.JobDO;
import top.cliouo.emp.exception.enums.ServiceExceptionCode;
import top.cliouo.emp.util.PageResult;

import java.util.List;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    JobMapper jobMapper;

    @Override
    public Object save(JobAddReqVO reqVO) {
        JobDO jobDO = JobConvert.INSTANCE.convert(reqVO);
        if(jobMapper.insert(jobDO) != 1){
            throw new ServiceException(ServiceExceptionCode.JOB_SAVE_ERROR);
        }
        return null;
    }

    @Override
    public Object delete(Long id) {
        // 校验职位是否存在
        checkJobExist(id);

        if(jobMapper.deleteByPrimaryKey(id) != 1){
            throw new ServiceException(ServiceExceptionCode.JOB_DELETE_ERROR);
        }
        return true;
    }
    @Override
    public Object modify(Long id, JobUpdateReqVO reqVO){
        // 校验职位是否存在
        checkJobExist(id);

        JobDO jobDO = JobConvert.INSTANCE.convert(reqVO);
        jobDO.setId(id);
        if(jobMapper.updateByPrimaryKeySelective(jobDO) != 1){
            throw new ServiceException(ServiceExceptionCode.JOB_UPDATE_ERROR);
        }
        return true;
    }
    @Override
    public Object get(Long id){
        // 校验职位是否存在
        checkJobExist(id);
        return jobMapper.selectByPrimaryKey(id);
    }
    @Override
    public PageResult<JobDetailRespVO> jobPage(JobPageReqVO reqVO) {

        List<JobDO> jobDOList = jobMapper.selectPage(reqVO);
        PageInfo<JobDO> page = new PageInfo(jobDOList);
        return JobConvert.INSTANCE.convertPage(page);
    }



    // 校验职位是否存在
    public void checkJobExist(Long id){
        if(jobMapper.selectByPrimaryKey(id) == null){
            throw new ServiceException(ServiceExceptionCode.JOB_NOT_EXIST);
        }
    }
}
