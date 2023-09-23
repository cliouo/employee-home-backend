package top.cliouo.emp.service.notice;

import top.cliouo.emp.controller.notice.vo.NoticeAddReqVO;
import top.cliouo.emp.controller.notice.vo.NoticeDetailRespVO;
import top.cliouo.emp.controller.notice.vo.NoticePageReqVO;
import top.cliouo.emp.controller.notice.vo.NoticeUpdateReqVO;
import top.cliouo.emp.mapper.dataobject.NoticeDO;
import top.cliouo.emp.common.PageResult;

public interface NoticeService {

    Object save(NoticeAddReqVO reqVO);

    Object delete(Long id);

    Object modify(Long id, NoticeUpdateReqVO reqVO);

    NoticeDO get(Long id);

    PageResult<NoticeDetailRespVO> noticePage(NoticePageReqVO reqVO);
}
