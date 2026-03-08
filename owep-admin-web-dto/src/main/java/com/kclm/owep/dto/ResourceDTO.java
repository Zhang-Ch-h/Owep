/******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权。不得复制转发
 *
 */
package com.kclm.owep.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.ResourceType;
import org.springframework.format.annotation.DateTimeFormat;
//import jdk.management.resource.ResourceType;

import java.time.LocalDateTime;

/********
 *@Author WangSP
 *@Version v1.0
 *@Create 2020/7/14  15:10
 *@Description 文件管理数据传输层
 */
public class ResourceDTO implements java.io.Serializable{

    /**
     *资源ID
     */
    private Integer id;

    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 资源类型
     */
    private Integer type;

    /**
     * 资源扩展名
     */
    private String resourceSuffix;

    /**
     * 资源大小
     */
    private Integer resourceSize;

    /**
     * 资源描述
     */
    private String resourceDesc;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 逻辑删除，1.表示未删除，0表示已删除
     */
    private Integer isDelete;

    /**
     * 查询起始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime interviewTimeStart;

    /**
     * 查询结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime interviewTimeEnd;

    /**
     * 资源类型。1.公共资源 0.课程资源
     */
    private ResourceType resourceType;

    /**
     * 课程
     */
    private Course course;

    public ResourceDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getResourceSuffix() {
        return resourceSuffix;
    }

    public void setResourceSuffix(String resourceSuffix) {
        this.resourceSuffix = resourceSuffix;
    }

    public Integer getResourceSize() {
        return resourceSize;
    }

    public void setResourceSize(Integer resourceSize) {
        this.resourceSize = resourceSize;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public LocalDateTime getInterviewTimeStart() {
        return interviewTimeStart;
    }

    public void setInterviewTimeStart(LocalDateTime interviewTimeStart) {
        this.interviewTimeStart = interviewTimeStart;
    }

    public LocalDateTime getInterviewTimeEnd() {
        return interviewTimeEnd;
    }

    public void setInterviewTimeEnd(LocalDateTime interviewTimeEnd) {
        this.interviewTimeEnd = interviewTimeEnd;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ResourceDTO{");
        sb.append("id=").append(id);
        sb.append(", resourceName='").append(resourceName).append('\'');
        sb.append(", type=").append(type);
        sb.append(", resourceSuffix='").append(resourceSuffix).append('\'');
        sb.append(", resourceSize=").append(resourceSize);
        sb.append(", resourceDesc='").append(resourceDesc).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", interviewTimeStart=").append(interviewTimeStart);
        sb.append(", interviewTimeEnd=").append(interviewTimeEnd);
        sb.append(", resourceType=").append(resourceType);
        sb.append(", course=").append(course);
        sb.append('}');
        return sb.toString();
    }
}
