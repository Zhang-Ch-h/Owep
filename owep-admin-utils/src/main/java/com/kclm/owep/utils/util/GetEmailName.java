package com.kclm.owep.utils.util;
/**
 * 
	* Description: 获取邮箱后缀  -author: LUJW
	* @return 
	* @date: 2018年6月22日
 */
public class GetEmailName {
	//咨询师邮箱和密码在Tb_user表中：邮箱&&密码：abc@abc.com&&abc123
	/**
	 * 获取咨询师邮箱的后缀
	 * @param userEmail
	 * @return
	 */
	public static String getEmialLastName(String userEmail) {
		if(userEmail!=null && userEmail.length()>0){
			int dot=userEmail.indexOf(".com&&");
			if(dot>-1 && dot<(userEmail.length()-1)){
				String emailName2 = userEmail.substring(0,dot+4);
				int dot2=emailName2.lastIndexOf("@");
				if(dot>-1 && dot<(emailName2.length()-1)){
					return emailName2.substring(dot2+1);
				}
			}
		}
		return userEmail;
	}
	/**
	 * 获取咨询师邮箱
	 * @param userEmail
	 * @return
	 */
	public static String getEmialName(String userEmail) {
		if(userEmail!=null && userEmail.length()>0){
			int dot=userEmail.indexOf(".com&&");
			if(dot>-1 && dot<(userEmail.length()-1)){
				 return userEmail.substring(0,dot+4);
			}
		}
		return userEmail;
	}
	
	
	/**
	 * 获取咨询师邮箱的密码
	 * @param userEmail
	 * @return
	 */
		public static String getEmailPsw(String userEmail) {
			if(userEmail!=null && userEmail.length()>0){
				int dot=userEmail.indexOf(".com&&");
				if(dot>-1 && dot<(userEmail.length()-1)){
					return userEmail.substring(dot+6);
				}
			}
			return "";
		}

}
