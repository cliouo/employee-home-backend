package top.cliouo.emp.service.job;

import top.cliouo.emp.controller.job.vo.JobAddReqVO;
import top.cliouo.emp.controller.job.vo.JobDetailRespVO;
import top.cliouo.emp.controller.job.vo.JobPageReqVO;
import top.cliouo.emp.controller.job.vo.JobUpdateReqVO;
import top.cliouo.emp.mapper.dataobject.JobDO;
import top.cliouo.emp.util.PageResult;

public interface JobService {

    Object save(JobAddReqVO reqVO);

    Object delete(Long id);

    Object modify(Long id, JobUpdateReqVO reqVO);

    JobDO get(Long id);

    PageResult<JobDetailRespVO> jobPage(JobPageReqVO reqVO);
}
