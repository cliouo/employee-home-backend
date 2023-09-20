package top.cliouo.emp;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.cliouo.emp.controller.vo.UserLoginRespVO;
import top.cliouo.emp.convert.UserConvert;
import top.cliouo.emp.mapper.dataobject.UserDO;

@SpringBootTest
public class TestPwd {

    @Test
    public void testPwd() {
        String plain_password = "123123";
        // 使用方法
        String pw_hash = BCrypt.hashpw(plain_password, BCrypt.gensalt());
        System.out.println("pw_hash" + pw_hash);
        // 使用checkpw方法检查被加密的字符串是否与原始字符串匹配：
        System.out.println(BCrypt.checkpw(plain_password, pw_hash));

        // gensalt方法提供了可选参数 (log_rounds) 来定义加盐多少，也决定了加密的复杂度:
        String strong_salt = BCrypt.gensalt(10);
        String stronger_salt = BCrypt.gensalt(12);

        System.out.println("testPwd");
    }

    @Test
    public void testLombok() {
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        System.out.println("111" + userDO.getId());
        UserLoginRespVO userLoginRespVO = new UserLoginRespVO();
        userLoginRespVO.setId(1L);
        System.out.println("222" + userLoginRespVO.getId());
    }

    @Test
    public void testMapStruct() {
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setUsername("admin");
        UserLoginRespVO userLoginRespVO = UserConvert.INSTANCE.convert(userDO, StpUtil.getTokenInfo());
        System.out.println("333:" + userLoginRespVO.getId());
        System.out.println("444:" + userLoginRespVO.getUsername());
    }

    @Test
    public void testToken() {
        StpUtil.login(1L);
        System.out.println(StpUtil.getTokenInfo());
    }
}
