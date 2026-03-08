package com.kclm.owep.mapper;

import com.kclm.owep.entity.Chapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChapterMapper extends com.kclm.owep.mapper.common.BaseMapper<com.kclm.owep.entity.Chapter>{

    List<Chapter> selectAllByCourseId(@Param("courseId") Integer courseId);
}
