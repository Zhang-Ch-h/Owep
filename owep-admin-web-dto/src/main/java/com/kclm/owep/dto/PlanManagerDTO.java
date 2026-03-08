/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.dto;

import java.time.LocalDateTime;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/14 10:54
 *@Description TODO
 *
 */
public class PlanManagerDTO {

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



    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PlanManagerDTO{");
        sb.append("id=").append(id);
        sb.append(", planNumber='").append(planNumber).append('\'');
        sb.append(", planName='").append(planName).append('\'');
        sb.append(", planStatus=").append(planStatus);
        sb.append(", planDesc='").append(planDesc).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanManagerDTO that = (PlanManagerDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(planNumber, that.planNumber) &&
                Objects.equals(planName, that.planName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planNumber, planName);
    }
}
