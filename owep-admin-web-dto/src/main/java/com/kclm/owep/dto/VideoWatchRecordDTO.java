/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/15 18:01
 *@Description:视频观看记录DTO
 ***/
public class VideoWatchRecordDTO implements Serializable {

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

    public VideoWatchRecordDTO() {
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
        this.startPosition = startPosition;
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
        this.endPosition = endPosition;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoWatchRecordDTO)) return false;
        VideoWatchRecordDTO that = (VideoWatchRecordDTO) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getFkVideoId(), that.getFkVideoId()) &&
                Objects.equals(getFkStudyrecordId(), that.getFkStudyrecordId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFkVideoId(), getFkStudyrecordId());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VideoWatchRecordDTO{");
        sb.append("id=").append(id);
        sb.append(", startTime=").append(startTime);
        sb.append(", startPosition='").append(startPosition).append('\'');
        sb.append(", endTime=").append(endTime);
        sb.append(", endPosition='").append(endPosition).append('\'');
        sb.append(", fkVideoId=").append(fkVideoId);
        sb.append(", fkStudyrecordId=").append(fkStudyrecordId);
        sb.append(", currentProgress=").append(currentProgress);
        sb.append('}');
        return sb.toString();
    }
}
