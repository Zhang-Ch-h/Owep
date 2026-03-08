package com.kclm.owep.entity.vo;

import com.kclm.owep.entity.ExamPaper;
import com.kclm.owep.entity.ExamPaperTopic;

import java.util.List;

public class ExamPaperVo {
    private ExamPaper examPaper;
    private List<ExamPaperTopic> topicList;
    private List<TopicKeyAndValue> keyAndValueList;

    public ExamPaper getExamPaper() {
        return examPaper;
    }

    public void setExamPaper(ExamPaper examPaper) {
        this.examPaper = examPaper;
    }

    public List<ExamPaperTopic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<ExamPaperTopic> topicList) {
        this.topicList = topicList;
    }

    public List<TopicKeyAndValue> getKeyAndValueList() {
        return keyAndValueList;
    }

    public void setKeyAndValueList(List<TopicKeyAndValue> keyAndValueList) {
        this.keyAndValueList = keyAndValueList;
    }

    @Override
    public String toString() {
        return "ExamPaperVo{" +
                "examPaper=" + examPaper +
                ", topicList=" + topicList +
                ", keyAndValueList=" + keyAndValueList +
                '}';
    }
}
