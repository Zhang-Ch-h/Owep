/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/3 16:05
 *@Description 节和视频中间实体类
 *
 */
public class SectionVideo implements Serializable {
    /**
     *主键
     */
    private Integer id;

    /**
     *关联节对象
     */
    private Section section;

    /**
     *关联视频对象
     */
    private Video video;

    /**
     *创建时间
     */
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     *最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    /**
     *版本
     */
    private Integer version = 1;

    public SectionVideo() {
    }

    public SectionVideo(Section section, Video video) {
        this.section = section;
        this.video = video;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
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
    public String toString() {
        final StringBuffer sb = new StringBuffer("SectionVideo{");
        sb.append("id=").append(id);
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
        SectionVideo that = (SectionVideo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(section, that.section) &&
                Objects.equals(video, that.video) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(lastAccessTime, that.lastAccessTime) &&
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(section, video);
    }
}