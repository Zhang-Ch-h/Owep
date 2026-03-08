package com.kclm.owep.dto;

import com.kclm.owep.entity.ExamPaperTopic;
import com.kclm.owep.entity.ExamPaperTopicQuesset;

import java.time.LocalDateTime;
import java.util.List;

public class ExamPaperDTO {
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

    /*该试卷的创建者*/
    private String userName;

    /*
     * 试卷名称
     * */
    private String paperName;

    /*
     * 试卷类型
     * */
    private String paperType;

    /*
     * 试卷状态0为禁用，1为正常
     * */
    private Integer paperStatus;

    /*
     *管理权限（0为完全私有，1为只读共享）
     * */
    private Integer paperSecurity;

    /*
     * 试卷总分
     * */
    private double paperTotal;

    //大题集合
    private List<ExamPaperTopic> examPaperTopics;

    //小题集合
    private List<ExamPaperTopicQuesset> examPaperTopicQuessets;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public Integer getPaperStatus() {
        return paperStatus;
    }

    public void setPaperStatus(Integer paperStatus) {
        this.paperStatus = paperStatus;
    }

    public Integer getPaperSecurity() {
        return paperSecurity;
    }

    public void setPaperSecurity(Integer paperSecurity) {
        this.paperSecurity = paperSecurity;
    }

    public double getPaperTotal() {
        return paperTotal;
    }

    public void setPaperTotal(double paperTotal) {
        this.paperTotal = paperTotal;
    }

    public List<ExamPaperTopic> getExamPaperTopics() {
        return examPaperTopics;
    }

    public void setExamPaperTopics(List<ExamPaperTopic> examPaperTopics) {
        this.examPaperTopics = examPaperTopics;
    }

    public List<ExamPaperTopicQuesset> getExamPaperTopicQuessets() {
        return examPaperTopicQuessets;
    }

    public void setExamPaperTopicQuessets(List<ExamPaperTopicQuesset> examPaperTopicQuessets) {
        this.examPaperTopicQuessets = examPaperTopicQuessets;
    }

    @Override
    public String toString() {
        return "ExamPaperDTO{" +
                "id=" + id +
                ", version=" + version +
                ", createTime=" + createTime +
                ", lastAccessTime=" + lastAccessTime +
                ", isDelete=" + isDelete +
                ", userName='" + userName + '\'' +
                ", paperName='" + paperName + '\'' +
                ", paperType='" + paperType + '\'' +
                ", paperStatus=" + paperStatus +
                ", paperSecurity=" + paperSecurity +
                ", paperTotal=" + paperTotal +
                ", examPaperTopics=" + examPaperTopics +
                ", examPaperTopicQuessets=" + examPaperTopicQuessets +
                '}';
    }
}
