/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/13 15:18
 *@Description 课程DTO
 *
 */
public class CourseDTO implements Serializable {

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CourseDTO{");
        sb.append("id=").append(id);
        sb.append(", courseNumber='").append(courseNumber).append('\'');
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", coursePeriod=").append(coursePeriod);
        sb.append(", courseStatus=").append(courseStatus);
        sb.append(", courseImage='").append(courseImage).append('\'');
        sb.append(", courseDesc='").append(courseDesc).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDTO courseDTO = (CourseDTO) o;
        return Objects.equals(id, courseDTO.id) &&
                Objects.equals(courseNumber, courseDTO.courseNumber) &&
                Objects.equals(courseName, courseDTO.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseNumber, courseName);
    }
}
