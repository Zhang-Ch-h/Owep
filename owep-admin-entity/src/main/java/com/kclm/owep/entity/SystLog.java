package com.kclm.owep.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/************
 *@Author chenxin
 *@Version v1.0
 *@Create 2020/7/616:22
 *@Description 系统日志实体类
 */

public class SystLog implements Serializable {
    /**
     * 序列化接口
     */
    private static final long serialVersionUID=1L;

    /**
     *id(主键)
     */
    private Integer id;

    /**
     *日志主题(菜单标题)
     */
    private String title;
    /**
     *操作模块名
     */

    private String moduleName;

    /**
     *操作菜单名
     */
    private String menuName;

    /**
     *ip地址
     */
    private String ipAddr;

    /**
     *请求方法
     */
    private String method;

    /**
     *请求地址
     */
    private String requestUrl;

    /**
     *类型
     */
    private String type;

    /**
     *登录用户名
     */
    private String loginUserName;

    /**
     *最后访问时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastAccessTime;

    /**
     *创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     *版本
     */
    private Integer version=1;

    /**
     * 构造方法
     */
    public SystLog() {
    }

    public SystLog(String title, String moduleName, String menuName, String ipAddr, String method, String requestUrl, String type, String loginUserName) {
        this.title = title;
        this.moduleName = moduleName;
        this.menuName = menuName;
        this.ipAddr = ipAddr;
        this.method = method;
        this.requestUrl = requestUrl;
        this.type = type;
        this.loginUserName = loginUserName;
    }

    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

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
        this.title = title == null ? null : title.trim();
    }


    public String getModuleName() {
        return moduleName;
    }


    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }


    public String getMenuName() {
        return menuName;
    }


    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }


    public String getIpAddr() {
        return ipAddr;
    }


    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr == null ? null : ipAddr.trim();
    }


    public String getMethod() {
        return method;
    }


    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }


    public String getRequestUrl() {
        return requestUrl;
    }


    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl == null ? null : requestUrl.trim();
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }


    public String getLoginUserName() {
        return loginUserName;
    }


    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName == null ? null : loginUserName.trim();
    }


    public Integer getVersion() {
        return version;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "SystLog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", menuName='" + menuName + '\'' +
                ", ipAddr='" + ipAddr + '\'' +
                ", method='" + method + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                ", type='" + type + '\'' +
                ", loginUserName='" + loginUserName + '\'' +
                ", lastAccessTime=" + lastAccessTime +
                ", createTime=" + createTime +
                ", version=" + version +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystLog systLog = (SystLog) o;
        return Objects.equals(title, systLog.title) &&
                Objects.equals(moduleName, systLog.moduleName) &&
                Objects.equals(menuName, systLog.menuName) &&
                Objects.equals(ipAddr, systLog.ipAddr) &&
                Objects.equals(method, systLog.method) &&
                Objects.equals(requestUrl, systLog.requestUrl) &&
                Objects.equals(type, systLog.type) &&
                Objects.equals(loginUserName, systLog.loginUserName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, moduleName, menuName, ipAddr, method, requestUrl, type, loginUserName);
    }
}