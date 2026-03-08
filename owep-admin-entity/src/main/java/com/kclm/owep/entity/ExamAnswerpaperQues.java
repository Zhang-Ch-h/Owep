package com.kclm.owep.entity;

import java.io.Serializable;

public class ExamAnswerpaperQues implements Serializable {
    /*
    * 主键
    * */
    private Integer id;

    /*
    * answerpaper_id(fk)
    * */
    private ExamAnswerpaper examAnswerpaper;

    /*
    * 试题题干
    * */
    private String quesContent;

    /*
    * (若为选择，判断)问题的选项
    * */
    private String quesChoice;

    /*
    * 判断是否为正确答案(0为错误，1为正确)
    * */
    private Integer quesStatus;

    /*
    * 标准答案的分数
    * */
    private double quesScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ExamAnswerpaper getExamAnswerpaper() {
        return examAnswerpaper;
    }

    public void setExamAnswerpaper(ExamAnswerpaper examAnswerpaper) {
        this.examAnswerpaper = examAnswerpaper;
    }

    public String getQuesContent() {
        return quesContent;
    }

    public void setQuesContent(String quesContent) {
        this.quesContent = quesContent;
    }

    public String getQuesChoice() {
        return quesChoice;
    }

    public void setQuesChoice(String quesChoice) {
        this.quesChoice = quesChoice;
    }

    public Integer getQuesStatus() {
        return quesStatus;
    }

    public void setQuesStatus(Integer quesStatus) {
        this.quesStatus = quesStatus;
    }

    public double getQuesScore() {
        return quesScore;
    }

    public void setQuesScore(double quesScore) {
        this.quesScore = quesScore;
    }

    @Override
    public String toString() {
        return "ExamAnswerpaperQues{" +
                "id=" + id +
                ", examAnswerpaper=" + examAnswerpaper +
                ", quesContent='" + quesContent + '\'' +
                ", quesChoice='" + quesChoice + '\'' +
                ", quesStatus=" + quesStatus +
                ", quesScore=" + quesScore +
                '}';
    }

    public ExamAnswerpaperQues() {
    }

}
