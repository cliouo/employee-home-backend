package top.cliouo.emp.service.document;

import top.cliouo.emp.common.PageResult;
import top.cliouo.emp.controller.document.vo.DocumentAddReqVO;
import top.cliouo.emp.controller.document.vo.DocumentDetailRespVO;
import top.cliouo.emp.controller.document.vo.DocumentPageReqVO;
import top.cliouo.emp.controller.document.vo.DocumentUpdateReqVO;
import top.cliouo.emp.mapper.dataobject.DocumentDO;

public interface DocumentService {

    Object save(DocumentAddReqVO reqVO);

    Object delete(Long id);

    Object modify(Long id, DocumentUpdateReqVO reqVO);

    DocumentDO get(Long id);

    PageResult<DocumentDetailRespVO> documentPage(DocumentPageReqVO reqVO);
    
}
