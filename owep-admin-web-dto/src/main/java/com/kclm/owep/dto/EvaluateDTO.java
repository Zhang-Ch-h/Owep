/*********************
 * 2018-2021 版权所有 CopyRight（c）
 */
package com.kclm.owep.dto;

import java.time.LocalDateTime;

/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/16 13:53
 * @Description 学生评价DTO
 */
public class EvaluateDTO {
    /**
     *主键
     */
    private Integer id;
    /**
     * 学号
     */
    private String stuNumber;
    /**
     *学生姓名
     */
    private String stuName;
    /**
     * 学生手机号码
     */
    private String stuPhone;
    /**
     * 学生邮箱
     */
    private String stuEmail;
    /**
     * 学生截止有效期限
     */
    private LocalDateTime effectiveDate;
    /**
     * 学生性别，1表示男，0表示女，-1 表示未知
     */
    private Integer gender;
    /**
     *状态,1 表示有效，0表示无效
     */
    private Integer status;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String studentName) {
        this.stuName = studentName;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EvaluateDTO{" +
                "id=" + id +
                ", stuNumber='" + stuNumber + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuPhone='" + stuPhone + '\'' +
                ", stuEmail='" + stuEmail + '\'' +
                ", effectiveDate=" + effectiveDate +
                ", gender=" + gender +
                ", status=" + status +
                '}';
    }
}
