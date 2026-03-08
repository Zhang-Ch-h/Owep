package com.kclm.owep.utils.webpage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataTableReturn {

    public static String getPage(Integer draw, int recordsTotal, List<?> list,String error) {
        Map<String, Object> getObj = new HashMap<String, Object>();
//		    JSONObject getObj = new JSONObject();
        getObj.put("draw", draw);//该对象作为响应的绘制计数器 - 来自draw作为数据请求的一部分发送的参数。请注意，这是强烈建议出于安全原因，你投这个参数为整数，而不是简单地回显到客户端它在发送的draw参数，以防止跨站脚本（XSS）攻击。
        getObj.put("recordsTotal", recordsTotal);//过滤前的总记录数（即数据库中记录的总数）
        getObj.put("recordsFiltered", recordsTotal);//过滤后的总记录数（即应用过滤后的记录总数 - 不仅仅是本页数据返回的记录数）。

        getObj.put("data", list);//要在表格中显示的数据。这是一组数据源对象，每行一个，DataTables将使用该对象。请注意，该参数的名称可以使用该ajax选项的dataSrc属性进行更改。
        if(error!=null && !error.equals("")){
            getObj.put("error",error);//可选：如果在运行服务器端处理脚本期间发生错误，您可以通过传回要使用此参数显示的错误消息来通知用户此错误。如果没有错误，请不要包含。
        }
        String jsonStr = JSON.toJSONString(getObj, SerializerFeature.DisableCircularReferenceDetect);// 转json，禁止引用

        return jsonStr;
    }
}
