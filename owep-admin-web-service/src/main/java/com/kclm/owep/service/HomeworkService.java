package com.kclm.owep.service;

import com.kclm.owep.entity.*;

import java.io.Serializable;
import java.util.List;

public interface HomeworkService {

    List<Homework> getAllHomework();

    List<Clazz> getAllClass();

    List<Chapter> getAllChapterByCourseId(Integer courseId);

    List<Course> getCourseByClassId(Integer classId);

    List<Section> getSectionByChapterId(Integer chapterId);

    void save(Homework homework);

    Homework getHomeworkById(Integer homeworkId);

    void updateHomework(Homework homework);

    List<Homework> getHomeworkByCourseId(Integer courseId);

    void deleteHomework(Integer id);

    List<String> getWorkFileNames(List<Serializable> ids);

    void deleteByGroups(List<Serializable> ids);
}
