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
 *@Create: 2020/7/13 10:19
 *@Description:考评选项DTO层
 ***/
public class PollItemDTO implements Serializable {

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
     * 空参构造
     */
    public PollItemDTO() {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PollItemDTO)) return false;
        PollItemDTO that = (PollItemDTO) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPollNum(), that.getPollNum()) &&
                Objects.equals(getPollContent(), that.getPollContent()) &&
                Objects.equals(getPollStatus(), that.getPollStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPollNum(), getPollContent(), getPollStatus());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PollItemDTO{");
        sb.append("id=").append(id);
        sb.append(", pollNum='").append(pollNum).append('\'');
        sb.append(", pollContent='").append(pollContent).append('\'');
        sb.append(", pollStatus=").append(pollStatus);
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }
}
