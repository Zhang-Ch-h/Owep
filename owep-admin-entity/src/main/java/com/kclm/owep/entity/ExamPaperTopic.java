package com.kclm.owep.entity;

import java.io.Serializable;

public class ExamPaperTopic implements Serializable {
    /*
    * 主键
    * */
    private Integer id;

    /*
    * 大题名称
    * */
    private String topicName;

    /*
    * 大题描述
    * */
    private String topicDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    @Override
    public String toString() {
        return "ExamPaperTopic{" +
                "id=" + id +
                ", topicName='" + topicName + '\'' +
                ", topicDesc='" + topicDesc + '\'' +
                '}';
    }

    public ExamPaperTopic() {
    }

}
