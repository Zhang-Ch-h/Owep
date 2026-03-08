/*********************
 * 2018-2021 版权所有 CopyRight（c）
 */
package com.kclm.owep.dto;

import java.util.List;

/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/13 9:44
 * @Description 授课管理的dto
 */
public class TeachingDTO {

    /**
     * id
     */
    private Integer id;
    /***
     * 班级描述
     */
    private String classDesc;
    /***
     * 资源管理
     */
    private List<ResourceDTO> resourceDTOS;
    /***
     * 课程
     */
    private List<CourseDTO> courseDTOS;
    /***
     * 问题
     */
    private List<QuestionDTO> questionDTOS;
    /***
     * 作业
     */
    private List<HomeworkAnswerDTO> homeworkAnswerDTOS;
    /***
     * 学生评价
     */
    private List<EvaluateDTO> evaluateDTOs;
    /***
     * 请假处理
     */
    private List<LeaveDTO> leaveDTOs;
    /***
     * 违规处理
     */
    private List<IllegalDTO> illegalDTOs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    public List<ResourceDTO> getResourceDTOS() {
        return resourceDTOS;
    }

    public void setResourceDTOS(List<ResourceDTO> resourceDTOS) {
        this.resourceDTOS = resourceDTOS;
    }

    public List<CourseDTO> getCourseDTOS() { return courseDTOS; }

    public void setCourseDTOS(List<CourseDTO> courseDTOS) { this.courseDTOS = courseDTOS; }

    public List<EvaluateDTO> getEvaluateDTOs() {
        return evaluateDTOs;
    }

    public void setEvaluateDTOs(List<EvaluateDTO> evaluateDTOs) {
        this.evaluateDTOs = evaluateDTOs;
    }

    public List<LeaveDTO> getLeaveDTOs() {
        return leaveDTOs;
    }

    public void setLeaveDTOs(List<LeaveDTO> leaveDTOs) {
        this.leaveDTOs = leaveDTOs;
    }

    public List<IllegalDTO> getIllegalDTOs() {
        return illegalDTOs;
    }

    public void setIllegalDTOs(List<IllegalDTO> illegalDTOs) {
        this.illegalDTOs = illegalDTOs;
    }

    public List<QuestionDTO> getQuestionDTOS() {
        return questionDTOS;
    }

    public void setQuestionDTOS(List<QuestionDTO> questionDTOS) {
        this.questionDTOS = questionDTOS;
    }

    public List<HomeworkAnswerDTO> getHomeworkAnswerDTOS() {
        return homeworkAnswerDTOS;
    }

    public void setHomeworkAnswerDTOS(List<HomeworkAnswerDTO> homeworkAnswerDTOS) {
        this.homeworkAnswerDTOS = homeworkAnswerDTOS;
    }


}
