package com.kclm.owep.mapper;

import com.kclm.owep.entity.Question;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

    List<Question> selectAllQuestion();

    List<Question> selectQuestionByKeyword(@Param("classId") Integer classId, @Param("courseId") Integer courseId);
}
