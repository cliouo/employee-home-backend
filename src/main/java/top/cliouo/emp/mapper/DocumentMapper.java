package top.cliouo.emp.mapper;

import top.cliouo.emp.mapper.dataobject.DocumentDO;

/**
* @author cliouo
* @description 针对表【system_document(文档表)】的数据库操作Mapper
* @createDate 2023-09-19 22:24:15
* @Entity top.cliouo.emp.mapper.dataobject.DocumentDO
*/
public interface DocumentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DocumentDO record);

    int insertSelective(DocumentDO record);

    DocumentDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DocumentDO record);

    int updateByPrimaryKey(DocumentDO record);

}
