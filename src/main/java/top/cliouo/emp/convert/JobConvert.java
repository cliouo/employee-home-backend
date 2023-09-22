package top.cliouo.emp.convert;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.cliouo.emp.controller.job.vo.JobAddReqVO;
import top.cliouo.emp.mapper.dataobject.JobDO;

@Mapper
public interface JobConvert {

    JobConvert INSTANCE = Mappers.getMapper(JobConvert.class);


    JobDO convert(JobAddReqVO reqVO);
}
