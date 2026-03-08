/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.entity.Profession;
import com.kclm.owep.entity.Resource;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/*****************
 *
 * @author tanj
 * @date 2020/7/13 10:34
 * @version v1.0
 * @description 班级dto
 *
 */
public class ClazzDTO{
    /***
     * id
     */
    private Integer id;
    /***
     * 班级编号
     */
    private String classNumber;
    /***
     * 班级名称
     */
    private String className;
    /***
     * 专业管理
     */
    private Profession profession;
    /***
     * 开班时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startTime;

    /***
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endTime;

    /***
     * 启用状态（1：启用 0：未启用）
     */
    private Integer classStatus;

    /***
     * 所属机构
     */
    private String instituteName;

    /***
     * 所属分支
     */
    private String branchName;

    /***
     * 班级描述
     */
    private String classDesc;
    /***
     * 老师名
     */
    private String teacherName;

    private String profName;

    /***
     * 资源管理
     */
    private List<Resource> resourceList;

    /***
     * 方案
     */
    private List<PlanManager> planManagerList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public Integer getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(Integer classStatus) {
        this.classStatus = classStatus;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    public List<PlanManager> getPlanManagerList() {
        return planManagerList;
    }

    public void setPlanManagerList(List<PlanManager> planManagerList) {
        this.planManagerList = planManagerList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClazzDTO clazzDTO = (ClazzDTO) o;
        return Objects.equals(id, clazzDTO.id) &&
                Objects.equals(classNumber, clazzDTO.classNumber) &&
                Objects.equals(className, clazzDTO.className) &&
                Objects.equals(startTime, clazzDTO.startTime) &&
                Objects.equals(endTime, clazzDTO.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classNumber, className, startTime, endTime);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ClazzDTO{");
        sb.append("id=").append(id);
        sb.append(", classNumber='").append(classNumber).append('\'');
        sb.append(", className='").append(className).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", classStatus=").append(classStatus);
        sb.append(", instituteName='").append(instituteName).append('\'');
        sb.append(", branchName='").append(branchName).append('\'');
        sb.append(", classDesc='").append(classDesc).append('\'');
        sb.append(", teacherName='").append(teacherName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
