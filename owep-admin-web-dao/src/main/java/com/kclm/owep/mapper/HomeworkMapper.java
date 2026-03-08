package com.kclm.owep.mapper;

import com.kclm.owep.entity.Homework;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface HomeworkMapper extends com.kclm.owep.mapper.common.BaseMapper<com.kclm.owep.entity.Homework> {

    List<Homework> selectHomeworkbByCourseId(Integer courseId);

    List<String> selectWorkFileNames(List<Serializable> ids);
}
