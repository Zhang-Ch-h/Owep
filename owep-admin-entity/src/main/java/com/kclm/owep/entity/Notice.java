package com.kclm.owep.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Notice implements Serializable {
    /**
     * 主键
     * @mbg.generated
     */
    private Integer id;

    /**
     * 标题
     * @mbg.generated
     */
    private String noticeTitle;

    /**
     * 内容
     * @mbg.generated
     */
    private String noticeContent;

    /**
     * 发布人
     * @mbg.generated
     */
    private String noticePublisher;

    /**
     * 创建时间
     * @mbg.generated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     * 版本
     * @mbg.generated
     */
    private Integer version = 1;

    /**
     * 最后访问时间
     * @mbg.generated
     */
    private LocalDateTime lastAccessTime;

    /**
     * 状态，是否被访问
     * @mbg.generated
     */
    private Integer noticeStatus;

    public Notice() {
    }

    public Notice(Integer id, String noticeTitle, String noticeContent, String noticePublisher,
                  LocalDateTime createTime, Integer version, LocalDateTime lastAccessTime, Integer noticeStatus) {
        this.id = id;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticePublisher = noticePublisher;
        this.createTime = createTime;
        this.version = version;
        this.lastAccessTime = lastAccessTime;
        this.noticeStatus = noticeStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public String getNoticePublisher() {
        return noticePublisher;
    }

    public void setNoticePublisher(String noticePublisher) {
        this.noticePublisher = noticePublisher == null ? null : noticePublisher.trim();
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

    public Integer getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(Integer noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticePublisher='" + noticePublisher + '\'' +
                ", lastAccessTime=" + lastAccessTime +
                ", noticeStatus=" + noticeStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notice notice = (Notice) o;
        return Objects.equals(id, notice.id) &&
                Objects.equals(noticeTitle, notice.noticeTitle) &&
                Objects.equals(noticeContent, notice.noticeContent) &&
                Objects.equals(noticePublisher, notice.noticePublisher) &&
                Objects.equals(createTime, notice.createTime) &&
                Objects.equals(version, notice.version) &&
                Objects.equals(lastAccessTime, notice.lastAccessTime) &&
                Objects.equals(noticeStatus, notice.noticeStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, noticeTitle, noticeContent, noticePublisher, createTime, version, lastAccessTime, noticeStatus);
    }
}