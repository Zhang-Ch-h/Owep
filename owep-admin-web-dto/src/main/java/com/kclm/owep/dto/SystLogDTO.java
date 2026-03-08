package com.kclm.owep.dto;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @fieldName: serialVersionUID
 * @author caolz
 * @fieldType: long
 * @Description:
 */
public class SystLogDTO implements java.io.Serializable{

	private static final long serialVersionUID = 3684561205904739338L;
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 日志主题(菜单标题)
	 */
	private String title;
	/**
	 * 操作模块名
	 */
	private String moduleName;
	/**
	 * 操作菜单名
	 */
	private String menuName;
	/**
	 * ip地址
	 */
	private String ipAddr;
	/**
	 * 请求方法
	 */
	private String method;
	/**
	 * 请求地址
	 */
	private String requestUrl;
	/**
	 * 类型
	 */
	private  String type;
	/**
	 * 登录用户名
	 */
	private String loginUserName;
	/**
	 * 最后访问时间
	 */
	private LocalDateTime lastAccessTime;
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime=LocalDateTime.now();
	/**
	 * 开始时间
	 */
	private LocalDateTime startTime;
	/**
	 * 结束时间
	 */
	private LocalDateTime endTime;

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

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
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

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "SystLogDTO{" +
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
				", startTime=" + startTime +
				", endTime=" + endTime +
				'}';
	}
}
