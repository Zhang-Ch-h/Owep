package com.kclm.owep.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class News implements Serializable {
    /**
     * 主键
     * @mbg.generated
     */
    private Integer id;

    /**
     * 新闻标题
     * @mbg.generated
     */
    private String newsTitle;

    /**
     * 新闻内容
     * @mbg.generated
     */
    private String newsContent;

    /**
     * 新闻类型
     * @mbg.generated
     */
    private Integer newsType;

    /**
     *新闻发布人
     * @mbg.generated
     */
    private String newsPublisher;

    /**
     * 新闻创建时间
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
     * 新闻路劲
     * @mbg.generated
     */
    private String newsUrl;

    /**
     * 阅读量
     * @mbg.generated
     */
    private Integer readSize;

    public News(){

    }

    public News(Integer id, String newsTitle, String newsContent, Integer newsType, String newsPublisher,
                LocalDateTime createTime, Integer version, LocalDateTime lastAccessTime, String newsUrl, Integer readSize) {
        this.id = id;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsType = newsType;
        this.newsPublisher = newsPublisher;
        this.createTime = createTime;
        this.version = version;
        this.lastAccessTime = lastAccessTime;
        this.newsUrl = newsUrl;
        this.readSize = readSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public String getNewsPublisher() {
        return newsPublisher;
    }

    public void setNewsPublisher(String newsPublisher) {
        this.newsPublisher = newsPublisher == null ? null : newsPublisher.trim();
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

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl == null ? null : newsUrl.trim();
    }

    public Integer getReadSize() {
        return readSize;
    }

    public void setReadSize(Integer readSize) {
        this.readSize = readSize;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\'' +
                ", newsType=" + newsType +
                ", newsPublisher='" + newsPublisher + '\'' +
                ", lastAccessTime=" + lastAccessTime +
                ", newsUrl='" + newsUrl + '\'' +
                ", readSize=" + readSize +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(id, news.id) &&
                Objects.equals(newsTitle, news.newsTitle) &&
                Objects.equals(newsContent, news.newsContent) &&
                Objects.equals(newsType, news.newsType) &&
                Objects.equals(newsPublisher, news.newsPublisher) &&
                Objects.equals(createTime, news.createTime) &&
                Objects.equals(version, news.version) &&
                Objects.equals(lastAccessTime, news.lastAccessTime) &&
                Objects.equals(newsUrl, news.newsUrl) &&
                Objects.equals(readSize, news.readSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, newsTitle, newsContent, newsType, newsPublisher, createTime, version, lastAccessTime, newsUrl, readSize);
    }
}