/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/13 16:16
 *@Description 客户跟进记录DTO
 *
 */
public class ClientNoteDTO implements Serializable {

    /**
     *跟进记录id
     */
    private Integer id;

    /**
     *客户状态：0无意向、1已签约、2潜在客户、3标准客户
     */
    private Integer clientState;

    /**
     *创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     *跟进记录
     */
    private String clientNote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientState() {
        return clientState;
    }

    public void setClientState(Integer clientState) {
        this.clientState = clientState;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getClientNote() {
        return clientNote;
    }

    public void setClientNote(String clientNote) {
        this.clientNote = clientNote;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ClientNoteDTO{");
        sb.append("id=").append(id);
        sb.append(", clientState=").append(clientState);
        sb.append(", createTime=").append(createTime);
        sb.append(", clientNote='").append(clientNote).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientNoteDTO that = (ClientNoteDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(clientState, that.clientState) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientState, createTime);
    }
}
