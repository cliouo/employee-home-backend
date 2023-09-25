package top.cliouo.emp.service.notice;

import cn.dev33.satoken.stp.StpUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cliouo.emp.controller.notice.vo.NoticeAddReqVO;
import top.cliouo.emp.controller.notice.vo.NoticeDetailRespVO;
import top.cliouo.emp.controller.notice.vo.NoticePageReqVO;
import top.cliouo.emp.controller.notice.vo.NoticeUpdateReqVO;
import top.cliouo.emp.convert.NoticeConvert;
import top.cliouo.emp.exception.ServiceException;
import top.cliouo.emp.mapper.NoticeMapper;
import top.cliouo.emp.mapper.dataobject.NoticeDO;
import top.cliouo.emp.common.PageResult;

import top.cliouo.emp.exception.enums.ServiceExceptionCode;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    NoticeMapper noticeMapper;

    @Autowired
    NoticeConvert noticeConvert;
    @Override
    public Object save(NoticeAddReqVO reqVO) {
        NoticeDO noticeDO = noticeConvert.convert(reqVO);
        noticeDO.setUserId(StpUtil.getLoginIdAsLong());
        if(noticeMapper.insertSelective(noticeDO) != 1){
            throw new ServiceException(ServiceExceptionCode.NOTICE_SAVE_ERROR);
        }
        return true;
    }

    @Override
    public Object delete(Long id) {
        checkNoticeExist(id);
        if(noticeMapper.deleteByPrimaryKey(id) != 1){
            throw new ServiceException(ServiceExceptionCode.NOTICE_DELETE_ERROR);
        }
        return true;
    }

    @Override
    public Object modify(Long id, NoticeUpdateReqVO reqVO) {
        checkNoticeExist(id);

        NoticeDO noticeDO = noticeConvert.convert(reqVO);
        noticeDO.setId(id);
        noticeDO.setUserId(StpUtil.getLoginIdAsLong());
        if (noticeMapper.updateByPrimaryKeySelective(noticeDO) != 1) {
            throw new ServiceException(ServiceExceptionCode.NOTICE_UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public NoticeDO get(Long id) {
        checkNoticeExist(id);
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult<NoticeDetailRespVO> noticePage(NoticePageReqVO reqVO) {
        PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize());
        List<NoticeDO> noticeDOS = noticeMapper.selectPage(reqVO);
        PageInfo<NoticeDO> page = new PageInfo(noticeDOS);
        return noticeConvert.convertPage(page);
    }

    private void checkNoticeExist(Long id){
        if(noticeMapper.selectByPrimaryKey(id) == null){
            throw new ServiceException(ServiceExceptionCode.NOTICE_NOT_EXISTS);
        }
    }
}
