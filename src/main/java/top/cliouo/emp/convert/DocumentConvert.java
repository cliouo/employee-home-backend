package top.cliouo.emp.convert;

import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import top.cliouo.emp.common.PageResult;
import top.cliouo.emp.controller.document.vo.DocumentAddReqVO;
import top.cliouo.emp.controller.document.vo.DocumentDetailRespVO;
import top.cliouo.emp.controller.document.vo.DocumentUpdateReqVO;
import top.cliouo.emp.controller.notice.vo.NoticeDetailRespVO;
import top.cliouo.emp.mapper.dataobject.DocumentDO;
import top.cliouo.emp.mapper.dataobject.EmployeeDO;
import top.cliouo.emp.mapper.dataobject.NoticeDO;
import top.cliouo.emp.qualifier.user.UsersQualifier;

@Mapper(componentModel = "spring", uses = UsersQualifier.class)
public interface DocumentConvert {
    DocumentDO convert(DocumentAddReqVO reqVO);

    DocumentDO convert(DocumentUpdateReqVO reqVO);

    @Mappings({
            @Mapping(source = "userId", target = "creator", qualifiedByName = "userIdToCreator")
    })
    DocumentDetailRespVO convert(DocumentDO documentDO);

    PageResult<DocumentDetailRespVO> convertPage(PageInfo<DocumentDO> page);

    PageResult<DocumentDetailRespVO> convert(PageInfo<DocumentDO> page);
}
