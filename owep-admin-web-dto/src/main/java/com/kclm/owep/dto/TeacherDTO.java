package com.kclm.owep.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kclm.owep.entity.Group;

import java.time.LocalDateTime;
import java.util.List;

/*******************
 * @Author zch
 * @Description
 */
public class TeacherDTO {

    private Integer id;

    private String userName;

    private String realName;

    private Integer gender;

    private String userPhone;

    private String userEmail;

    private Integer status;

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime effectiveDate;

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastAccessTime;

    private List<Group> groups;

    public TeacherDTO(Integer id, String userName, String realName,
                      Integer gender, String userPhone, String userEmail,
                      Integer status, LocalDateTime effectiveDate, LocalDateTime lastAccessTime) {
        this.id = id;
        this.userName = userName;
        this.realName = realName;
        this.gender = gender;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.status = status;
        this.effectiveDate = effectiveDate;
        this.lastAccessTime = lastAccessTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}