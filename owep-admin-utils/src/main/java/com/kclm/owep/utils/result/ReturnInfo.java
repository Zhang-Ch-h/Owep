package com.kclm.owep.utils.result;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @ClassName: ReturnInfo
 * @Description: 封装结果集返回
 * @author: huangfei
 * @date: 2017年3月31日 下午6:18:43
 */
@SuppressWarnings("all")
public class ReturnInfo {

	/**
	 * @Description： 获取状态信息
	 * @author: QIJJ
	 * @since: 2016年11月14日 下午5:05:34
	 */
	public static <T> String returnJsonInfo(StatusInfo statusInfo, T result) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", statusInfo.isSuccess());
		if (statusInfo.isSuccess()) {
			map.put("result", result);
		} else if (statusInfo.isAlreadyExist()) {// 短信验证，用户已经注册
			map.put("result", result);
		} else if (statusInfo.isUserNotRegist()) {// 短信验证，用户未注册
			map.put("result", result);
		} else {
			map.put("result", result);
		}
		map.put("statusCode", statusInfo.getCode());
		map.put("statusMsg", statusInfo.getMsg());
		map.put("unAuthorizedRequest", false);
		String jsonStr = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);// 转json，禁止引用
		return jsonStr;
	}

}
