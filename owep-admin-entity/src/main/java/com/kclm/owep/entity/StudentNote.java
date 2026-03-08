/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.Objects;

/*****
 * @Author WSP
 * @Version v1.0
 * @Create 2020/7/7  9：50
 * @Description 学员笔记实体类
 */
public class StudentNote {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 笔记标题
     */
    private String noteTitle;

    /**
     * 笔记简要内容
     */
    private String noteContent;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 外键，学员ID
     */
    private Student fkStudent;

    /**
     * 外键，属性哪一门做的笔记
     */
    private Course fkCourse;

    /**
     * 外键，在看哪一个视频时做的笔记
     */
    private Video fkVideo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
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

    public Student getFkStudent() {
        return fkStudent;
    }

    public void setFkStudent(Student fkStudent) {
        this.fkStudent = fkStudent;
    }

    public Course getFkCourse() {
        return fkCourse;
    }

    public void setFkCourse(Course fkCourse) {
        this.fkCourse = fkCourse;
    }

    public Video getFkVideo() {
        return fkVideo;
    }

    public void setFkVideo(Video fkVideo) {
        this.fkVideo = fkVideo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StudentNote{");
        sb.append("id=").append(id);
        sb.append(", noteTitle='").append(noteTitle).append('\'');
        sb.append(", noteContent='").append(noteContent).append('\'');
        sb.append(", createTime=").append(createTime);
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
        StudentNote that = (StudentNote) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(noteTitle, that.noteTitle) &&
                Objects.equals(noteContent, that.noteContent) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(lastAccessTime, that.lastAccessTime) &&
                Objects.equals(version, that.version) &&
                Objects.equals(fkStudent, that.fkStudent) &&
                Objects.equals(fkCourse, that.fkCourse) &&
                Objects.equals(fkVideo, that.fkVideo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, noteTitle, noteContent, createTime, lastAccessTime, version, fkStudent, fkCourse, fkVideo);
    }
}