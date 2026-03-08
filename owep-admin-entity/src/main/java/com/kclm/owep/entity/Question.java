package com.kclm.owep.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/*********************
 * @Author: tanj
 * @Version : v1.0
 * @Create: 2020年7月07日 上午10:10:40
 * @Description 视频问答表
 */
public class Question implements Serializable {
    /***
     * id
     */
   private Integer id;
    /***
     * 问答时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime=LocalDateTime.now();
    /***
     * 问答内容
     */
    private String questionContent;
    /***
     * 问答类型 1. 评论 0 .问题
     */
    private Integer questionType;
    /***
     * 提问者
     */
    private String questionAuthor;
    /***
     * 点赞数
     */
    private Integer favourCount;
    /***
     * 最后一次访问时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastAccessTime;
    /***
     * 版本号
     */
    private Integer version=1;
    /***
     * 视频
     */
    private Video video;
    /**
     * 学员
     */
    private Student student;
    /**
     * 班级
     */
    private Clazz clazz;

    /**
     * 课程
     */
    private Course course;

    public Question() {
    }

    public Question(String questionContent, String questionAuthor) {
        this.questionContent = questionContent;
        this.questionAuthor = questionAuthor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public String getQuestionAuthor() {
        return questionAuthor;
    }

    public void setQuestionAuthor(String questionAuthor) {
        this.questionAuthor = questionAuthor;
    }

    public Integer getFavourCount() {
        return favourCount;
    }

    public void setFavourCount(Integer favourCount) {
        this.favourCount = favourCount;
    }

    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question that = (Question) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(questionContent, that.questionContent) &&
                Objects.equals(questionType, that.questionType) &&
                Objects.equals(questionAuthor, that.questionAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, questionContent, questionType, questionAuthor);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("VideoQuestion{");
        sb.append("id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", questionContent='").append(questionContent).append('\'');
        sb.append(", questionType=").append(questionType);
        sb.append(", questionAuthor='").append(questionAuthor).append('\'');
        sb.append(", favourCount=").append(favourCount);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }
}