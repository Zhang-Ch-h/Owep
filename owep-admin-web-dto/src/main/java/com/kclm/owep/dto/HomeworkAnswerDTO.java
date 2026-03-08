/*********************
 * 2018-2021 版权所有 CopyRight（c）
 */
package com.kclm.owep.dto;

import java.time.LocalDateTime;

/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/17 10:13
 * @Description 作业答案DTO
 */
public class HomeworkAnswerDTO {

    private Integer id;



    /**
     * 作业标题
     */
    private String workTitle;
    /**
     * 作业内容
     */
    private String workContent;
    /**
     * 学生答案
     */
    private String answerContent;
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 写作时间
     */
    private LocalDateTime createTime;
//    布置时间
    private LocalDateTime startTime;

    //审批内容
    private String auditContent;

    public String getAuditContent() {
        return auditContent;
    }

    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "HomeworkAnswerDTO{" +
                "workTitle='" + workTitle + '\'' +
                ", workContent='" + workContent + '\'' +
                ", answerContent='" + answerContent + '\'' +
                ", studentName='" + studentName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
