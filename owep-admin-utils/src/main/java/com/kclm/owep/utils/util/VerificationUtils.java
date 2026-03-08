package com.kclm.owep.utils.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @ClassName VerificationUtils
 * @Description: 校验
 * @author: huangfei
 * @since: 2016-10-19 上午10:37:27
 */
public class VerificationUtils {
	/**
	 * 手机号验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) {
		String re = "^[1][3,4,5,7,8][0-9]{9}$";
		return Pattern.compile(re).matcher(str).matches();
	}

	/**
	 * 电话号码验证 格式：3~4位区号（可无、0开头），7~8位直播号，1~4位分机号（可无）
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isPhone(String str) {
		String re = "^([0][0-9]{2,3}-)?[0-9]{7,8}(-[0-9]{1,4})?$";
		return Pattern.compile(re).matcher(str).matches();
	}

	/**
	 * 传真验证 格式：3~4位区号（可无、0开头），7~8位直播号，1~4位分机号（可无）
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isFax(String str) {
		String re = "^([0][0-9]{2,3}-)?[0-9]{7,8}(-[0-9]{1,4})?$";
		return Pattern.compile(re).matcher(str).matches();
	}

	/**
	 * 邮政编码验证 格式：6位
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isPostCode(String str) {
		String re = "^[0-9]{6}$";
		return Pattern.compile(re).matcher(str).matches();
	}

	/**
	 * 电子邮箱验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isEmail(String str) {
		String re = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
		return Pattern.compile(re).matcher(str).matches();
	}

	/**
	 * 网址验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isWebSite(String str) {
		String re = "^((https|http|ftp|rtsp|mms)?://)" + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" // ftp的user@
				+ "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL 如199.194.52.184
				+ "|" // 允许IP和DOMAIN
				+ "([0-9a-z_!~*'()-]+\\.)*" // 域名 如www.
				+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名
				+ "[a-z]{2,6})" // first level domain 如.com or .museum
				+ "(:[0-9]{1,4})?" // 端口 如:80
				+ "((/?)|" // a slash isn't required if there is no file name
				+ "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
		return Pattern.compile(re).matcher(str).matches();
	}

	/**
	 * IP
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isboolIp(String ipAddress) {
		String re = "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)){3}";
		Matcher m = Pattern.compile(re).matcher(ipAddress);
		System.out.println(m.matches());
		return m.matches();
	}

	/**
	 * 密码验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isPwd(String pwd) {
		String re = "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)){3}";
		Matcher m = Pattern.compile(re).matcher(pwd);
		return m.matches();
	}
}
