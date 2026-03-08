/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/3 16:05
 *@Description 课程学习统计实体类
 *
 */
public class CourseReport implements Serializable {
    /**
     *学生课程统计id
     */
    private Integer id;

    /**
     *课程学习总数
     */
    private Integer courseLearnCount;

    /**
     *练习总数
     */
    private Integer practiceCount;

    /**
     *笔记总数
     */
    private Integer notesCount;

    /**
     *签到次数
     */
    private Integer signCount;

    /**
     *提问总次数
     */
    private Integer questionCount;

    /**
     *视频播放次数
     */
    private Integer videoPlayCount;

    /**
     *回答问题次数
     */
    private Integer answerCount;

    /**
     *考试完成次数
     */
    private Integer testCount;

    /**
     *创建时间
     */
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     *作业总数量
     */
    private Integer homeworkCount;

    /**
     *作业完成数量
     */
    private Integer homeworkFinishedCount;

    /**
     *视频总数
     */
    private Integer videoCount;

    /**
     *已学视频总数
     */
    private Integer videoFinishedCount;

    /**
     *关联学生对象
     */
    private Student student;

    /**
     *关联课程对象
     */
    private Course course;

    /**
     *版本
     */
    private Integer version = 1;

    /**
     *最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    public CourseReport() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseLearnCount() {
        return courseLearnCount;
    }

    public void setCourseLearnCount(Integer courseLearnCount) {
        this.courseLearnCount = courseLearnCount;
    }

    public Integer getPracticeCount() {
        return practiceCount;
    }

    public void setPracticeCount(Integer practiceCount) {
        this.practiceCount = practiceCount;
    }

    public Integer getNotesCount() {
        return notesCount;
    }

    public void setNotesCount(Integer notesCount) {
        this.notesCount = notesCount;
    }

    public Integer getSignCount() {
        return signCount;
    }

    public void setSignCount(Integer signCount) {
        this.signCount = signCount;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
    }

    public Integer getVideoPlayCount() {
        return videoPlayCount;
    }

    public void setVideoPlayCount(Integer videoPlayCount) {
        this.videoPlayCount = videoPlayCount;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Integer getTestCount() {
        return testCount;
    }

    public void setTestCount(Integer testCount) {
        this.testCount = testCount;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getHomeworkCount() {
        return homeworkCount;
    }

    public void setHomeworkCount(Integer homeworkCount) {
        this.homeworkCount = homeworkCount;
    }

    public Integer getHomeworkFinishedCount() {
        return homeworkFinishedCount;
    }

    public void setHomeworkFinishedCount(Integer homeworkFinishedCount) {
        this.homeworkFinishedCount = homeworkFinishedCount;
    }

    public Integer getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(Integer videoCount) {
        this.videoCount = videoCount;
    }

    public Integer getVideoFinishedCount() {
        return videoFinishedCount;
    }

    public void setVideoFinishedCount(Integer videoFinishedCount) {
        this.videoFinishedCount = videoFinishedCount;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CourseReport{");
        sb.append("id=").append(id);
        sb.append(", courseLearnCount=").append(courseLearnCount);
        sb.append(", practiceCount=").append(practiceCount);
        sb.append(", notesCount=").append(notesCount);
        sb.append(", signCount=").append(signCount);
        sb.append(", questionCount=").append(questionCount);
        sb.append(", videoPlayCount=").append(videoPlayCount);
        sb.append(", answerCount=").append(answerCount);
        sb.append(", testCount=").append(testCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", homeworkCount=").append(homeworkCount);
        sb.append(", homeworkFinishedCount=").append(homeworkFinishedCount);
        sb.append(", videoCount=").append(videoCount);
        sb.append(", videoFinishedCount=").append(videoFinishedCount);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseReport that = (CourseReport) o;
        return Objects.equals(courseLearnCount, that.courseLearnCount) &&
                Objects.equals(student, that.student) &&
                Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseLearnCount, student, course);
    }
}