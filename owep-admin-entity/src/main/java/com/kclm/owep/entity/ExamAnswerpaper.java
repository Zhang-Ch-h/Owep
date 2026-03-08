package com.kclm.owep.entity;

import java.io.Serializable;

public class ExamAnswerpaper implements Serializable {

    /*
    * 主键ID
    * */
    private Integer id;

    /*
    * 是否已经逻辑删除，1表示未删除，0表示已删除
    * */
    private Integer isDelete;

    /*
    * user_id (fk)
    * */
    private User user;

    /*
    * exam_id(fk)
    * */
    private Exam exam;

    /*
    * 考试名称
    * */
    private String examName;

    /*
    * 试卷名称
    * */
    private String paperName;

    /*
    * 大题名称
    * */
    private String topicName;

    /*
    * 考生答案
    * */
    private String userAnswer;

    /*
    * 标准答案
    * */
    private String quesAnswer;

    /*
    * 考生单题得分
    * */
    private double answerScore;

    /*
    * 单题的总分
    * */
    private double quesScore;

    /*
    * 批改状态（0为未批改，1为已批改）
    * */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getQuesAnswer() {
        return quesAnswer;
    }

    public void setQuesAnswer(String quesAnswer) {
        this.quesAnswer = quesAnswer;
    }

    public double getAnswerScore() {
        return answerScore;
    }

    public void setAnswerScore(double answerScore) {
        this.answerScore = answerScore;
    }

    public double getQuesScore() {
        return quesScore;
    }

    public void setQuesScore(double quesScore) {
        this.quesScore = quesScore;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ExamAnswerpaper{" +
                "id=" + id +
                ", isDelete=" + isDelete +
                ", user=" + user +
                ", exam=" + exam +
                ", examName='" + examName + '\'' +
                ", paperName='" + paperName + '\'' +
                ", topicName='" + topicName + '\'' +
                ", userAnswer='" + userAnswer + '\'' +
                ", quesAnswer='" + quesAnswer + '\'' +
                ", answerScore=" + answerScore +
                ", quesScore=" + quesScore +
                ", status=" + status +
                '}';
    }

    public ExamAnswerpaper() {
    }

}
