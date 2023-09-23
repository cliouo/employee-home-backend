package top.cliouo.emp.service.document;

import cn.dev33.satoken.stp.StpUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cliouo.emp.common.PageResult;
import top.cliouo.emp.controller.document.vo.DocumentAddReqVO;
import top.cliouo.emp.controller.document.vo.DocumentDetailRespVO;
import top.cliouo.emp.controller.document.vo.DocumentPageReqVO;
import top.cliouo.emp.controller.document.vo.DocumentUpdateReqVO;
import top.cliouo.emp.convert.DocumentConvert;
import top.cliouo.emp.exception.ServiceException;
import top.cliouo.emp.mapper.DocumentMapper;
import top.cliouo.emp.mapper.dataobject.DocumentDO;
import top.cliouo.emp.exception.enums.ServiceExceptionCode;
import top.cliouo.emp.mapper.dataobject.EmployeeDO;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    DocumentMapper documentMapper;

    @Autowired
    DocumentConvert documentConvert;

    @Override
    public Object save(DocumentAddReqVO reqVO) {
        DocumentDO documentDO = documentConvert.convert(reqVO);
        documentDO.setUserId(StpUtil.getLoginIdAsLong());
        if(documentMapper.insertSelective(documentDO) != 1){
            throw new ServiceException(ServiceExceptionCode.DOCUMENT_SAVE_ERROR);
        }
        return true;
    }

    @Override
    public Object delete(Long id) {
        checkDocumentExist(id);
        if(documentMapper.deleteByPrimaryKey(id) != 1){
            throw new ServiceException(ServiceExceptionCode.DOCUMENT_DELETE_ERROR);
        }
        return true;
    }

    @Override
    public Object modify(Long id, DocumentUpdateReqVO reqVO) {
        checkDocumentExist(id);
        DocumentDO documentDO = documentConvert.convert(reqVO);
        if (documentMapper.updateByPrimaryKeySelective(documentDO) != 1) {
            throw new ServiceException(ServiceExceptionCode.DOCUMENT_UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public DocumentDO get(Long id) {
        checkDocumentExist(id);
        return documentMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult<DocumentDetailRespVO> documentPage(DocumentPageReqVO reqVO) {
        List<DocumentDO> documentDOS = documentMapper.selectPage(reqVO);
        PageInfo<DocumentDO> page = new PageInfo<>(documentDOS);
        return documentConvert.convert(page);
    }

    public void checkDocumentExist(Long id) {
        if (documentMapper.selectByPrimaryKey(id) == null) {
            throw new ServiceException(ServiceExceptionCode.DOCUMENT_NOT_EXIST);
        }
    }
}
