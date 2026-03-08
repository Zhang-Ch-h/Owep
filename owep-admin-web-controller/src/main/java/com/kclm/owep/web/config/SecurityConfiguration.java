package com.kclm.owep.web.config;

import com.kclm.owep.web.security.SpringDataUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启方法级授权访问
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private SpringDataUserDetailService userDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailService)//用户信息服务
                .passwordEncoder(passwordEncoder())//使用自定义的编码器
                ;
    }

    @Override //安全拦截机制*
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().sameOrigin()//允许同源头嵌套，此设置允许页面经由iframe框架嵌套到别处
                .and()
                .formLogin()//允许表单登录
                .loginPage("/login")//自定登陆页面
                .usernameParameter("username")//配置自定义界面
                .passwordParameter("password")
                .successForwardUrl("/login")
                .failureUrl("/login?error")//指定登录失败后跳转到/login?error页面
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .and()
                .authorizeRequests()//请求url权限过滤
//                .antMatchers("/static/**").permitAll()//放行对静态资源的请求
                .antMatchers("/**").authenticated()
//                .antMatchers("/getMenu").authenticated()
//                .antMatchers("/privilege/**").authenticated()//在访问对应url时需要在security系统中已有身份(已登录)；具体的请求在controller中验证权限开放
                .anyRequest().permitAll()//对于剩余未作定义的默认为向所有访问公开
                .and()
                .exceptionHandling()//定义页面异常处理
                .accessDeniedHandler(new WebAccessDeniedHandler())//访问拒绝异常处理

        ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring().antMatchers("/static/**")
        ;
    }

    /************************
     * 密码加密器
     * @return
     */
    public PasswordEncoder passwordEncoder(){
        //TODO 暂时使用的是无加密编码器（直译）
        return NoOpPasswordEncoder.getInstance();
    }


}
