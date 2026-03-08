package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Exam implements Serializable {

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
    * 修改考试的用户名
    * */
    private String userName;

    /*
    * papar_id (FK)
    */
    private ExamPaper examPaper;

    /*
    * 是否逻辑删除，1表示未删除，0表示已删除
    * */
    private Integer isDelete;

    /*
    * 考试名称
    * */
    private String examName;

    /*
    * 考试类型
    * */
    private String examType;

    /*
    *考试状态，0为禁用，1为正常
    * */
    private Integer examStatus;

    /*
    * 及格分
    * */
    private double passScore;

    /*
    * 试题排序（顺序排序，随机排序）
    * */
    private String testSequecing;

    /*
    *考试展示
    * */
    private String show;

    /*
    * 选项排序
    * */
    private String choiceSequecing;

    /*
    * 可考次数
    * */
    private Integer number;

    /*
    * 考试须知
    * */
    private String notice;

    /*
    * 开考时间
    * */
    private LocalDateTime start;

    /*
    * 结束考试时间
    * */
    private LocalDateTime end;

    /*
    * 考试时间
    * */
    private Integer time;

    /*
    * 成绩公布时间
    * */
    private LocalDateTime scoreAnnouncement;

    /*
    * 参加限制
    * */
    private Integer timeLimit;

    /*
    * 交卷限制
    * */
    private Integer limit;

    /*
    * 答案公布
    * */
    private String  answerAnnouncement;

    /*
    *查看详情
    * */
    private String detail;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ExamPaper getExamPaper() {
        return examPaper;
    }

    public void setExamPaper(ExamPaper examPaper) {
        this.examPaper = examPaper;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public Integer getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(Integer examStatus) {
        this.examStatus = examStatus;
    }

    public double getPassScore() {
        return passScore;
    }

    public void setPassScore(double passScore) {
        this.passScore = passScore;
    }

    public String getTestSequecing() {
        return testSequecing;
    }

    public void setTestSequecing(String testSequecing) {
        this.testSequecing = testSequecing;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getChoiceSequecing() {
        return choiceSequecing;
    }

    public void setChoiceSequecing(String choiceSequecing) {
        this.choiceSequecing = choiceSequecing;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public LocalDateTime getScoreAnnouncement() {
        return scoreAnnouncement;
    }

    public void setScoreAnnouncement(LocalDateTime scoreAnnouncement) {
        this.scoreAnnouncement = scoreAnnouncement;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getAnswerAnnouncement() {
        return answerAnnouncement;
    }

    public void setAnswerAnnouncement(String answerAnnouncement) {
        this.answerAnnouncement = answerAnnouncement;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", version=" + version +
                ", createTime=" + createTime +
                ", lastAccessTime=" + lastAccessTime +
                ", userName='" + userName + '\'' +
                ", examPaper=" + examPaper +
                ", isDelete=" + isDelete +
                ", examName='" + examName + '\'' +
                ", examType='" + examType + '\'' +
                ", examStatus=" + examStatus +
                ", passScore=" + passScore +
                ", testSequecing='" + testSequecing + '\'' +
                ", show='" + show + '\'' +
                ", choiceSequecing='" + choiceSequecing + '\'' +
                ", number=" + number +
                ", notice='" + notice + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", time=" + time +
                ", scoreAnnouncement=" + scoreAnnouncement +
                ", timeLimit=" + timeLimit +
                ", limit=" + limit +
                ", answerAnnouncement='" + answerAnnouncement + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    public Exam() {
    }

}
