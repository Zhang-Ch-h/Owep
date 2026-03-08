package com.kclm.owep.mapper;

import com.kclm.owep.entity.Course;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    List<Course> selectByPlanId(Integer planId);

    List<Course> selectCourseByClassId(@Param("classId") Integer classId);
}
