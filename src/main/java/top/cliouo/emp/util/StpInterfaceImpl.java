package top.cliouo.emp.util;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.cliouo.emp.mapper.UserMapper;
import top.cliouo.emp.mapper.dataobject.UserDO;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限加载接口实现类
 */
@Component    // 保证此类被 SpringBoot 扫描，完成 Sa-Token 的自定义权限验证扩展
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    UserMapper userMapper;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {

        // TODO 权限认证有问题！！！

        // 本 list 仅做模拟，实际项目中要根据具体业务逻辑来查询权限
        List<String> list = new ArrayList<String>();
        // 超级管理员
        if (loginId.toString().equals("1")) {
            list.add("*");
        } else {

        }
        return list;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {

        // TODO 权限认证有问题！！！

        Long loginIdAsLong;
        if(loginId instanceof String){
            loginIdAsLong = Long.parseLong((String) loginId);
        }else{
            loginIdAsLong = (Long) loginId;
        }
        UserDO userDO = userMapper.selectByPrimaryKey((Long) loginIdAsLong);
        Integer status = userDO.getStatus();
        List<String> list = new ArrayList<String>();

        // 1为管理员
        if (status == 1) {
            list.add("admin");
            list.add("super-admin");
            list.add("*");
        }else {
            list.add("user");
        }
        return list;
    }

}
