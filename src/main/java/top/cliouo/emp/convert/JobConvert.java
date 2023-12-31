package top.cliouo.emp.convert;


import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import top.cliouo.emp.controller.job.vo.JobAddReqVO;
import top.cliouo.emp.controller.job.vo.JobDetailRespVO;
import top.cliouo.emp.controller.job.vo.JobUpdateReqVO;
import top.cliouo.emp.mapper.dataobject.JobDO;
import top.cliouo.emp.common.PageResult;

@Mapper(componentModel = "spring")
public interface JobConvert {

    JobDO convert(JobAddReqVO reqVO);
    JobDO convert(JobUpdateReqVO reqVO);

    PageResult<JobDetailRespVO> convertPage(PageInfo<JobDO> page);

    JobDetailRespVO convert(JobDO jobDO);
}
