/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/3 16:05
 *@Description 学生对课程评价的实体类
 *
 */
public class CourseComment implements Serializable {
    /**
     *课程评论id
     */
    private Integer id;

    /**
     *课程评价内容
     */
    private String commentContent;

    /**
     *创建时间
     */
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     *最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    /**
     *版本
     */
    private Integer version = 1;

    /**
     *关联学生对象
     */
    private Student student;

    /**
     *关联课程对象
     */
    private Course course;

    public CourseComment() {
    }

    public CourseComment(String commentContent, LocalDateTime createTime, Student student, Course course) {
        this.commentContent = commentContent;
        this.createTime = createTime;
        this.student = student;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CourseComment{");
        sb.append("id=").append(id);
        sb.append(", commentContent='").append(commentContent).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseComment that = (CourseComment) o;
        return Objects.equals(commentContent, that.commentContent) &&
                Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentContent, student);
    }
}