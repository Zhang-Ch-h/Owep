package com.kclm.owep.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/*******
 * @Author yangwr
 * @Version v1.0
 * @Create 2020/7/6 16:34
 * @Description 分支机构实体类
 */
public class BranchInstitute implements Serializable {

    private static final long serialVersionUID = 1L;

    /***
     * 分支机构id
     */
    private Integer id;
    /***
     *分支名称
     */
    private String branchName;
    /***
     *组织机构id（外键）
     */
    private OrgInstitute orgInstitute;
    /***
     *版本
     */
    private Integer version = 1;
    /***
     *创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime = LocalDateTime.now();
    /***
     *最后访问时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastAccessTime = LocalDateTime.now();

    /***
     * 构造方法
     */
    public BranchInstitute() {
    }

    @Override
    public String toString() {
        return "BranchInstitute{" +
                "id=" + id +
                ", branchName='" + branchName + '\'' +
                ", orgInstitute=" + orgInstitute +
                ", version=" + version +
                ", createTime=" + createTime +
                ", lastAccessTime=" + lastAccessTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BranchInstitute that = (BranchInstitute) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(branchName, that.branchName) &&
                Objects.equals(orgInstitute, that.orgInstitute) &&
                Objects.equals(version, that.version) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(lastAccessTime, that.lastAccessTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, branchName, orgInstitute, version, createTime, lastAccessTime);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public OrgInstitute getOrgInstitute() {
        return orgInstitute;
    }

    public void setOrgInstitute(OrgInstitute orgInstitute) {
        this.orgInstitute = orgInstitute;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public BranchInstitute(Integer id, String branchName, OrgInstitute orgInstitute, Integer version, LocalDateTime createTime, LocalDateTime lastAccessTime) {
        this.id = id;
        this.branchName = branchName;
        this.orgInstitute = orgInstitute;
        this.version = version;
        this.createTime = createTime;
        this.lastAccessTime = lastAccessTime;
    }
}