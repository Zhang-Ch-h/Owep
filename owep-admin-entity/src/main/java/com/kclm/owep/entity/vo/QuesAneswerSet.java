package com.kclm.owep.entity.vo;

public class QuesAneswerSet {
    private Integer id;
    private Integer testQuestionsId;
    private Integer paperId;
    private Integer score;
    private String myTopicOrShareTop;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestQuestionsId() {
        return testQuestionsId;
    }

    public void setTestQuestionsId(Integer testQuestionsId) {
        this.testQuestionsId = testQuestionsId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getMyTopicOrShareTop() {
        return myTopicOrShareTop;
    }

    public void setMyTopicOrShareTop(String myTopicOrShareTop) {
        this.myTopicOrShareTop = myTopicOrShareTop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    @Override
    public String toString() {
        return "QuesAneswerSet{" +
                "id=" + id +
                ", testQuestionsId=" + testQuestionsId +
                ", paperId=" + paperId +
                ", score=" + score +
                ", myTopicOrShareTop='" + myTopicOrShareTop + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
