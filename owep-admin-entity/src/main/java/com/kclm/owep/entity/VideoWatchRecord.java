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
 * @Description 视频观看记录
 */

public class VideoWatchRecord implements Serializable {

    /***
     * 观看绝对历史id
     */
    private Integer id;

    /***
     * 开始时间
     */
    private LocalDateTime startTime;

    /***
     * 开始位置（记录第几章节）
     */
    private String startPosition;

    /***
     * 结束时间
     */
    private LocalDateTime endTime;

    /***
     * 结束位置
     */
    private String endPosition;

    /***
     * 视频id
     */
    private Integer fkVideoId;

    /***
     * 学习记录id
     */
    private Integer fkStudyrecordId;

    /***
     * 当前视频看到的位置，以秒为单位
     */
    private Double currentProgress;

    /***
     * 创建时间
     */
    private LocalDateTime createTime;

    /***
     * 最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    /***
     * 版本
     */
    private Integer version;

    /***
     * 空参构造
     */
    public VideoWatchRecord() {
    }

    /***
     * 有参构造
     * @param startTime
     * @param startPosition
     * @param endTime
     * @param endPosition
     * @param fkVideoId
     */
    public VideoWatchRecord(LocalDateTime startTime, String startPosition, LocalDateTime endTime, String endPosition, Integer fkVideoId) {
        this.startTime = startTime;
        this.startPosition = startPosition;
        this.endTime = endTime;
        this.endPosition = endPosition;
        this.fkVideoId = fkVideoId;
    }

    /***
     * 全参构造
     * @param id
     * @param startTime
     * @param startPosition
     * @param endTime
     * @param endPosition
     * @param fkVideoId
     * @param fkStudyrecordId
     * @param currentProgress
     * @param createTime
     * @param lastAccessTime
     * @param version
     */
    public VideoWatchRecord(Integer id, LocalDateTime startTime, String startPosition, LocalDateTime endTime, String endPosition, Integer fkVideoId, Integer fkStudyrecordId, Double currentProgress, LocalDateTime createTime, LocalDateTime lastAccessTime, Integer version) {
        this.id = id;
        this.startTime = startTime;
        this.startPosition = startPosition;
        this.endTime = endTime;
        this.endPosition = endPosition;
        this.fkVideoId = fkVideoId;
        this.fkStudyrecordId = fkStudyrecordId;
        this.currentProgress = currentProgress;
        this.createTime = createTime;
        this.lastAccessTime = lastAccessTime;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public LocalDateTime getStartTime() {
        return startTime;
    }


    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }


    public String getStartPosition() {
        return startPosition;
    }


    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition == null ? null : startPosition.trim();
    }


    public LocalDateTime getEndTime() {
        return endTime;
    }


    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }


    public String getEndPosition() {
        return endPosition;
    }


    public void setEndPosition(String endPosition) {
        this.endPosition = endPosition == null ? null : endPosition.trim();
    }


    public Integer getFkVideoId() {
        return fkVideoId;
    }


    public void setFkVideoId(Integer fkVideoId) {
        this.fkVideoId = fkVideoId;
    }


    public Integer getFkStudyrecordId() {
        return fkStudyrecordId;
    }


    public void setFkStudyrecordId(Integer fkStudyrecordId) {
        this.fkStudyrecordId = fkStudyrecordId;
    }


    public Double getCurrentProgress() {
        return currentProgress;
    }


    public void setCurrentProgress(Double currentProgress) {
        this.currentProgress = currentProgress;
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


    public Integer getVersion() {
        return version;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoWatchRecord)) return false;
        VideoWatchRecord that = (VideoWatchRecord) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getStartTime(), that.getStartTime()) &&
                Objects.equals(getStartPosition(), that.getStartPosition()) &&
                Objects.equals(getEndTime(), that.getEndTime()) &&
                Objects.equals(getEndPosition(), that.getEndPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStartTime(), getStartPosition(), getEndTime(), getEndPosition());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VideoWatchRecord{");
        sb.append("id=").append(id);
        sb.append(", startTime=").append(startTime);
        sb.append(", startPosition='").append(startPosition).append('\'');
        sb.append(", endTime=").append(endTime);
        sb.append(", endPosition='").append(endPosition).append('\'');
        sb.append(", fkVideoId=").append(fkVideoId);
        sb.append(", fkStudyrecordId=").append(fkStudyrecordId);
        sb.append(", currentProgress=").append(currentProgress);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }
}