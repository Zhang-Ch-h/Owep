package com.kclm.owep.entity;

import java.io.Serializable;

public class ExamQuesAnswerSet implements Serializable {
    /*
    * 主键
    * */
    private Integer id;

    /*
    * ques_id（fk）
    * */
    private Integer bankId;

    /*
    * 试题类型
    * */
    private String typeName;

    /*
    *答案设置的内容
    * */
    private String answerContent;

    /*
    * 判断答案是否正确(0为false，1为true)
    * */
    private Integer answerStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Integer getAnswerStatus() {
        return answerStatus;
    }

    public void setAnswerStatus(Integer answerStatus) {
        this.answerStatus = answerStatus;
    }

    @Override
    public String toString() {
        return "ExamQuesAnswerSet{" +
                "id=" + id +
                ", bankId=" + bankId +
                ", typeName='" + typeName + '\'' +
                ", answerContent='" + answerContent + '\'' +
                ", answerStatus=" + answerStatus +
                '}';
    }
}
