/*********************
 * 2018-2021 版权所有 CopyRight（c）
 */
package com.kclm.owep.dto;

import java.time.LocalDateTime;

/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/16 14:19
 * @Description 请假处理DTO
 */
public class LeaveDTO {
    /**
     *主键
     */
    private Integer id;
    /**
     *学生姓名
     */
    private String studentName;
    /**
     *请假时间
     */
    private LocalDateTime leaveTime;
    /**
     *结束时间
     */
    private LocalDateTime leaveEndTime;
    /**
     *请假事由
     */
    private String reasonLeave;
    /**
     *审核状态,1.待审核， 2， 审核通过， 0 未通过
     */
    private Integer approvalStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDateTime getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(LocalDateTime leaveTime) {
        this.leaveTime = leaveTime;
    }

    public LocalDateTime getLeaveEndTime() {
        return leaveEndTime;
    }

    public void setLeaveEndTime(LocalDateTime leaveEndTime) {
        this.leaveEndTime = leaveEndTime;
    }

    public String getReasonLeave() {
        return reasonLeave;
    }

    public void setReasonLeave(String reasonLeave) {
        this.reasonLeave = reasonLeave;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Override
    public String toString() {
        return "LeaveDTO{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", leaveTime=" + leaveTime +
                ", leaveEndTime=" + leaveEndTime +
                ", reasonLeave='" + reasonLeave + '\'' +
                ", approvalStatus=" + approvalStatus +
                '}';
    }
}
