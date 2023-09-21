package top.cliouo.emp.convert;

import cn.dev33.satoken.stp.SaTokenInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import top.cliouo.emp.controller.vo.UserDetailRespVO;
import top.cliouo.emp.controller.vo.UserLoginRespVO;
import top.cliouo.emp.mapper.dataobject.UserDO;

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
    UserDetailRespVO convert(UserDO userDO);





    // 自定义映射方法
    @Named("timeoutToExpireTime")
    default Date timeoutToExpireTime(long timeout) {
        return new Date(System.currentTimeMillis() + timeout * 1000);
    }

    @Named("faceStatusToBoolean")
    default Boolean faceStatusToBoolean(Integer faceStatus) {
        return faceStatus == 1;
    }


}
