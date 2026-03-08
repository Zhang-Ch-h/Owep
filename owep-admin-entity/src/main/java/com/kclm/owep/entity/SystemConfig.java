package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;


/************
 *@Author chenxin
 *@Version v1.0
 *@Create 2020/7/616:22
 *@Description 系统信息实体类
 */

public class SystemConfig implements Serializable {

    /**
     * 序列化接口
     */
    private static final long serialVersionUID=1L;

    /**
     *id(主键)
     */
    private Integer id;

    /**
     *系统名称
     */
    private String systemName;

    /**
     *版权所属
     */
    private String copyName;

    /**
     *登录页LOGO
     */
    private String loginPageLogo;
    /**
     *系统页LOGO
     */

    private String systemPageLogo;

    /**
     *创建时间
     */
    private LocalDateTime createTime=LocalDateTime.now();

    /**
     *版本号
     */
    private Integer version=1;

    /**
     * 最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    /**
     * 登录次数
     */
    private Integer loginCount;

    /**
     * 构造方法
     */
    public SystemConfig() {
    }

    public SystemConfig(String systemName, String copyName, String loginPageLogo, String systemPageLogo, Integer loginCount) {
        this.systemName = systemName;
        this.copyName = copyName;
        this.loginPageLogo = loginPageLogo;
        this.systemPageLogo = systemPageLogo;
        this.loginCount = loginCount;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getSystemName() {
        return systemName;
    }


    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }


    public String getCopyName() {
        return copyName;
    }


    public void setCopyName(String copyName) {
        this.copyName = copyName == null ? null : copyName.trim();
    }


    public String getLoginPageLogo() {
        return loginPageLogo;
    }


    public void setLoginPageLogo(String loginPageLogo) {
        this.loginPageLogo = loginPageLogo == null ? null : loginPageLogo.trim();
    }


    public String getSystemPageLogo() {
        return systemPageLogo;
    }


    public void setSystemPageLogo(String systemPageLogo) {
        this.systemPageLogo = systemPageLogo == null ? null : systemPageLogo.trim();
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

    public Integer getLoginCount() {
        return loginCount;
    }


    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    @Override
    public String toString() {
        return "SystemConfig{" +
                "id=" + id +
                ", systemName='" + systemName + '\'' +
                ", copyName='" + copyName + '\'' +
                ", loginPageLogo='" + loginPageLogo + '\'' +
                ", systemPageLogo='" + systemPageLogo + '\'' +
                ", createTime=" + createTime +
                ", version=" + version +
                ", lastAccessTime=" + lastAccessTime +
                ", loginCount=" + loginCount +
                '}';
    }
}