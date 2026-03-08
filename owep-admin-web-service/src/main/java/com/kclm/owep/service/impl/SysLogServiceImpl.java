package com.kclm.owep.service.impl;

import com.kclm.owep.entity.SystLog;
import com.kclm.owep.mapper.SysLogMapper;
import com.kclm.owep.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void save(SystLog sysLog) {
        try {
            String moduleName = sysLog.getModuleName();

            // 如果模块名为“error”或“未知模块”，则不进行保存
            if ("error".equals(moduleName) || "未知模块".equals(moduleName)) {
                return;
            }

            boolean conditionMet = false;
            String loginUserName = sysLog.getLoginUserName();
            String requestUrl = sysLog.getRequestUrl();

            if (moduleName.equals("login") & loginUserName.equals("匿名用户")) {
                sysLog.setTitle("访问登录页面");
                sysLog.setModuleName("用户没有操作模块");
                conditionMet = true;
            }

            if (!conditionMet && moduleName.equals("login") && !loginUserName.equals("匿名用户")) {
                sysLog.setTitle("登录");
                sysLog.setModuleName("用户没有操作模块");
                conditionMet = true;
            }

            if (!conditionMet && requestUrl.equals("/owep/system/paramInfo.html") && moduleName.equals("system")) {
                sysLog.setTitle("进入首页");
                sysLog.setModuleName("用户没有操作模块");
                conditionMet = true;
            }

            if (!conditionMet && requestUrl.equals("/owep/getMenu") && moduleName.equals("getMenu")) {
                sysLog.setTitle("获取模块");
                sysLog.setModuleName("用户没有操作模块");
                conditionMet = true;
            }

            if (!conditionMet && moduleName.equals("login.html") && requestUrl.equals("/owep/login.html")) {
                sysLog.setTitle("退出");
                sysLog.setModuleName("用户没有操作模块");
                conditionMet = true;
            }

            if (!conditionMet) {
                sysLog.setTitle("操作");
                switch (moduleName) {
                    case "clazz":
                        sysLog.setModuleName("班级管理");
                        break;
                    case "log":
                        sysLog.setModuleName("操作日志");
                        break;
                    case "notice":
                        sysLog.setModuleName("通知公告");
                        break;
                    case "organization":
                        sysLog.setModuleName("组织机构");
                        break;
                    case "system":
                        sysLog.setModuleName("系统配置");
                        break;
                    case "user":
                        sysLog.setModuleName("用户管理");
                        break;
                }
            }
            //
            sysLog.setType("后台管理端");
            sysLogMapper.save(sysLog);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public List<SystLog> getByKeyWords(String userName, LocalDateTime start, LocalDateTime end) {
        try {
            return sysLogMapper.selectByKeyWords(userName, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<SystLog> getAll() {
        try {
            return sysLogMapper.selectAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}
