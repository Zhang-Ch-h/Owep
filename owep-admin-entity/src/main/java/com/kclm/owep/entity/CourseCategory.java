/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/3 16:05
 *@Description 分类实体类
 *
 */
public class CourseCategory implements Serializable {
    /**
     *课程分类id
     */
    private Integer id;

    /**
     *分类名称
     */
    private String categoryName;

    /**
     *分类描述
     */
    private String categoryDesc;

    /**
     *自关联 上级id
     */
    private CourseCategory courseCategory;

    /**
     *创建时间
     */
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     *逻辑删除 0未删除，1已删除
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

    public CourseCategory() {
    }

    public CourseCategory(String categoryName, String categoryDesc, CourseCategory courseCategory) {
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
        this.courseCategory = courseCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CourseCategory getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(CourseCategory courseCategory) {
        this.courseCategory = courseCategory;
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
        final StringBuffer sb = new StringBuffer("CourseCategory{");
        sb.append("id=").append(id);
        sb.append(", categoryName='").append(categoryName).append('\'');
        sb.append(", categoryDesc='").append(categoryDesc).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", isDelete='").append(isDelete).append('\'');
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseCategory that = (CourseCategory) o;
        return Objects.equals(categoryName, that.categoryName) &&
                Objects.equals(categoryDesc, that.categoryDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName, categoryDesc);
    }
}