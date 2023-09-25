package top.cliouo.emp.controller.document;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.cliouo.emp.common.PageResult;
import top.cliouo.emp.controller.document.vo.DocumentAddReqVO;
import top.cliouo.emp.controller.document.vo.DocumentDetailRespVO;
import top.cliouo.emp.controller.document.vo.DocumentPageReqVO;
import top.cliouo.emp.controller.document.vo.DocumentUpdateReqVO;
import top.cliouo.emp.convert.DocumentConvert;
import top.cliouo.emp.service.document.DocumentService;

@RestController
@RequestMapping("document")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @Autowired
    DocumentConvert documentConvert;

    @GetMapping("{id}")
    public DocumentDetailRespVO get(@PathVariable Long id){
        return documentConvert.convert(documentService.get(id));
    }

    @GetMapping
    public PageResult<DocumentDetailRespVO> page(@Valid DocumentPageReqVO reqVO){
        return documentService.documentPage(reqVO);
    }

    @PostMapping
    public Object add(@RequestBody @Valid DocumentAddReqVO reqVO){
        return documentService.save(reqVO);
    }

    @PutMapping("{id}")
    public Object update(@PathVariable Long id, @RequestBody @Valid DocumentUpdateReqVO reqVO){
        return documentService.modify(id, reqVO);
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable Long id){
        return documentService.delete(id);
    }
}
