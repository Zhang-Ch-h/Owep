/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/*********************
 * @Author: ZhongLei
 * @Version : v1.0
 * @Create: 2020年7月03日
 * @Description 教师考评实体类
 */

public class TeacherPoll implements Serializable {

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
     * 创建时间
     */
    private LocalDateTime createTime;

    /***
     * 版本
     */
    private Integer version;

    /***
     * 最后访问时间
     */
    private LocalDateTime lastAccessTime;

    /***
     * 考评记录
     */
    private List<PollRecord> pollRecordList;

    /***
     * 空参构造
     */
    public TeacherPoll() {
    }

    /***
     * 有参构造
     */
    public TeacherPoll(String teacherName, String className, String pollAddress, String pollGrade, LocalDateTime effectiveTime, Integer pollCount, String pollSuggest, Integer fkTemplateId, Integer fkUserId, Integer fkClassId, String allowIp, LocalDateTime startTime, LocalDateTime endTime) {
        this.teacherName = teacherName;
        this.className = className;
        this.pollAddress = pollAddress;
        this.pollGrade = pollGrade;
        this.effectiveTime = effectiveTime;
        this.pollCount = pollCount;
        this.pollSuggest = pollSuggest;
        this.fkTemplateId = fkTemplateId;
        this.fkUserId = fkUserId;
        this.fkClassId = fkClassId;
        this.allowIp = allowIp;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /***
     * 全参构造
     * @param id
     * @param teacherName
     * @param className
     * @param pollAddress
     * @param pollGrade
     * @param effectiveTime
     * @param pollStatus
     * @param pollCount
     * @param pollSuggest
     * @param fkTemplateId
     * @param fkUserId
     * @param fkClassId
     * @param allowIp
     * @param ipLimit
     * @param startTime
     * @param endTime
     * @param createTime
     * @param version
     * @param lastAccessTime
     */
    public TeacherPoll(Integer id, String teacherName, String className, String pollAddress, String pollGrade, LocalDateTime effectiveTime, String pollStatus, Integer pollCount, String pollSuggest, Integer fkTemplateId, Integer fkUserId, Integer fkClassId, String allowIp, Integer ipLimit, LocalDateTime startTime, LocalDateTime endTime, LocalDateTime createTime, Integer version, LocalDateTime lastAccessTime) {
        this.id = id;
        this.teacherName = teacherName;
        this.className = className;
        this.pollAddress = pollAddress;
        this.pollGrade = pollGrade;
        this.effectiveTime = effectiveTime;
        this.pollStatus = pollStatus;
        this.pollCount = pollCount;
        this.pollSuggest = pollSuggest;
        this.fkTemplateId = fkTemplateId;
        this.fkUserId = fkUserId;
        this.fkClassId = fkClassId;
        this.allowIp = allowIp;
        this.ipLimit = ipLimit;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createTime = createTime;
        this.version = version;
        this.lastAccessTime = lastAccessTime;
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
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getPollAddress() {
        return pollAddress;
    }

    public void setPollAddress(String pollAddress) {
        this.pollAddress = pollAddress == null ? null : pollAddress.trim();
    }

    public String getPollGrade() {
        return pollGrade;
    }

    public void setPollGrade(String pollGrade) {
        this.pollGrade = pollGrade == null ? null : pollGrade.trim();
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
        this.pollStatus = pollStatus == null ? null : pollStatus.trim();
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
        this.pollSuggest = pollSuggest == null ? null : pollSuggest.trim();
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
        this.allowIp = allowIp == null ? null : allowIp.trim();
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

    public List<PollRecord> getPollRecordList() {
        return pollRecordList;
    }

    public void setPollRecordList(List<PollRecord> pollRecordList) {
        this.pollRecordList = pollRecordList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherPoll)) return false;
        TeacherPoll that = (TeacherPoll) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTeacherName(), that.getTeacherName()) &&
                Objects.equals(getClassName(), that.getClassName()) &&
                Objects.equals(getPollAddress(), that.getPollAddress()) &&
                Objects.equals(getPollGrade(), that.getPollGrade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTeacherName(), getClassName(), getPollAddress(), getPollGrade());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TeacherPoll{");
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
        sb.append(", createTime=").append(createTime);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }
}