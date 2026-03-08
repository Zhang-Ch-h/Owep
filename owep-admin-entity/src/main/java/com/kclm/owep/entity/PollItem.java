/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/3 17:00
 *@Description:考评选项实体类
 ***/
public class PollItem implements Serializable {

    /***
     * 考评选项id
     */
    private Integer id;

    /***
     * 考评选项编号
     */
    private String pollNum;

    /***
     * 考评内容
     */
    private String pollContent;

    /***
     * 是否启用  1.启用 0.未启用
     */
    private Integer pollStatus;

    /***
     * 创建时间
     */
    private LocalDateTime createTime;

    /***
     * 版本
     */
    private Integer version;

    /***
     * 最后访问时间
     */
    private LocalDateTime lastAccessTime;

    /***
     * 空参构造
     */
    public PollItem() {
    }

    /***
     * 全参构造
     * @param id
     * @param pollNum
     * @param pollContent
     * @param pollStatus
     * @param createTime
     * @param version
     * @param lastAccessTime
     */
    public PollItem(Integer id, String pollNum, String pollContent, Integer pollStatus, LocalDateTime createTime, Integer version, LocalDateTime lastAccessTime) {
        this.id = id;
        this.pollNum = pollNum;
        this.pollContent = pollContent;
        this.pollStatus = pollStatus;
        this.createTime = createTime;
        this.version = version;
        this.lastAccessTime = lastAccessTime;
    }

    /***
     * 三参构造
     * @param pollNum
     * @param pollContent
     * @param pollStatus
     */
    public PollItem(String pollNum, String pollContent, Integer pollStatus) {
        this.pollNum = pollNum;
        this.pollContent = pollContent;
        this.pollStatus = pollStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPollNum() {
        return pollNum;
    }

    public void setPollNum(String pollNum) {
        this.pollNum = pollNum;
    }

    public String getPollContent() {
        return pollContent;
    }

    public void setPollContent(String pollContent) {
        this.pollContent = pollContent;
    }

    public Integer getPollStatus() {
        return pollStatus;
    }

    public void setPollStatus(Integer pollStatus) {
        this.pollStatus = pollStatus;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PollItem)) return false;
        PollItem pollItem = (PollItem) o;
        return Objects.equals(getId(), pollItem.getId()) &&
                Objects.equals(getPollNum(), pollItem.getPollNum()) &&
                Objects.equals(getPollContent(), pollItem.getPollContent()) &&
                Objects.equals(getPollStatus(), pollItem.getPollStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPollNum(), getPollContent(), getPollStatus());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PollItem{");
        sb.append("id=").append(id);
        sb.append(", pollNum='").append(pollNum).append('\'');
        sb.append(", pollContent='").append(pollContent).append('\'');
        sb.append(", pollStatus=").append(pollStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }
}
