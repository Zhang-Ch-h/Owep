/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/******************
 * @Author yejf
 * @Version v1.0
 * @Create 2020-07-13 16:36
 * @Description 版本发布DTO， 包含发布的基本信息以及此版本中更新的所有日志
 */
public class ReleaseDTO {

    /** 主键 */
    private Integer id;
    /**  版本号 */
    private String ver;
    /** 版本描述信息 */
    private String description;
    /** 版本发布日期 */
    private LocalDateTime createTime;

    /** 此发布版本的更新日志 */
    private List<ReleaseLogDTO> releaseLogList;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReleaseDTO{");
        sb.append("id=").append(id);
        sb.append(", ver='").append(ver).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReleaseDTO that = (ReleaseDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(ver, that.ver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ver);
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

    public List<ReleaseLogDTO> getReleaseLogList() {
        return releaseLogList;
    }

    public void setReleaseLogList(List<ReleaseLogDTO> releaseLogList) {
        this.releaseLogList = releaseLogList;
    }
}
