/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
/**
 * author：ZhangQi
 * module：resource
 * description:视频实体，自关联 与视频收藏和观看记录有关联。
 * version：v0.1
 * time：2020/7/3
 */
public class Video implements Serializable {
    private Integer id;
    private long videoSize;/** 视频大小*/
    private int videoCount;/** 课时，即这个课程下有多少节视频*/
    private String videoName;/** 视频名*/
    private Integer type;/** 视频类型*/
    private Video parentDir; /** 视频是有父级文件夹*/
    private Double videoLength;/** 视频时长*/
    private String videoFrom;/** 视频来源*/
    private Integer status;/** 视频状态 1通过 0未审核*/
    private String videoUrl;/** 视频URL*/
    private String videoDesc;/** 视频描述*/
    private Integer delete;/** 视频是否删除 1未删除 0删除*/
    private LocalDateTime createTime=LocalDateTime.now();/** 视频创建时间*/
    private LocalDateTime lastAccessTime;/** 视频最后一次访问时间*/
    private Integer version=1;/** 版本号*/
    private List<Video> childVideos;/** 文件夹下所有子视频*/
    public Video() {
    }

    public Video(long videoSize, int videoCount, String videoName, Integer type, Video parentDir, Double videoLength, String videoFrom, Integer status, String videoUrl, String videoDesc, Integer delete) {
        this.videoSize = videoSize;
        this.videoCount = videoCount;
        this.videoName = videoName;
        this.type = type;
        this.parentDir = parentDir;
        this.videoLength = videoLength;
        this.videoFrom = videoFrom;
        this.status = status;
        this.videoUrl = videoUrl;
        this.videoDesc = videoDesc;
        this.delete = delete;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Video{");
        sb.append("id=").append(id);
        sb.append(", videoSize=").append(videoSize);
        sb.append(", videoCount=").append(videoCount);
        sb.append(", videoName='").append(videoName).append('\'');
        sb.append(", type=").append(type);
        sb.append(", parentDir=").append(parentDir);
        sb.append(", videoLength=").append(videoLength);
        sb.append(", videoFrom='").append(videoFrom).append('\'');
        sb.append(", status=").append(status);
        sb.append(", videoUrl='").append(videoUrl).append('\'');
        sb.append(", videoDesc='").append(videoDesc).append('\'');
        sb.append(", delete=").append(delete);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return Objects.equals(id, video.id) &&
                Objects.equals(videoName, video.videoName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, videoName);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Video getParentDir() {
        return parentDir;
    }

    public void setParentDir(Video parentDir) {
        this.parentDir = parentDir;
    }

    public Double getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(Double videoLength) {
        this.videoLength = videoLength;
    }

    public String getVideoFrom() {
        return videoFrom;
    }

    public void setVideoFrom(String videoFrom) {
        this.videoFrom = videoFrom == null ? null : videoFrom.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc == null ? null : videoDesc.trim();
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
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

    public long getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(long videoSize) {
        this.videoSize = videoSize;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public List<Video> getChildVideos() {
        return childVideos;
    }

    public void setChildVideos(List<Video> childVideos) {
        this.childVideos = childVideos;
    }
}