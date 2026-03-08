/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/3 16:05
 *@Description 方案实体类
 *
 */
public class PlanManager implements Serializable {
    /**
     * 主键 方案id
     */
    private Integer id;

    /**
     * 方案编号
     */
    private String planNumber;

    /**
     *方案名称
     */
    private String planName;

    /**
     *方案状态：0未启用、1未启用
     */
    private Integer planStatus;

    /**
     *方案描述
     */
    private String planDesc;

    /**
     *逻辑删除：0、未删除、1已删除
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
     *最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    /**
     * 空参构造
     */
    public PlanManager() {
    }


    /**
     * notnull 属性构造
     * @param planNumber
     * @param planName
     * @param planStatus
     * @param planDesc
     */
    public PlanManager(String planNumber, String planName, Integer planStatus, String planDesc) {
        this.planNumber = planNumber;
        this.planName = planName;
        this.planStatus = planStatus;
        this.planDesc = planDesc;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanNumber() {
        return planNumber;
    }

    public void setPlanNumber(String planNumber) {
        this.planNumber = planNumber;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Integer getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(Integer planStatus) {
        this.planStatus = planStatus;
    }

    public String getPlanDesc() {
        return planDesc;
    }

    public void setPlanDesc(String planDesc) {
        this.planDesc = planDesc;
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

    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PlanManager{");
        sb.append("主键id=").append(id);
        sb.append(", 方案编号='").append(planNumber).append('\'');
        sb.append(", 方案名称='").append(planName).append('\'');
        sb.append(", 方案状态=").append(planStatus);
        sb.append(", 方案描述='").append(planDesc).append('\'');
        sb.append(", 逻辑删除=").append(isDelete);
        sb.append(", 创建时间=").append(createTime);
        sb.append(", 版本=").append(version);
        sb.append(",最后一次访问时间 =").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanManager that = (PlanManager) o;
        return Objects.equals(planNumber, that.planNumber) &&
                Objects.equals(planName, that.planName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planNumber, planName);
    }
}