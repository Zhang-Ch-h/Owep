package com.kclm.owep.service.impl;

import com.kclm.owep.convert.NewsConvert;
import com.kclm.owep.dto.NewsDTO;
import com.kclm.owep.entity.News;
import com.kclm.owep.entity.Notice;
import com.kclm.owep.mapper.NewsMapper;
import com.kclm.owep.mapper.NoticeMapper;
import com.kclm.owep.mapper.UserMapper;
import com.kclm.owep.service.NewsService;
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
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NewsConvert newsConvert;

    @Override
    public List<NewsDTO> getAllNews() {
        try {
            List<News> news = newsMapper.selectAll();
            return newsConvert.toNewsDTO(news);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public void delete(Serializable id) {
        try {
            newsMapper.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void deleteSelect(List<Serializable> ids) {
        try {
            newsMapper.deleteSelect(ids);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public int save(News news) {
        try {
            String newsPublisher = news.getNewsPublisher();
            if (userMapper.getUserByTeacherRealName(newsPublisher) == null ||
                    userMapper.getUserByTeacherRealName(newsPublisher).isEmpty()) {
                return -1;
            } else {
                newsMapper.save(news);
                return 1;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return 0;
        }
    }

    @Override
    public int update(NewsDTO newsDTO) {
        try {
            String newsPublisher = newsDTO.getNewsPublisher();
            if (userMapper.getUserByTeacherRealName(newsPublisher) == null ||
                    userMapper.getUserByTeacherRealName(newsPublisher).isEmpty()) {
                return -1;
            } else {
                News news = newsConvert.toNews(newsDTO);
                newsMapper.update(news);
                return 1;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return 0;
        }
    }
}
