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
 * @Description 视频观看历史
 */

public class VideoWatchHistory implements Serializable {

    /***
     * 主键
     */
    private Integer id;

    /***
     * 学员id
     */
    private Integer fkStudyRecordId;

    /***
     * 已观看时间（单位：秒）
     */
    private Double watchPosition;

    /***
     * 创建时间
     */
    private LocalDateTime createTime;

    /***
     * 最后访问时间
     */
    private LocalDateTime lastAccessTime;

    /***
     * 版本
     */
    private Integer version;

    /***
     * 空参构造
     */
    public VideoWatchHistory() {
    }

    public VideoWatchHistory(Integer id) {
        this.id = id;
    }

    /***
     * 带参构造
     * @param id
     * @param fkStudyRecordId
     * @param watchPosition
     * @param createTime
     * @param lastAccessTime
     * @param version
     */
    public VideoWatchHistory(Integer id, Integer fkStudyRecordId, Double watchPosition, LocalDateTime createTime, LocalDateTime lastAccessTime, Integer version) {
        this.id = id;
        this.fkStudyRecordId = fkStudyRecordId;
        this.watchPosition = watchPosition;
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


    public Integer getFkStudyRecordId() {
        return fkStudyRecordId;
    }


    public void setFkStudyRecordId(Integer fkStudyRecordId) {
        this.fkStudyRecordId = fkStudyRecordId;
    }


    public Double getWatchPosition() {
        return watchPosition;
    }


    public void setWatchPosition(Double watchPosition) {
        this.watchPosition = watchPosition;
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
        if (!(o instanceof VideoWatchHistory)) return false;
        VideoWatchHistory that = (VideoWatchHistory) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getWatchPosition(), that.getWatchPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getWatchPosition());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VideoWatchHistory{");
        sb.append("id=").append(id);
        sb.append(", fkStudyRecordId=").append(fkStudyRecordId);
        sb.append(", watchPosition=").append(watchPosition);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }
}