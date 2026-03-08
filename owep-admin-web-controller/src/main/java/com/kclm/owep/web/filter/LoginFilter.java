package com.kclm.owep.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/******************
 * @author yejf
 * @description 认证过滤器【登录过滤器】
 */
//@Order(1)
//@WebFilter(urlPatterns = {"/user/*"},filterName = "loginFilter", dispatcherTypes =
//        {DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ASYNC})//不使用，过滤交由spring security 完成
public class LoginFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("-- LoginFilter的init()方法....");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //
        log.debug("请求进入了 LoginFilter ....");

        //
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
