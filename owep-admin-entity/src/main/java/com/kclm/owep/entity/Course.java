/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/3 16:05
 *@Description 课程实体类
 *
 */
public class Course implements Serializable {
    /**
     *课程id
     */
    private Integer id;

    /**
     *课程编号
     */
    private String courseNumber;

    /**
     *课程名称
     */
    private String courseName;

    /**
     *课程开始时间
     */
    private LocalDateTime startTime;

    /**
     *课程结束时间
     */
    private LocalDateTime endTime;

    /**
     *课程学时
     */
    private Integer coursePeriod;

    /**
     *课程是否免费：0表示不免费、1 表示免费
     */
    private Integer free;

    /**
     *课程状态 0未启用、1启用
     */
    private Integer courseStatus;

    /**
     *课程图片
     */
    private String courseImage;

    /**
     *课程描述
     */
    private String courseDesc;

    /**
     *创建时间
     */
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     *视频公开状态：0私有视频、1公开视频
     */
    private Integer courseOpenStatus;

    /**
     *是否允许观看：0不允许观看、1允许观看
     */
    private Integer videoStatus;

    /**
     *是否热门：0不热门、1热门
     */
    private Boolean hot;

    /**
     * 0 表示不监听、1 表示监听
     */
    private Boolean listener;

    /**
     *课程类型
     */
    private String courseType;

    /**
     *关联课程分类对象
     */
    private CourseCategory courseCategory;

    /**
     *此属性有值，代表是从总控平台传送过来的数据
     */
    private String courseSendType;

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
    private LocalDateTime lastAccessTime;

    private List<Chapter> chapterList;

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }

    public Course() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getCoursePeriod() {
        return coursePeriod;
    }

    public void setCoursePeriod(Integer coursePeriod) {
        this.coursePeriod = coursePeriod;
    }

    public Integer getFree() {
        return free;
    }

    public void setFree(Integer free) {
        this.free = free;
    }

    public Integer getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(Integer courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getCourseOpenStatus() {
        return courseOpenStatus;
    }

    public void setCourseOpenStatus(Integer courseOpenStatus) {
        this.courseOpenStatus = courseOpenStatus;
    }

    public Integer getVideoStatus() {
        return videoStatus;
    }

    public void setVideoStatus(Integer videoStatus) {
        this.videoStatus = videoStatus;
    }

    public Boolean getHot() {
        return hot;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    public Boolean getListener() {
        return listener;
    }

    public void setListener(Boolean listener) {
        this.listener = listener;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public CourseCategory getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(CourseCategory courseCategory) {
        this.courseCategory = courseCategory;
    }

    public String getCourseSendType() {
        return courseSendType;
    }

    public void setCourseSendType(String courseSendType) {
        this.courseSendType = courseSendType;
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
        final StringBuffer sb = new StringBuffer("Course{");
        sb.append("id=").append(id);
        sb.append(", courseNumber='").append(courseNumber).append('\'');
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", coursePeriod=").append(coursePeriod);
        sb.append(", courseStatus='").append(courseStatus).append('\'');
        sb.append(", courseImage='").append(courseImage).append('\'');
        sb.append(", courseDesc='").append(courseDesc).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", courseOpenStatus=").append(courseOpenStatus);
        sb.append(", videoStatus=").append(videoStatus);
        sb.append(", hot=").append(hot);
        sb.append(", free=").append(free);
        sb.append(", listener=").append(listener);
        sb.append(", courseType='").append(courseType).append('\'');
        sb.append(", courseSendType='").append(courseSendType).append('\'');
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
        Course course = (Course) o;
        return Objects.equals(courseNumber, course.courseNumber) &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(courseType, course.courseType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseNumber, courseName, courseType);
    }
}