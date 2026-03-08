package com.kclm.owep.dto;

import com.kclm.owep.entity.ExamQuesAnswerSet;

import java.time.LocalDateTime;
import java.util.List;

public class ExamQuesDTO {
    /*
     * 主键id
     * */
    private Integer id;

    /*
     * 版本号
     * */
    private Integer version =1;

    /*
     * 创建时间
     * */
    private LocalDateTime createTime=LocalDateTime.now();

    /*
     * 最后一次访问的时间
     * */
    private LocalDateTime lastAccessTime;

    /*
     * 是否逻辑删除，1表示未删除，0表示已删除
     * */
    private Integer isDelete;

    /*
     * 题库名
     * */
    private String examBankName;

    /**
     * 题库状态
     */
    private int examBankStatus;

    /*
     * 试题类型
     * */
    private String typeName;

    /*
     * 困难难度
     * */
    private String hardLevel;

    /*
     * 来源
     * */
    private String source;

    /*
     * 标签
     * */
    private String lable;

    /*
     * 试题状态，0为禁用，1为正常
     * */
    private Integer status;

    /*
     * 试题题干
     * */
    private String quesContent;

    /**
     * 答案内容
     */
    private List<ExamQuesAnswerSet> answerSetList;

    /**
     * 正确答案
     */
    private String correctAnswer;

    /*
     * 答案解析
     * */
    private String analyze;

    /*
     * 引用次数
     * */
    private Integer useCount;

    /*
     * 创建人
     * */
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getExamBankName() {
        return examBankName;
    }

    public void setExamBankName(String examBankName) {
        this.examBankName = examBankName;
    }

    public int getExamBankStatus() {
        return examBankStatus;
    }

    public void setExamBankStatus(int examBankStatus) {
        this.examBankStatus = examBankStatus;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getHardLevel() {
        return hardLevel;
    }

    public void setHardLevel(String hardLevel) {
        this.hardLevel = hardLevel;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getQuesContent() {
        return quesContent;
    }

    public void setQuesContent(String quesContent) {
        this.quesContent = quesContent;
    }

    public List<ExamQuesAnswerSet> getAnswerSetList() {
        return answerSetList;
    }

    public void setAnswerSetList(List<ExamQuesAnswerSet> answerSetList) {
        this.answerSetList = answerSetList;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getAnalyze() {
        return analyze;
    }

    public void setAnalyze(String analyze) {
        this.analyze = analyze;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "ExamQuesDTO{" +
                "id=" + id +
                ", version=" + version +
                ", createTime=" + createTime +
                ", lastAccessTime=" + lastAccessTime +
                ", isDelete=" + isDelete +
                ", examBankName='" + examBankName + '\'' +
                ", examBankStatus=" + examBankStatus +
                ", typeName='" + typeName + '\'' +
                ", hardLevel='" + hardLevel + '\'' +
                ", source='" + source + '\'' +
                ", lable='" + lable + '\'' +
                ", status=" + status +
                ", quesContent='" + quesContent + '\'' +
                ", answerSetList=" + answerSetList +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", analyze='" + analyze + '\'' +
                ", useCount=" + useCount +
                ", userName='" + userName + '\'' +
                '}';
    }
}
