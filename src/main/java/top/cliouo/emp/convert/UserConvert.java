package top.cliouo.emp.convert;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.SaTokenInfo;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import top.cliouo.emp.controller.user.vo.UsersAddReqVO;
import top.cliouo.emp.controller.user.vo.UsersDetailRespVO;
import top.cliouo.emp.controller.user.vo.UserLoginRespVO;
import top.cliouo.emp.controller.user.vo.UsersUpdateReqVO;
import top.cliouo.emp.mapper.dataobject.UserDO;
import top.cliouo.emp.util.PageResult;

import java.util.Date;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class); // <2>

    @Mappings({
            @Mapping(source = "userDO.faceStatus", target = "faceStatus",qualifiedByName = "faceStatusToBoolean"),
            @Mapping(source = "tokenInfo.tokenTimeout", target = "tokenExpireTime", qualifiedByName = "timeoutToExpireTime"),
    })
    UserLoginRespVO convert(UserDO userDO, SaTokenInfo tokenInfo);

    @Mappings({
            @Mapping(source = "faceStatus", target = "faceStatus",qualifiedByName = "faceStatusToBoolean"),
    })
    UsersDetailRespVO convert(UserDO userDO);

    @Mappings({
            @Mapping(source = "password", target = "password",qualifiedByName = "passwordToBCrypt"),
    })
    UserDO convert(UsersAddReqVO reqVO);

    @Mappings({
            @Mapping(source = "password", target = "password",qualifiedByName = "passwordToBCrypt"),
    })
    UserDO convert(UsersUpdateReqVO reqVO);

//    @Mappings({
//            @Mapping(source = "total", target = "total",qualifiedByName = "passwordToBCrypt"),
//    })
    PageResult<UsersDetailRespVO> convertPage(PageInfo<UserDO> page);




    // 自定义映射方法
    @Named("timeoutToExpireTime")
    default Date timeoutToExpireTime(long timeout) {
        return new Date(System.currentTimeMillis() + timeout * 1000);
    }

    @Named("faceStatusToBoolean")
    default Boolean faceStatusToBoolean(Integer faceStatus) {
        return faceStatus == 1;
    }

    @Named("passwordToBCrypt")
    default String passwordToBCrypt(String password) {
        return BCrypt.hashpw(password);
    }



}
