/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.Objects;


/*****
 * @Author WSP
 * @Version v1.0
 * @Create 2020/7/6 20：38
 * @Description 消息表实体类
 */
public class Message {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 消息头
     */
    private String title;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 是否已读。1表示一读，0表示未读
     */
    private Integer read;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 发送消息人名
     */
    private String fromUserName;

    /**
     * 接收消息人员
     */
    private String toUserName;

    /**
     * 外键，指向学员表
     */
    private Student FkFromStudent;

    /**
     * 外键，指向目标学员
     */
    private Student ToFromStudent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
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

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public Student getFkFromStudent() {
        return FkFromStudent;
    }

    public void setFkFromStudent(Student fkFromStudent) {
        FkFromStudent = fkFromStudent;
    }

    public Student getToFromStudent() {
        return ToFromStudent;
    }

    public void setToFromStudent(Student toFromStudent) {
        ToFromStudent = toFromStudent;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Message{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", read=").append(read);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", version=").append(version);
        sb.append(", fromUserName='").append(fromUserName).append('\'');
        sb.append(", toUserName='").append(toUserName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message = (Message) o;
        return Objects.equals(id, message.id) &&
                Objects.equals(title, message.title) &&
                Objects.equals(content, message.content) &&
                Objects.equals(read, message.read) &&
                Objects.equals(createTime, message.createTime) &&
                Objects.equals(lastAccessTime, message.lastAccessTime) &&
                Objects.equals(version, message.version) &&
                Objects.equals(fromUserName, message.fromUserName) &&
                Objects.equals(toUserName, message.toUserName) &&
                Objects.equals(FkFromStudent, message.FkFromStudent) &&
                Objects.equals(ToFromStudent, message.ToFromStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, read, createTime, lastAccessTime, version, fromUserName, toUserName, FkFromStudent, ToFromStudent);
    }

}