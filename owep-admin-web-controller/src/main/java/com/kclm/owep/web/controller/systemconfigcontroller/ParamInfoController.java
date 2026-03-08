package com.kclm.owep.web.controller.systemconfigcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*******************
 * @Author zch
 * @Description
 */
@Controller
@RequestMapping("/system")
public class ParamInfoController {

    // 去往首页参数信息页面
    @GetMapping("/paramInfo.html")
    public String paramInfo(){
        return "system/paramInfo";
    }

    @GetMapping("/paraminfo")
    public String toparamInfo(){
        return "system/paramInfo";
    }
}
