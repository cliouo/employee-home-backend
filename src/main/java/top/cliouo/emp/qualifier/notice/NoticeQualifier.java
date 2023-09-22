package top.cliouo.emp.qualifier.notice;


import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import top.cliouo.emp.mapper.dataobject.UserDO;
import top.cliouo.emp.service.users.UsersService;

@Component
@RequiredArgsConstructor
public class NoticeQualifier {

    private final UsersService usersService;

    @Named("userIdToNickname")
    public String userIdToNickname(Long id) {
        UserDO userDO = usersService.userDetail(id);
        if(userDO == null){
            return null;
        }
        return userDO.getNickname();
    }
}
