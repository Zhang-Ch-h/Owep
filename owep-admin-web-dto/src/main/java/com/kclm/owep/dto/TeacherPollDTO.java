/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.dto;

import com.kclm.owep.entity.PollRecord;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/13 10:56
 *@Description:教师考评DTO层
 ***/
public class TeacherPollDTO implements Serializable {

    /***
     * 主键
     */
    private Integer id;

    /***
     * 老师名称
     */
    private String teacherName;

    /***
     * 班级名称
     */
    private String className;

    /***
     * 考评地址
     */
    private String pollAddress;

    /***
     * 考评成绩
     */
    private String pollGrade;

    /***
     * 有效期
     */
    private LocalDateTime effectiveTime;

    /***
     * 考评状态 1:未开始 2:进行中 3:已结束(未审核) 4:已结束(已审核)
     */
    private String pollStatus;

    /***
     * 考评人数
     */
    private Integer pollCount;

    /***
     * 考评建议
     */
    private String pollSuggest;

    /***
     * 模板id
     */
    private Integer fkTemplateId;

    /***
     * 用户id
     */
    private Integer fkUserId;

    /***
     * 班级id
     */
    private Integer fkClassId;

    /***
     * 允许ipi地址
     */
    private String allowIp;

    /***
     * 是否限定IP网段   1.表示限定 0.表示不限定
     */
    private Integer ipLimit;

    /***
     * 开始时间
     */
    private LocalDateTime startTime;

    /***
     * 结束时间
     */
    private LocalDateTime endTime;

    /***
     * 考评记录
     */
    private List<PollRecord> pollRecordList;

    /***
     * 空参构造
     */
    public TeacherPollDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPollAddress() {
        return pollAddress;
    }

    public void setPollAddress(String pollAddress) {
        this.pollAddress = pollAddress;
    }

    public String getPollGrade() {
        return pollGrade;
    }

    public void setPollGrade(String pollGrade) {
        this.pollGrade = pollGrade;
    }

    public LocalDateTime getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(LocalDateTime effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getPollStatus() {
        return pollStatus;
    }

    public void setPollStatus(String pollStatus) {
        this.pollStatus = pollStatus;
    }

    public Integer getPollCount() {
        return pollCount;
    }

    public void setPollCount(Integer pollCount) {
        this.pollCount = pollCount;
    }

    public String getPollSuggest() {
        return pollSuggest;
    }

    public void setPollSuggest(String pollSuggest) {
        this.pollSuggest = pollSuggest;
    }

    public Integer getFkTemplateId() {
        return fkTemplateId;
    }

    public void setFkTemplateId(Integer fkTemplateId) {
        this.fkTemplateId = fkTemplateId;
    }

    public Integer getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(Integer fkUserId) {
        this.fkUserId = fkUserId;
    }

    public Integer getFkClassId() {
        return fkClassId;
    }

    public void setFkClassId(Integer fkClassId) {
        this.fkClassId = fkClassId;
    }

    public String getAllowIp() {
        return allowIp;
    }

    public void setAllowIp(String allowIp) {
        this.allowIp = allowIp;
    }

    public Integer getIpLimit() {
        return ipLimit;
    }

    public void setIpLimit(Integer ipLimit) {
        this.ipLimit = ipLimit;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<PollRecord> getPollRecordList() {
        return pollRecordList;
    }

    public void setPollRecordList(List<PollRecord> pollRecordList) {
        this.pollRecordList = pollRecordList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherPollDTO)) return false;
        TeacherPollDTO that = (TeacherPollDTO) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTeacherName(), that.getTeacherName()) &&
                Objects.equals(getClassName(), that.getClassName()) &&
                Objects.equals(getPollAddress(), that.getPollAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTeacherName(), getClassName(), getPollAddress());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TeacherPollDTO{");
        sb.append("id=").append(id);
        sb.append(", teacherName='").append(teacherName).append('\'');
        sb.append(", className='").append(className).append('\'');
        sb.append(", pollAddress='").append(pollAddress).append('\'');
        sb.append(", pollGrade='").append(pollGrade).append('\'');
        sb.append(", effectiveTime=").append(effectiveTime);
        sb.append(", pollStatus='").append(pollStatus).append('\'');
        sb.append(", pollCount=").append(pollCount);
        sb.append(", pollSuggest='").append(pollSuggest).append('\'');
        sb.append(", fkTemplateId=").append(fkTemplateId);
        sb.append(", fkUserId=").append(fkUserId);
        sb.append(", fkClassId=").append(fkClassId);
        sb.append(", allowIp='").append(allowIp).append('\'');
        sb.append(", ipLimit=").append(ipLimit);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append('}');
        return sb.toString();
    }
}
