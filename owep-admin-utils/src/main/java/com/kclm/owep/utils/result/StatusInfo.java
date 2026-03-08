package com.kclm.owep.utils.result;

/**
 * @ClassName: StatusInfo
 * @Description: 枚举常量
 * @author: huangfei
 * @date: 2017年3月31日 下午5:08:46
 */
public enum StatusInfo {

	SUCCESS("200", "成功"), 
	FAIL("201", "系统异常,请与管理员联系"), 
	USER_NOT_EXIST("301", "用户不存在"), 
	FILE_NOT_EXIST("302","文件不存在"), 
	FILE_BEYOUNT("303","文件大小不能大于50M"), 
	TOKEN_NOT_EXIST("304", "TOKEN不匹配"), 
	USER_NOT_CERTIFICATION("305", "用户未认证"), 
	CHECKCODE_NOT_MATCH("306", "验证码不匹配"), 
	CLIENT_AND_SERVER_CONFIGURATION_INFORMATION_ARE_INCORRECT("307","客户端信息与服务端配置信息有误！"), 
	NO_CLIENT_INFORMATION("317", "无客户端信息"), 
	VERIFICATION_CODE_FAILE("318","验证码错误，请重试"), 
	USER_ALREADY_EXIST("319", "用户已经注册"), 
	USER_NOT_REGIST("320","用户未注册"), 
	IMPORT_FILEERROR("321","导入excel解析的文件格式有误！"),
	FILE_SUSSESS("322","utf-8"),
	ACCOUNT_PWD_ERROR("323","用户名或密码错误！"),
	ASSIGNED_TO_MENU("324","行为已分配给菜单"),
	ASSIGNED_MENU("325","菜单已分配给权限"),
	ASSIGNED_ROLE("326","权限已分配给角色"),
	ASSIGNED_GROUP("327","角色已分配给用户组"),
	ASSIGNED_USER("328","用户组已分配给用户"),
	ASSIGNED_CLASS("329","资源已分配给班级"),
	PROFE_ASSIGNEDTOCLASS("330","专业方向已分配给班级"),
	CLASS_HAS_BEEN_USERD("331","班级已投入使用"),
	USER_NOT_STATUS("332","账号未启用"),
	QUESTION_ASSIGN_REPLAY("333","问题有关联数据！"),
	USER_NOT_NAME("334","用户名不能为空"),
	USER_NOT_PWD("335","密码不能为空"),
	VERIFICATION_NOT_CODE("336","验证码不能为空"),
	ACCOUNT_NOT_ENABLE("337","账号未启用,请与系统管理员联系"),
	USER_OVERLOG("338","失败多次，账号锁定2分钟,请2分钟以后再登录！"),
	USER_OVERDUE("339","您的账号已过期，请与系统管理员联系!"),
	USER_TYPE_ERROR("340","您的账户不是学生，请与管理员联系！"),
	USER_NOT_TEAORANMIN("341","您的账户是学生账户，无法在此登录！"),
	USER_NOT_ADMIN("342","您的账户不是管理员账户，无法在此登录！"),
	EMAIL_IS_NOT_AVAILABLE("343","您输入的用户没有此邮箱！"),
	EMAIL_SEND_FILE("344","邮件发送失败！请联系管理员！"),
	DEL_USER_ERROR("345","删除用户失败！"),
	TERM_OF_VALIDITY_OUT("346","账号已过期！"),
	OLD_PWD_ERROR("347","原密码输入不正确！"),
	FILE_NOT_FOND("348","找不到文件"),
	DBFILE_NOT_FOND("350","找不到数据库文件"),
	NOT_LOGIN("351","用户未登录");
	
	

	private String code;

	private String msg;

	private StatusInfo(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 判断是否成功
	 * @Title: isSuccess
	 * @Description: TODO
	 * @return
	 * @date: 2017年3月31日 下午6:19:07
	 * @return: boolean
	 */
	public boolean isSuccess() {
		return SUCCESS.getCode().equals(code);
	}

	public boolean isAlreadyExist() {
		return USER_ALREADY_EXIST.getCode().equals(code);
	}

	public boolean isUserNotRegist() {
		return USER_NOT_REGIST.getCode().equals(code);
	}

}
