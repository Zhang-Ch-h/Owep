/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.Objects;

/*****
 * @Author WSP
 * @Version v1.0
 * @Create 2020/7/7  9：30
 * @Description 学员学习进度报告实体类
 */
public class StudentReport {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 课程名
     */
    private String courseName;

    /**
     * 章名
     */
    private String chapterName;

    /**
     * 节名
     */
    private String sectionName;

    /**
     * 视频学习时长，单位为秒
     */
    private Integer videoStudyTime;

    /**
     * 作业数量
     */
    private Integer homeworkCount;

    /**
     * 提问数量
     */
    private Integer questionCount;

    /**
     * 请假次数
     */
    private Integer leaveCount;

    /**
     * 违纪次数
     */
    private Integer illegalCount;

    /**
     * 笔记个数
     */
    private Integer noteCount;

    /**
     * 考试次数
     */
    private Integer examCount;

    /**
     * 外键，学员ID
     */
    private Student fkStudent;

    /**
     * 最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    /**
     * 版本号
     */
    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Integer getVideoStudyTime() {
        return videoStudyTime;
    }

    public void setVideoStudyTime(Integer videoStudyTime) {
        this.videoStudyTime = videoStudyTime;
    }

    public Integer getHomeworkCount() {
        return homeworkCount;
    }

    public void setHomeworkCount(Integer homeworkCount) {
        this.homeworkCount = homeworkCount;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
    }

    public Integer getLeaveCount() {
        return leaveCount;
    }

    public void setLeaveCount(Integer leaveCount) {
        this.leaveCount = leaveCount;
    }

    public Integer getIllegalCount() {
        return illegalCount;
    }

    public void setIllegalCount(Integer illegalCount) {
        this.illegalCount = illegalCount;
    }

    public Integer getNoteCount() {
        return noteCount;
    }

    public void setNoteCount(Integer noteCount) {
        this.noteCount = noteCount;
    }

    public Integer getExamCount() {
        return examCount;
    }

    public void setExamCount(Integer examCount) {
        this.examCount = examCount;
    }

    public Student getFkStudent() {
        return fkStudent;
    }

    public void setFkStudent(Student fkStudent) {
        this.fkStudent = fkStudent;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StudentReport{");
        sb.append("id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", chapterName='").append(chapterName).append('\'');
        sb.append(", sectionName='").append(sectionName).append('\'');
        sb.append(", videoStudyTime=").append(videoStudyTime);
        sb.append(", homeworkCount=").append(homeworkCount);
        sb.append(", questionCount=").append(questionCount);
        sb.append(", leaveCount=").append(leaveCount);
        sb.append(", illegalCount=").append(illegalCount);
        sb.append(", noteCount=").append(noteCount);
        sb.append(", examCount=").append(examCount);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentReport that = (StudentReport) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(chapterName, that.chapterName) &&
                Objects.equals(sectionName, that.sectionName) &&
                Objects.equals(videoStudyTime, that.videoStudyTime) &&
                Objects.equals(homeworkCount, that.homeworkCount) &&
                Objects.equals(questionCount, that.questionCount) &&
                Objects.equals(leaveCount, that.leaveCount) &&
                Objects.equals(illegalCount, that.illegalCount) &&
                Objects.equals(noteCount, that.noteCount) &&
                Objects.equals(examCount, that.examCount) &&
                Objects.equals(fkStudent, that.fkStudent) &&
                Objects.equals(lastAccessTime, that.lastAccessTime) &&
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, courseName, chapterName, sectionName, videoStudyTime, homeworkCount, questionCount, leaveCount, illegalCount, noteCount, examCount, fkStudent, lastAccessTime, version);
    }
}