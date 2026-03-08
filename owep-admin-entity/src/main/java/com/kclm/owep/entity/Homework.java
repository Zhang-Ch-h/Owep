/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/*********************
 * @Author: tanj
 * @Version : v1.0
 * @Create: 2020年7月03日 上午10:10:40
 * @Description 班级作业
 */
public class Homework implements Serializable {
    private Integer id;  //作业id

    private String workTitle;   //作业标题

    private String workContent;  //作业描述

    private Chapter chapter;    //章

    private Section section; //课程列表中的节表

    private Course course;   //课程

    private Clazz clazz; //班级

    private String workFileName; //作业文件

    private Integer workStatus; //作业状态，1表示已批阅，0表示未批阅

    private String courseName;  //所属课程名

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime=LocalDateTime.now();    //创建时间

    private Integer version=1;    //版本号

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastAccessTime;    //最后一次访问时间

    public Homework() {
    }

    public Homework(String workTitle, String workContent, Chapter chapter, Section section) {
        this.workTitle = workTitle;
        this.workContent = workContent;
        this.chapter = chapter;
        this.section = section;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String getWorkFileName() {
        return workFileName;
    }

    public void setWorkFileName(String workFileName) {
        this.workFileName = workFileName;
    }

    public Integer getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(Integer workStatus) {
        this.workStatus = workStatus;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Homework homework = (Homework) o;
        return Objects.equals(id, homework.id) &&
                Objects.equals(workTitle, homework.workTitle) &&
                Objects.equals(workContent, homework.workContent) &&
                Objects.equals(chapter, homework.chapter) &&
                Objects.equals(section, homework.section);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workTitle, workContent, chapter, section);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Homework{");
        sb.append("id=").append(id);
        sb.append(", workTitle='").append(workTitle).append('\'');
        sb.append(", workContent='").append(workContent).append('\'');
        sb.append(", workFileName='").append(workFileName).append('\'');
        sb.append(", workStatus=").append(workStatus);
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }
}