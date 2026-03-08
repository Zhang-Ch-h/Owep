package com.kclm.owep;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/****************
 * 整个应用部署时，需要启动的类
 * 注1：Spring Boot默认是启动事务管理器的，也就是@EnableTransactionManagement是自动打开的，只需要在
 * 做申明式事务的类或public方法上面使用 @Transactional 注解指定即可
 * 注2：Spring Boot默认是开启 Spring AOP的。
 * 注3：Spring Boot 默认是开启 WEB MVC的
 */
@Slf4j
@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//使得 Servlet、Filter、Listener可以直接通过@WebServlet、@WebFilter、@WebListener注解自动注册,无需其它代码
@ServletComponentScan
public class OwepAdminWebControllerApplication {
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(OwepAdminWebControllerApplication.class, args);

        //打印输出项目启动成功的信息
        log.debug("项目启动成功  *^_^* ");
        //生成字符 banner, 可以到此网站来定制：
        // http://patorjk.com/software/taag

        log.debug(" \n" +
                "____  ____  ____     _  _____ ____  _____        ____  _     ____  ____  _____ ____  ____ \n" +
                "/  __\\/  __\\/  _ \\   / |/  __//   _\\/__ __\\      / ___\\/ \\ /\\/   _\\/   _\\/  __// ___\\/ ___\\\n" +
                "|  \\/||  \\/|| / \\|   | ||  \\  |  /    / \\        |    \\| | |||  /  |  /  |  \\  |    \\|    \\\n" +
                "|  __/|    /| \\_/|/\\_| ||  /_ |  \\_   | |        \\___ || \\_/||  \\_ |  \\_ |  /_ \\___ |\\___ |\n" +
                "\\_/   \\_/\\_\\\\____/\\____/\\____\\\\____/  \\_/        \\____/\\____/\\____/\\____/\\____\\\\____/\\____/\n" +
                "                                                                                           ");
        //获取应用环境信息
        ConfigurableEnvironment env = application.getEnvironment();
        //通过环境来获取应用名和端口
        String port = env.getProperty("server.port");
        String appName = env.getProperty("server.servlet.context-path");
        //有些应用名就是 /
        if(StringUtils.isEmpty(appName)) {
            appName = "";
        }
        //获取IP地址
        String ip = InetAddress.getLocalHost().getHostAddress();
        //打印输出此应用要访问的入口
        log.debug("\n-------------------------------------------------------\n\t"+
                "Application is running! Access URLs: \n\t" +
                "Local 访问网址：\t\t http://localhost:"+port + appName + "\n\t" +
                "非本机访问地址：\t\t http://" + ip + ":" + port + appName + "\n" +
        "-------------------------------------------------------");
    }


}

