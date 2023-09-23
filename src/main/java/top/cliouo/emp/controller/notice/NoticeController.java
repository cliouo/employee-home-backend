package top.cliouo.emp.controller.notice;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.cliouo.emp.controller.notice.vo.NoticeAddReqVO;
import top.cliouo.emp.controller.notice.vo.NoticeDetailRespVO;
import top.cliouo.emp.controller.notice.vo.NoticePageReqVO;
import top.cliouo.emp.controller.notice.vo.NoticeUpdateReqVO;
import top.cliouo.emp.convert.NoticeConvert;
import top.cliouo.emp.service.notice.NoticeService;
import top.cliouo.emp.common.PageResult;

@RestController
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @Autowired
    NoticeConvert noticeConvert;

    @GetMapping("{id}")
    public NoticeDetailRespVO detail(@PathVariable Long id){
        return noticeConvert.convert(noticeService.get(id));
    }

    @GetMapping
    public PageResult<NoticeDetailRespVO> page(@Valid NoticePageReqVO reqVO){
        return noticeService.noticePage(reqVO);
    }

    @PostMapping
    public Object add(@RequestBody @Valid NoticeAddReqVO reqVO){
        return noticeService.save(reqVO);
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable Long id){
        return noticeService.delete(id);
    }

    @PutMapping("{id}")
    public Object update(@PathVariable Long id, @RequestBody @Valid NoticeUpdateReqVO reqVO){
        return noticeService.modify(id, reqVO);
    }
}
