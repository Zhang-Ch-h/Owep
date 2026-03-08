package com.kclm.owep.mapper;

import com.kclm.owep.entity.Notice;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

    void updateStatus(List<Serializable> ids);
}
