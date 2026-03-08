package com.kclm.owep.web.controller.classcontroller;

import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.Question;
import com.kclm.owep.entity.ResponseWrapper;
import com.kclm.owep.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.List;

/*******************
 * @Author zch
 * @Description
 */
@RestController
@RequestMapping("/clazz")
@Slf4j
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question")
    public ModelAndView clazzList() {
        return new ModelAndView("/clazz/question");
    }

    @GetMapping("/allQuestion")
    public List<Question> allQuestion() {
        return questionService.findAllQuestion();
    }

    @GetMapping("/getClassByKeyWords")
    public ResponseEntity<ResponseWrapper<Clazz>> getClassByKeyWords(@RequestParam("profId") Integer profId,
                                                                     @RequestParam("instituteName") String instituteName,
                                                                     @RequestParam("instituteBranchName") String instituteBranchName) {
        List<Clazz> classes = questionService.findClassByKeyWords(profId, instituteName, instituteBranchName);
        ResponseWrapper<Clazz> wrapper = new ResponseWrapper<>(classes);
        return ResponseEntity.ok(wrapper); // 这将返回一个通用的包装类实例，其中包含Clazz对象的列表
    }

    @GetMapping("/getAllCourse")
    public ResponseEntity<ResponseWrapper<Course>> getAllCourse() {
        List<Course> courses = questionService.findAllCourse();
        ResponseWrapper<Course> wrapper = new ResponseWrapper<>(courses);
        return ResponseEntity.ok(wrapper);
    }

    @GetMapping("/deleteQuestion")
    public String deleteQuestion(@RequestParam("id") Integer id) {
        questionService.deleteQuestion(id);
        return "成功";
    }

    @PostMapping("/deleteSelectQuestion")
    public String deleteSelectQuestion(@RequestBody List<Serializable> ids) {
        questionService.deleteByGroups(ids);
        return "success";
    }

    @GetMapping("/findQuestionByKeyword")
    public List<Question> findQuestionByKeyword(@RequestParam("classId") Integer classId,
                                                @RequestParam("courseId") Integer courseId) {
        log.debug("courseId: " + courseId);
        log.debug("classId: {}, courseId: {}", classId, courseId);
        return questionService.getQuestionByKeyword(classId, courseId);
    }
}
