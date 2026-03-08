/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/******************
 * @Author yejf
 * @Version v1.0
 * @Create 2020-07-07 18:35
 * @Description 产品发布日志信息 实体类
 */
public class ReleaseLog implements Serializable {

    /** 主键 */
    private Integer id;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 新版本内容的类型，如：新增、修复bug、提高效率等 */
    private String type;

    /** 新增的内容条目 */
    private String content;

    /** 序号 */
    private int seq;

    /** 所属的发布版本 */
    private Release release;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReleaseLog{");
        sb.append("id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", type='").append(type).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", seq=").append(seq);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReleaseLog that = (ReleaseLog) o;
        return seq == that.seq &&
                Objects.equals(id, that.id) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, content, seq);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public ReleaseLog(String type, String content, int seq) {
        this.type = type;
        this.content = content;
        this.seq = seq;
    }

    public ReleaseLog() {
    }
}
