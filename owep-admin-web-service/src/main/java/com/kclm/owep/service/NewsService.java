package com.kclm.owep.service;

import com.kclm.owep.dto.NewsDTO;
import com.kclm.owep.entity.News;

import java.io.Serializable;
import java.util.List;

public interface NewsService {

    List<NewsDTO> getAllNews();

    void delete(Serializable id);

    void deleteSelect(List<Serializable> ids);

    //返回代码为1表示成功，-1表示不存在教师，0表示其他错误
    int save(News news);

    //返回代码为1表示成功，-1表示不存在教师，0表示其他错误
    int update(NewsDTO newsDTO);
}
