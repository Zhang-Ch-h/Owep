package com.kclm.owep.dto;

import com.kclm.owep.entity.User;

import java.time.LocalDateTime;

public class ExamBankDTO {
    /*
     * 主键id
     * */
    private Integer id;

    /*
     * 版本号
     * */
    private Integer version =1;

    /*
     * 创建时间
     * */
    private LocalDateTime createTime=LocalDateTime.now();

    /*
     * 最后一次访问的时间
     * */
    private LocalDateTime lastAccessTime;

    /*
     * 是否逻辑删除，1表示未删除，0表示已删除
     * */
    private Integer isDelete;

    /*
     * user_id (fk)
     * */
    private int userId;

    /*
     * user_name (fk)
     * */
    private String userName;

    /*
     * 题库名称
     * */
    private String bankName;

    /*
     * 题库状态，0为禁用，1为正常
     * */
    private Integer bankStatus;

    /*
     * 题库说明
     * */
    private String bankDesc;

    /*
     * 访问权限(1为完全私有，2为只读共享)
     * */
    private Integer bankSecurity;

    /*
     * 试题数量
     * */
    private Integer quesNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getBankStatus() {
        return bankStatus;
    }

    public void setBankStatus(Integer bankStatus) {
        this.bankStatus = bankStatus;
    }

    public String getBankDesc() {
        return bankDesc;
    }

    public void setBankDesc(String bankDesc) {
        this.bankDesc = bankDesc;
    }

    public Integer getBankSecurity() {
        return bankSecurity;
    }

    public void setBankSecurity(Integer bankSecurity) {
        this.bankSecurity = bankSecurity;
    }

    public Integer getQuesNumber() {
        return quesNumber;
    }

    public void setQuesNumber(Integer quesNumber) {
        this.quesNumber = quesNumber;
    }

    @Override
    public String toString() {
        return "ExamBankDTO{" +
                "id=" + id +
                ", version=" + version +
                ", createTime=" + createTime +
                ", lastAccessTime=" + lastAccessTime +
                ", isDelete=" + isDelete +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankStatus=" + bankStatus +
                ", bankDesc='" + bankDesc + '\'' +
                ", bankSecurity=" + bankSecurity +
                ", quesNumber=" + quesNumber +
                '}';
    }
}
