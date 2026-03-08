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
 *@Description 跟进记录实体类
 *
 */
public class ClientNote implements Serializable {
    /**
     *跟进记录id
     */
    private Integer id;

    /**
     *关联客户对象
     */
    private Client client;

    /**
     *客户状态：0无意向、1已签约、2潜在客户、3标准客户
     */
    private Integer clientState;

    /**
     *创建时间
     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     *版本
     */
    private Integer version = 1;

    /**
     *最后一次访问时间
     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime lastAccessTime;

    /**
     *跟进记录
     */
    private String clientNote;

    public ClientNote() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getClientNote() {
        return clientNote;
    }

    public void setClientNote(String clientNote) {
        this.clientNote = clientNote;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ClientNote{");
        sb.append("id=").append(id);
        sb.append(", client=").append(client);
        sb.append(", clientState=").append(clientState);
        sb.append(", createTime=").append(createTime);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", clientNote='").append(clientNote).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientNote that = (ClientNote) o;
        return Objects.equals(client, that.client) &&
                Objects.equals(clientNote, that.clientNote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, clientNote);
    }
}