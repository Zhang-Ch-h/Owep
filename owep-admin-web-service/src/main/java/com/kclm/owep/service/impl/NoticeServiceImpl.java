package com.kclm.owep.service.impl;

import com.kclm.owep.entity.Notice;
import com.kclm.owep.entity.User;
import com.kclm.owep.mapper.NoticeMapper;
import com.kclm.owep.mapper.UserMapper;
import com.kclm.owep.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*******************
 * @Author zch
 * @Description
 */
@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Notice> getAllNotice() {
        try {
            return noticeMapper.selectAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public void updateStatus(List<Serializable> ids) {
        try {
            noticeMapper.updateStatus(ids);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void delete(Serializable id) {
        try {
            noticeMapper.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void deleteSelect(List<Serializable> ids) {
        try {
            noticeMapper.deleteSelect(ids);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public int save(Notice notice) {
        try {
            String noticePublisher = notice.getNoticePublisher();
            if (userMapper.getUserByTeacherRealName(noticePublisher) == null ||
                    userMapper.getUserByTeacherRealName(noticePublisher).isEmpty()) {
                return -1;
            } else {
                noticeMapper.save(notice);
                return 1;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return 0;
        }
    }

    @Override
    public int update(Notice notice) {
        try {
            String noticePublisher = notice.getNoticePublisher();
            if (userMapper.getUserByTeacherRealName(noticePublisher) == null ||
                    userMapper.getUserByTeacherRealName(noticePublisher).isEmpty()) {
                return -1;
            } else {
                noticeMapper.update(notice);
                return 1;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return 0;
        }
    }
}
