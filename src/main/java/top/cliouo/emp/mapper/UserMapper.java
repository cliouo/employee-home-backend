package top.cliouo.emp.mapper;

import top.cliouo.emp.mapper.dataobject.UserDO;

/**
* @author cliouo
* @description 针对表【system_user(用户表)】的数据库操作Mapper
* @createDate 2023-09-21 10:28:33
* @Entity top.cliouo.emp.mapper.dataobject.UserDO
*/
public interface UserMapper {

    UserDO selectByUsername(String username);

    int deleteByPrimaryKey(Long id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

}
