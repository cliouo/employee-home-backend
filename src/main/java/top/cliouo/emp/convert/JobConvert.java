package top.cliouo.emp.convert;


import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.cliouo.emp.controller.job.vo.JobAddReqVO;
import top.cliouo.emp.controller.job.vo.JobDetailRespVO;
import top.cliouo.emp.controller.job.vo.JobUpdateReqVO;
import top.cliouo.emp.mapper.dataobject.JobDO;
import top.cliouo.emp.util.PageResult;

@Mapper
public interface JobConvert {

    JobConvert INSTANCE = Mappers.getMapper(JobConvert.class);


    JobDO convert(JobAddReqVO reqVO);
    JobDO convert(JobUpdateReqVO reqVO);

    PageResult<JobDetailRespVO> convertPage(PageInfo<JobDO> page);

    JobDetailRespVO convert(JobDO jobDO);
}
