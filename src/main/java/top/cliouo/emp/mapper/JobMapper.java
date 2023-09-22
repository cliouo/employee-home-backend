package top.cliouo.emp.mapper;

import top.cliouo.emp.controller.job.vo.JobPageReqVO;
import top.cliouo.emp.mapper.dataobject.JobDO;

import java.util.List;

/**
* @author cliouo
* @description 针对表【system_job(职位表)】的数据库操作Mapper
* @createDate 2023-09-19 22:24:15
* @Entity top.cliouo.emp.mapper.dataobject.JobDO
*/
public interface JobMapper {

    int deleteByPrimaryKey(Long id);

    int insert(JobDO record);

    int insertSelective(JobDO record);

    JobDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JobDO record);

    int updateByPrimaryKey(JobDO record);

    List<JobDO> selectPage(JobPageReqVO reqVO);
}
