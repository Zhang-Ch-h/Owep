package com.kclm.owep.service;

import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.Question;

import java.io.Serializable;
import java.util.List;

public interface QuestionService {

    List<Question> findAllQuestion();

    List<Clazz> findClassByKeyWords(Integer profId, String instituteName, String instituteBranchName);

    List<Course> findAllCourse();

    void deleteQuestion(Integer id);

    void deleteByGroups(List<Serializable> ids);

    List<Question> getQuestionByKeyword(Integer classId, Integer courseId);
}
