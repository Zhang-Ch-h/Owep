package com.kclm.owep.mapper;

import com.kclm.owep.entity.TeacherPoll;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

@Mapper
public interface TeacherPollMapper extends BaseMapper<TeacherPoll> {

    void insertByUser(@Param("name") String name, @Param("id") Integer id, @Param("effectiveTime") LocalDateTime effectiveTime);
}