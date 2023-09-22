package top.cliouo.emp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.cliouo.emp.mapper.DeptMapper;
import top.cliouo.emp.mapper.JobMapper;
import top.cliouo.emp.mapper.NoticeMapper;
import top.cliouo.emp.mapper.UserMapper;
import top.cliouo.emp.mapper.dataobject.DeptDO;
import top.cliouo.emp.mapper.dataobject.JobDO;
import top.cliouo.emp.mapper.dataobject.NoticeDO;
import top.cliouo.emp.mapper.dataobject.UserDO;

@SpringBootTest
public class TestDeptMapper {

    @Autowired
    DeptMapper deptMapper;

    @Autowired
    JobMapper jobMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    NoticeMapper noticeMapper;
    @Test
    public void testUserMapper() {
        System.out.println("Hello World!");

        UserDO userDO = userMapper.selectByPrimaryKey(1L);
        System.out.println(userDO);
//        DeptDO deptDO = deptMapper.selectByPrimaryKey(2L);
//        System.out.println(deptDO);
    }
    @Test
    public void testDeptMapper() {
        System.out.println("Hello World!");

//        UserDO userDO = userMapper.selectByPrimaryKey(1L);
//        System.out.println(userDO);
        DeptDO deptDO = deptMapper.selectByPrimaryKey(2L);
        System.out.println(deptDO);
    }
    @Test
    public void testNoticeMapper() {
        System.out.println("Hello World!");

//        UserDO userDO = userMapper.selectByPrimaryKey(1L);
//        System.out.println(userDO);
        NoticeDO noticeDO = noticeMapper.selectByPrimaryKey(1L);
        System.out.println(noticeDO);
    }

}
