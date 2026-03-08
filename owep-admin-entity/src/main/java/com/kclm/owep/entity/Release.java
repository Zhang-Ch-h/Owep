/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/******************
 * @Author yejf
 * @Version v1.0
 * @Create 2020-07-07 18:32
 * @Description 产品发布日志信息 实体类
 */
public class Release implements Serializable {

    /** 主键 */
    private Integer id;
    /**  版本号 */
    private String ver;
    /** 版本描述信息 */
    private String description;
    /** 版本发布日期 */
    private LocalDateTime createTime;
    /** 最后一次访问日期 */
    private LocalDateTime lastAccessTime;

    /** 此发布版本的更新日志 */
    private List<ReleaseLog> releaseLogList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Release{");
        sb.append("id=").append(id);
        sb.append(", ver='").append(ver).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", releaseLogList=").append(releaseLogList);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Release release = (Release) o;
        return Objects.equals(id, release.id) &&
                Objects.equals(ver, release.ver) &&
                Objects.equals(description, release.description) &&
                Objects.equals(createTime, release.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ver, description, createTime);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<ReleaseLog> getReleaseLogList() {
        return releaseLogList;
    }

    public void setReleaseLogList(List<ReleaseLog> releaseLogList) {
        this.releaseLogList = releaseLogList;
    }

    public Release(String ver, String description) {
        this.ver = ver;
        this.description = description;
    }

    public Release() {
    }
}
