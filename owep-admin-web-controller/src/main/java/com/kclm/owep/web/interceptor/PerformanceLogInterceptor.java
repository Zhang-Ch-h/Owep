package com.kclm.owep.web.interceptor;

import com.kclm.owep.entity.SystLog;
import com.kclm.owep.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/************
 * 操作日志拦截器
 */
@Component
public class PerformanceLogInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SysLogService sysLogService;
    //此属性是基于线程ID来绑定对象的,ThreadLocal相当于是Key是线程ID的Map,所以，它是一个容器类
    private NamedThreadLocal<LocalDateTime> timer = new NamedThreadLocal<>("ptime");

    /**************
     * 在目前Controller方法执行之前调用，我们在此方法记录系统时间，
     * 由于拦截器是单例的，所以，我们需要把这个时间绑定到 ThreadLocal中去。
     * @param request
     * @param response
     * @param handler
     * @return 返回true,表示执行拦截器链中下一个拦截器，返回false,则中断执行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // 检查是否是静态资源
        if (isStaticResource(request.getRequestURI())) {
            return true;  // 静态资源不进行处理
        }
        //1. 记录下当前的系统时间
        LocalDateTime startTime = LocalDateTime.now();
        //2. 把这个时间绑定到 NamedThreadLocal中去
        timer.set(startTime);
        //3.返回
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 检查是否是静态资源
        if (isStaticResource(request.getRequestURI())) {
            return;  // 静态资源不进行处理
        }
        LocalDateTime createTime = timer.get();
        String uri = request.getRequestURI();
        String httpMethod = request.getMethod();
        String clientIp = request.getRemoteAddr();
        String moduleName = extractModuleName(request); // 根据您应用的逻辑实现这个方法
        String username = extractUsername(); // 实现这个方法以提取用户名，可能使用Spring Security

        // 记录详细信息
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = createTime.format(formatter);
        System.out.printf("模块: %s, IP: %s, URL: %s, 方法: %s, 用户: %s, 时间: %s\n", moduleName, clientIp, uri, httpMethod, username, formattedTime);
        //
        SystLog systLog = new SystLog();
        systLog.setModuleName(moduleName);
        systLog.setIpAddr(clientIp);
        systLog.setRequestUrl(uri);
        systLog.setMethod(httpMethod);
        systLog.setLoginUserName(username);
        systLog.setCreateTime(createTime);
        systLog.setLastAccessTime(createTime);
        //
        sysLogService.save(systLog);
    }

    private String extractUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        }
        return "匿名用户";
    }

    private String extractModuleName(HttpServletRequest request) {
        String path = request.getRequestURI();
        // 假设URL结构是 /应用名/模块名/...
        String[] parts = path.split("/");
        if (parts.length > 2) {
            return parts[2];  // 获取模块名
        }
        return "未知模块";
    }

    private boolean isStaticResource(String uri) {
        // 检查URI是否为静态资源或者发生错误
        return uri.contains("/static/") || uri.matches(".*\\.(css|js|png|jpg|jpeg|gif|ico)$");
    }

    /*@Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //1. 记录当前系统时间
        long endTime = System.currentTimeMillis();
        //2. 通过ThreadLocal来取出当前线程的起始时间
        long startTime = timer.get();
        //3. 两个时间差
        long cost = endTime - startTime;
        //
        String uri = request.getRequestURI();
        //
        if(uri.startsWith(request.getContextPath()+"/static")) {
            return ;
        }
        //4. 判断
        if(cost > 300) { // 这个阀值是可以根据需求自己设定的
            //记录日志
            System.out.printf(">>>> 请求：%s 花费的时间是：%d ms.\n", request.getRequestURI(),cost);
        } else {
            System.out.printf(">>> 请求：%s 所费时间是在性能要求的阀值之内的\n", request.getRequestURI());
        }
    }*/
}
