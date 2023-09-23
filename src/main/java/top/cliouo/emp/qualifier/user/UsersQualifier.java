package top.cliouo.emp.qualifier.user;


import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import top.cliouo.emp.mapper.dataobject.UserDO;
import top.cliouo.emp.service.users.UsersService;

@Component
@RequiredArgsConstructor
public class UsersQualifier {

    private final UsersService usersService;

    @Named("userIdToCreator")
    public String userIdToCreator(Long id) {
        UserDO userDO = usersService.userDetail(id);
        if(userDO == null){
            return null;
        }
        return userDO.getNickname();
    }
}
