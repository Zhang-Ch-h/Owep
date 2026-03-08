/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */
package com.kclm.owep.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/************
 *@Author chenxin
 *@Version v1.0
 *@Create 2020/7/13 11:36
 *@Description 资料配置DTO
 */
public class SystemConfigDTO implements Serializable {

    private static final long serialVersionUTD=1L;
    /**
     * 系统名称
      */
    private String systemName;
    /**
     *版权所属
     */
    private String copyName;
    /**
     *登录页LOGO
     */
    private String loginPageLogo;
    /**
     *系统页LOGO
     */
    private String systemLogo;

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getCopyName() {
        return copyName;
    }

    public void setCopyName(String copyName) {
        this.copyName = copyName;
    }

    public String getLoginPageLogo() {
        return loginPageLogo;
    }

    public void setLoginPageLogo(String loginPageLogo) {
        this.loginPageLogo = loginPageLogo;
    }

    public String getSystemLogo() {
        return systemLogo;
    }

    public void setSystemLogo(String systemLogo) {
        this.systemLogo = systemLogo;
    }

    @Override
    public String toString() {
        return "SystemConfigDTO{" +
                "systemName='" + systemName + '\'' +
                ", copyName='" + copyName + '\'' +
                ", loginPageLogo='" + loginPageLogo + '\'' +
                ", systemLogo='" + systemLogo + '\'' +
                '}';
    }
}
