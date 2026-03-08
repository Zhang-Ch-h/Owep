/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/*********************
 * @Author: tanj
 * @Version : v1.0
 * @Create: 2020年7月03日 上午10:10:40
 * @Description 班级
 */
public class Clazz implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 班级编号
     */
    private String classNumber;

    /***
     * 班级名称
     */
    private String className;

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

    /***
     * 专业管理
     */
    private Profession profession;

    /***
     * 是否删除（1：未删除 0：已删除）
     */
    private Integer isDelete=1;

    /***
     * 版本号
     */
    private Integer version=1;

    /***
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime=LocalDateTime.now();

    /***
     * 最后一次访问时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastAccessTime;

    /***
     * 旧的班级名称
     */
    private String oldClassName;

    /***
     * 旧的班级编号
     */
    private String oldClassNum;

    /***
     * 资源管理
     */
    private List<Resource> resourceList;

    /***
     * 方案
     */
    private List<PlanManager> planManagerList;

    private List<Student> students;

    public Clazz() {
    }

    public Clazz(String classNumber, String className, LocalDate startTime, LocalDate endTime, Integer classStatus, String instituteName, String branchName, Profession profession) {
        this.classNumber = classNumber;
        this.className = className;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classStatus = classStatus;
        this.instituteName = instituteName;
        this.branchName = branchName;
        this.profession = profession;
    }

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

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
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

    public String getOldClassName() {
        return oldClassName;
    }

    public void setOldClassName(String oldClassName) {
        this.oldClassName = oldClassName;
    }

    public String getOldClassNum() {
        return oldClassNum;
    }

    public void setOldClassNum(String oldClassNum) {
        this.oldClassNum = oldClassNum;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> student) {
        this.students = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clazz clazz = (Clazz) o;
        return Objects.equals(id, clazz.id) &&
                Objects.equals(classNumber, clazz.classNumber) &&
                Objects.equals(className, clazz.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classNumber, className);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Clazz{");
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
        sb.append(", delete=").append(isDelete);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", oldClassName='").append(oldClassName).append('\'');
        sb.append(", oldClassNum='").append(oldClassNum).append('\'');
        sb.append('}');
        return sb.toString();
    }
}