/*********************
 * 2018-2021 版权所有 CopyRight（c）
 */
package com.kclm.owep.dto;

import java.time.LocalDateTime;

/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/16 14:20
 * @Description 违纪处理DTO
 */
public class IllegalDTO {
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
    private String studentName;
    /**
     *违规时间
     */
    private LocalDateTime disciplineTime;
    /**
     *情况说明
     */
    private String presentationCondition;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getStuNumber() { return stuNumber; }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDateTime getDisciplineTime() {
        return disciplineTime;
    }

    public void setDisciplineTime(LocalDateTime disciplineTime) {
        this.disciplineTime = disciplineTime;
    }

    public String getPresentationCondition() {
        return presentationCondition;
    }

    public void setPresentationCondition(String presentationCondition) {
        this.presentationCondition = presentationCondition;
    }

    @Override
    public String toString() {
        return "IllegalDTO{" +
                "id=" + id +
                ", stuNumber='" + stuNumber + '\'' +
                ", studentName='" + studentName + '\'' +
                ", disciplineTime=" + disciplineTime +
                ", presentationCondition='" + presentationCondition + '\'' +
                '}';
    }
}
