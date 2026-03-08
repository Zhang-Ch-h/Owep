package com.kclm.owep.service.impl;

import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.Question;
import com.kclm.owep.mapper.ClazzMapper;
import com.kclm.owep.mapper.CourseMapper;
import com.kclm.owep.mapper.QuestionMapper;
import com.kclm.owep.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*******************
 * @Author zch
 * @Description
 */
@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Question> findAllQuestion() {
        try {
            return questionMapper.selectAllQuestion();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<Clazz> findClassByKeyWords(Integer profId, String instituteName, String instituteBranchName) {
        try {
            return clazzMapper.selectClassByKeyWords(profId, instituteName, instituteBranchName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<Course> findAllCourse() {
        return courseMapper.selectAll();
    }

    @Override
    public void deleteQuestion(Integer id) {
        int i = questionMapper.deleteById(id);
        System.out.println("i: " + i);
    }

    @Override
    public void deleteByGroups(List<Serializable> ids) {
        try {
            questionMapper.deleteSelect(ids);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public List<Question> getQuestionByKeyword(Integer classId, Integer courseId) {
        try {
            return questionMapper.selectQuestionByKeyword(classId, courseId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}
