package com.kclm.owep.service;

import com.kclm.owep.entity.Notice;

import java.io.Serializable;
import java.util.List;

public interface NoticeService {

    List<Notice> getAllNotice();

    void updateStatus(List<Serializable> ids);

    void delete(Serializable id);

    void deleteSelect(List<Serializable> ids);

    //返回代码为1表示成功，-1表示不存在教师，0表示其他错误
    int save(Notice notice);

    //返回代码为1表示成功，-1表示不存在教师，0表示其他错误
    int update(Notice notice);
}
