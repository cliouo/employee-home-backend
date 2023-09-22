package top.cliouo.emp.service.job;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cliouo.emp.controller.job.vo.JobAddReqVO;
import top.cliouo.emp.convert.JobConvert;
import top.cliouo.emp.exception.ServiceException;
import top.cliouo.emp.mapper.JobMapper;
import top.cliouo.emp.mapper.dataobject.JobDO;
import top.cliouo.emp.exception.enums.ServiceExceptionCode;
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
}
