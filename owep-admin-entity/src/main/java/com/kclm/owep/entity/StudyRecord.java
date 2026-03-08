/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/*********************
 * @Author: ZhongLei
 * @Version : v1.0
 * @Create: 2020年7月03日
 * @Description 学习记录实体类
 */

public class StudyRecord implements Serializable {

    /***
     * 主键
     */
    private Integer id;

    /***
     * 学习进度标识 0:未观看或未观看结束 1:已观看完(只有为2时，才能观看下一个视频）
     */
    private Integer progressStatus;

    /***
     * 创建时间
     */
    private LocalDateTime createTime;

    /***
     * 学员id
     */
    private Integer fkStudentId;

    /***
     * 课程节的id
     */
    private Integer fkSectionId;

    /***
     * 课程名称
     */
    private String courseName;

    /***
     * 章名称
     */
    private String chapterName;

    /***
     * 节名称
     */
    private String sectionName;

    /***
     * 视频观看最大进度
     */
    private Double videoRate;

    /***
     * 视频时长
     */
    private Integer videoLength;

    /***
     * 版本
     */
    private Integer version;

    /***
     * 最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    /***
     * 空参构造
     */
    public StudyRecord() {
    }

    /***
     * 有参构造
     * @param progressStatus
     * @param fkStudentId
     * @param courseName
     */
    public StudyRecord(Integer progressStatus, Integer fkStudentId, String courseName) {
        this.progressStatus = progressStatus;
        this.fkStudentId = fkStudentId;
        this.courseName = courseName;
    }

    /***
     * 全参构造
     * @param id
     * @param progressStatus
     * @param createTime
     * @param fkStudentId
     * @param fkSectionId
     * @param courseName
     * @param chapterName
     * @param sectionName
     * @param videoRate
     * @param videoLength
     * @param version
     * @param lastAccessTime
     */
    public StudyRecord(Integer id, Integer progressStatus, LocalDateTime createTime, Integer fkStudentId, Integer fkSectionId, String courseName, String chapterName, String sectionName, Double videoRate, Integer videoLength, Integer version, LocalDateTime lastAccessTime) {
        this.id = id;
        this.progressStatus = progressStatus;
        this.createTime = createTime;
        this.fkStudentId = fkStudentId;
        this.fkSectionId = fkSectionId;
        this.courseName = courseName;
        this.chapterName = chapterName;
        this.sectionName = sectionName;
        this.videoRate = videoRate;
        this.videoLength = videoLength;
        this.version = version;
        this.lastAccessTime = lastAccessTime;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getProgressStatus() {
        return progressStatus;
    }


    public void setProgressStatus(Integer progressStatus) {
        this.progressStatus = progressStatus;
    }


    public LocalDateTime getCreateTime() {
        return createTime;
    }


    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }


    public Integer getFkStudentId() {
        return fkStudentId;
    }


    public void setFkStudentId(Integer fkStudentId) {
        this.fkStudentId = fkStudentId;
    }


    public Integer getFkSectionId() {
        return fkSectionId;
    }


    public void setFkSectionId(Integer fkSectionId) {
        this.fkSectionId = fkSectionId;
    }


    public String getCourseName() {
        return courseName;
    }


    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }


    public String getChapterName() {
        return chapterName;
    }


    public void setChapterName(String chapterName) {
        this.chapterName = chapterName == null ? null : chapterName.trim();
    }


    public String getSectionName() {
        return sectionName;
    }


    public void setSectionName(String sectionName) {
        this.sectionName = sectionName == null ? null : sectionName.trim();
    }


    public Double getVideoRate() {
        return videoRate;
    }


    public void setVideoRate(Double videoRate) {
        this.videoRate = videoRate;
    }


    public Integer getVideoLength() {
        return videoLength;
    }


    public void setVideoLength(Integer videoLength) {
        this.videoLength = videoLength;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudyRecord)) return false;
        StudyRecord that = (StudyRecord) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getCreateTime(), that.getCreateTime()) &&
                Objects.equals(getCourseName(), that.getCourseName()) &&
                Objects.equals(getChapterName(), that.getChapterName()) &&
                Objects.equals(getSectionName(), that.getSectionName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCreateTime(), getCourseName(), getChapterName(), getSectionName());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudyRecord{");
        sb.append("id=").append(id);
        sb.append(", progressStatus=").append(progressStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", fkStudentId=").append(fkStudentId);
        sb.append(", fkSectionId=").append(fkSectionId);
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", chapterName='").append(chapterName).append('\'');
        sb.append(", sectionName='").append(sectionName).append('\'');
        sb.append(", videoRate=").append(videoRate);
        sb.append(", videoLength=").append(videoLength);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }
}