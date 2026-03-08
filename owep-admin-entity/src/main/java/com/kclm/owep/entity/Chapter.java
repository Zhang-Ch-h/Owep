/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/3 16:05
 *@Description 章实体类
 *
 */
public class Chapter implements Serializable {
    /**
     *章id
     */
    private Integer id;

    /**
     *章编号
     */
    private String chapterNumber;

    /**
     *章名称
     */
    private String chapterName;

    /**
     *章图片名称
     */
    private String chapterImageUrl;

    /**
     *章状态：0未启用、1启用
     */
    private Integer chapterStatus;

    /**
     *章描述
     */
    private String chapterDesc;

    /**
     *创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     *视频观看状态：0不允许观看、1允许观看
     */
    private Integer videoStatus;

    /**
     *关联课程对象
     */
    private Course course;

    /**
     *逻辑删除 0:未删除 1:已删除
     */
    private Integer isDelete;

    /**
     *版本
     */
    private Integer version = 1;

    /**
     *最后一次访问时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastAccessTime;


    /**
     * 一个章包含多个节
     */
    private List<Section> sectionList;

    /**
     * 空参构造
     */
    public Chapter() {
    }

    public Chapter(String chapterNumber, String chapterName, Integer chapterStatus, LocalDateTime createTime, Integer videoStatus, Course course) {
        this.chapterNumber = chapterNumber;
        this.chapterName = chapterName;
        this.chapterStatus = chapterStatus;
        this.createTime = createTime;
        this.videoStatus = videoStatus;
        this.course = course;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(String chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterImageUrl() {
        return chapterImageUrl;
    }

    public void setChapterImageUrl(String chapterImageUrl) {
        this.chapterImageUrl = chapterImageUrl;
    }

    public Integer getChapterStatus() {
        return chapterStatus;
    }

    public void setChapterStatus(Integer chapterStatus) {
        this.chapterStatus = chapterStatus;
    }

    public String getChapterDesc() {
        return chapterDesc;
    }

    public void setChapterDesc(String chapterDesc) {
        this.chapterDesc = chapterDesc;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getVideoStatus() {
        return videoStatus;
    }

    public void setVideoStatus(Integer videoStatus) {
        this.videoStatus = videoStatus;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
        final StringBuffer sb = new StringBuffer("Chapter{");
        sb.append("id=").append(id);
        sb.append(", chapterNumber='").append(chapterNumber).append('\'');
        sb.append(", chapterName='").append(chapterName).append('\'');
        sb.append(", chapterImageUrl='").append(chapterImageUrl).append('\'');
        sb.append(", chapterStatus=").append(chapterStatus);
        sb.append(", chapterDesc='").append(chapterDesc).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", videoStatus=").append(videoStatus);
        sb.append(", course=").append(course);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return Objects.equals(chapterNumber, chapter.chapterNumber) &&
                Objects.equals(chapterName, chapter.chapterName) &&
                Objects.equals(course, chapter.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chapterNumber, chapterName, course);
    }
}