package top.cliouo.emp.mapper;

import top.cliouo.emp.mapper.dataobject.NoticeDO;

/**
* @author cliouo
* @description 针对表【system_notice(公告表)】的数据库操作Mapper
* @createDate 2023-09-19 22:24:15
* @Entity top.cliouo.emp.mapper.dataobject.NoticeDO
*/
public interface NoticeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NoticeDO record);

    int insertSelective(NoticeDO record);

    NoticeDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoticeDO record);

    int updateByPrimaryKey(NoticeDO record);

}
