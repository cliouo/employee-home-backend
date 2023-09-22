package top.cliouo.emp.convert;

import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import top.cliouo.emp.controller.notice.vo.NoticeAddReqVO;
import top.cliouo.emp.controller.notice.vo.NoticeDetailRespVO;
import top.cliouo.emp.controller.notice.vo.NoticeUpdateReqVO;
import top.cliouo.emp.mapper.dataobject.NoticeDO;
import top.cliouo.emp.qualifier.notice.NoticeQualifier;

import top.cliouo.emp.util.PageResult;


@Mapper(componentModel = "spring", uses = NoticeQualifier.class)
public interface NoticeConvert {
    NoticeDO convert(NoticeAddReqVO reqVO);

    NoticeDO convert(NoticeUpdateReqVO reqVO);

    @Mappings({
            @Mapping(source = "userId", target = "nickname", qualifiedByName = "userIdToNickname")
    })
    NoticeDetailRespVO convert(NoticeDO noticeDO);

    PageResult<NoticeDetailRespVO> convertPage(PageInfo<NoticeDO> page);

}
