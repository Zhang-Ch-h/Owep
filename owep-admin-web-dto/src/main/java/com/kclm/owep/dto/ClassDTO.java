/*********************
 * 2018-2021 版权所有 CopyRight（c）
 */
package com.kclm.owep.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kclm.owep.entity.Profession;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/14 8:58
 * @Description 授课管理用班级DTO
 */
public class ClassDTO {
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
     * 所属机构
     */
    private String instituteName;

    /***
     * 所属分支
     */
    private String branchName;

    /***
     * 专业管理
     */
    private Profession profession;

    /***
     * 班级描述
     */
    private String classDesc;

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

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public String getClassDesc() { return classDesc; }

    public void setClassDesc(String classDesc) { this.classDesc = classDesc; }

    @Override
    public String toString() {
        return "ClassDTO{" +
                "id=" + id +
                ", classNumber='" + classNumber + '\'' +
                ", className='" + className + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", instituteName='" + instituteName + '\'' +
                ", branchName='" + branchName + '\'' +
                ", profession=" + profession +
                ", classDesc='" + classDesc + '\'' +
                '}';
    }
}
