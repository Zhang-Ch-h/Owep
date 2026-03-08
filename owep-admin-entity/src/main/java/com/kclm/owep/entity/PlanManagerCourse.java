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
 *@Description 方案和课程中间实体类
 *
 */
public class PlanManagerCourse implements Serializable {
    /**
     *方案和课程中间表的主键
     */
    private Integer id;

    /**
     *关联方案
     */
    private PlanManager planManager;

    /**
     *关联课程
     */
    private Course course;

    /**
     *阶段编号
     */
    private Integer stageNum;

    /**
     *阶段名称
     */
    private Integer stageName;

    /**
     *阶段内课程排序
     */
    private Integer courseOrder;

    /**
     *逻辑删除：0未删除、1已删除
     */
    private Integer isDelete;

    /**
     *创建时间
     */
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     *版本
     */
    private Integer version = 1;

    /**
     * 空参构造
     */
    public PlanManagerCourse() {
    }


    /**
     * notnull 属性 构造方法
     * @param planManager
     * @param course
     * @param stageNum
     * @param courseOrder
     */
    public PlanManagerCourse(PlanManager planManager, Course course, Integer stageNum, Integer courseOrder) {
        this.planManager = planManager;
        this.course = course;
        this.stageNum = stageNum;
        this.courseOrder = courseOrder;
    }


    public PlanManager getPlanManager() {
        return planManager;
    }

    public void setPlanManager(PlanManager planManager) {
        this.planManager = planManager;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getStageNum() {
        return stageNum;
    }

    public void setStageNum(Integer stageNum) {
        this.stageNum = stageNum;
    }

    public Integer getStageName() {
        return stageName;
    }

    public void setStageName(Integer stageName) {
        this.stageName = stageName;
    }

    public Integer getCourseOrder() {
        return courseOrder;
    }

    public void setCourseOrder(Integer courseOrder) {
        this.courseOrder = courseOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PlanManagerCourse{");
        sb.append("id=").append(id);
        sb.append(", stageNum=").append(stageNum);
        sb.append(", stageName=").append(stageName);
        sb.append(", courseOrder=").append(courseOrder);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanManagerCourse that = (PlanManagerCourse) o;
        return Objects.equals(planManager, that.planManager) &&
                Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planManager, course);
    }
}