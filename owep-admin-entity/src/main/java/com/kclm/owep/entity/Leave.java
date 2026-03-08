/*********************
 * 2018-2021 版权所有 CopyRight（c） 快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/6 16:18
 * @Description 请假处理
 */
public class Leave implements Serializable {
    /**
     *主键
     */
    private Integer id;
    /**
     *版本
     */
    private Integer version = 1;
    /**
     *创建时间
     */
    private LocalDateTime createTime = LocalDateTime.now();
    /**
     *最后修改时间
     */
    private LocalDateTime lastAccessTime;
    /**
     *请假时间
     */
    private LocalDateTime leaveTime;
    /**
     *结束时间
     */
    private LocalDateTime endTime;
    /**
     *请假事由
     */
    private String reasonLeave;
    /**
     *审核状态,1.待审核， 2， 审核通过， 0 未通过
     */
    private Integer approvalStatus;
    /**
     *学生外键
     */
    private Student student;
    /**
     *fk_class_id
     */
    private Clazz clazz;
    /**
     *意见
     */
    private String option;
    /**
     *学生姓名
     */
    private String studentName;
    /**
     *请假类型
     */
    private String leaveType;
    /**
     *序号
     */
    private Integer serialNumber;

    public Leave() {
    }

    public Leave(Integer id, LocalDateTime leaveTime, LocalDateTime endTime, String studentName) {
        this.id = id;
        this.leaveTime = leaveTime;
        this.endTime = endTime;
        this.studentName = studentName;
    }

    public Leave(Integer id, LocalDateTime leaveTime, LocalDateTime endTime, Student student, Clazz clazz, String studentName) {
        this.id = id;
        this.leaveTime = leaveTime;
        this.endTime = endTime;
        this.student = student;
        this.clazz = clazz;
        this.studentName = studentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leave leave = (Leave) o;
        return Objects.equals(id, leave.id) &&
                Objects.equals(leaveTime, leave.leaveTime) &&
                Objects.equals(endTime, leave.endTime) &&
                Objects.equals(studentName, leave.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, leaveTime, endTime, studentName);
    }

    @Override
    public String toString() {
        return "Leave{" +
                "id=" + id +
                ", version=" + version +
                ", createTime=" + createTime +
                ", lastAccessTime=" + lastAccessTime +
                ", leaveTime=" + leaveTime +
                ", endTime=" + endTime +
                ", reasonLeave='" + reasonLeave + '\'' +
                ", approvalStatus=" + approvalStatus +
                ", student=" + student +
                ", clazz=" + clazz +
                ", option='" + option + '\'' +
                ", studentName='" + studentName + '\'' +
                ", leaveType='" + leaveType + '\'' +
                ", serialNumber=" + serialNumber +
                '}';
    }

    public Clazz getClazz() { return clazz; }

    public void setClazz(Clazz clazz) { this.clazz = clazz; }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDateTime getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(LocalDateTime leaveTime) {
        this.leaveTime = leaveTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getReasonLeave() {
        return reasonLeave;
    }

    public void setReasonLeave(String reasonLeave) {
        this.reasonLeave = reasonLeave == null ? null : reasonLeave.trim();
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option == null ? null : option.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType == null ? null : leaveType.trim();
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }
}