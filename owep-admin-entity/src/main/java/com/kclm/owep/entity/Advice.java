package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Advice implements Serializable {
    /**
     * 主键
     * @mbg.generated
     */
    private Integer id;

    /**
     * 反馈人的email
     * @mbg.generated
     */
    private String email;

    /**
     * 反馈内容
     * @mbg.generated
     */
    private String adviceContent;

    /**
     *
     * @mbg.generated
     */
    private String suggestName;

    /**
     * 创建时间
     * @mbg.generated
     */
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     * 最后访问时间
     * @mbg.generated
     */
    private LocalDateTime lastAccessTime;

    /**
     * 版本
     * @mbg.generated
     */
    private Integer version = 1;

    public Advice(){}

    public Advice(Integer id, String email, String adviceContent, String suggestName,
                  LocalDateTime createTime, LocalDateTime lastAccessTime, Integer version) {
        this.id = id;
        this.email = email;
        this.adviceContent = adviceContent;
        this.suggestName = suggestName;
        this.createTime = createTime;
        this.lastAccessTime = lastAccessTime;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAdviceContent() {
        return adviceContent;
    }

    public void setAdviceContent(String adviceContent) {
        this.adviceContent = adviceContent == null ? null : adviceContent.trim();
    }

    public String getSuggestName() {
        return suggestName;
    }

    public void setSuggestName(String suggestName) {
        this.suggestName = suggestName;
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
        return "Advice{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", adviceContent='" + adviceContent + '\'' +
                ", suggestName=" + suggestName +
                ", lastAccessTime=" + lastAccessTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advice advice = (Advice) o;
        return Objects.equals(id, advice.id) &&
                Objects.equals(email, advice.email) &&
                Objects.equals(adviceContent, advice.adviceContent) &&
                Objects.equals(suggestName, advice.suggestName) &&
                Objects.equals(createTime, advice.createTime) &&
                Objects.equals(lastAccessTime, advice.lastAccessTime) &&
                Objects.equals(version, advice.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, adviceContent, suggestName, createTime, lastAccessTime, version);
    }
}