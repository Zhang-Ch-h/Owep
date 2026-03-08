/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.dto;

import com.kclm.owep.entity.Menu;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/13 14:53
 * @description: 菜单
 **/
public class MenuDTO extends Menu {
    private Integer id;
    /**
     * 菜单名
     */
    private String menuName;
    /**
     * 菜单描述
     */
    private String menuDescription;
    /**
     * 菜单URL
     */
    private String menuUrl;
    /**
     * 父ID
     */
    private Integer pid;

    /**
     * 下级菜单
     */
    private List<MenuDTO> subMenus;

    /**
     * 图标
     */
    private String iconName;


    static Map<String,String> name_icon = new TreeMap<>();

    static{
        name_icon.put("系统配置","fa fa-home");
        name_icon.put("用户管理","fa fa-users");
        name_icon.put("权限管理","fa fa-lock");
        name_icon.put("资源管理","fa fa-database");
        name_icon.put("培养方案","fa fa-flask");
        name_icon.put("班级管理","fa fa-table");
        name_icon.put("授课管理","fa fa-institution");
        name_icon.put("考试管理","fa fa-tasks");
        name_icon.put("考评管理","fa fa-flag");
        name_icon.put("数据分析","fa fa-bar-chart-o");
        name_icon.put("组织机构","fa fa-sitemap");
        name_icon.put("通知公告","fa fa-bell");
        name_icon.put("咨询管理","fa fa-commenting");
        name_icon.put("意向客户","fa fa-user-plus");
        name_icon.put("操作日志","fa fa-file");

    }

    public MenuDTO() {
    }

    public MenuDTO(Integer pid, String menuName, String menuDescription) {
        this.pid = pid;
        this.menuName = menuName;
        this.menuDescription = menuDescription;
    }

    public MenuDTO(Integer id, String menuName1, String menuDescription1, String menuUrl1, Integer pid, List<MenuDTO> subMenus) {
        this.id = id;
        this.menuName = menuName1;
        this.menuDescription = menuDescription1;
        this.menuUrl = menuUrl1;
        this.pid = pid;
        this.subMenus = subMenus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", menuDescription='" + menuDescription + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", pid=" + pid +
                ", subMenus=" + subMenus +
                ", iconName='" + iconName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MenuDTO menuDTO = (MenuDTO) o;
        return Objects.equals(id, menuDTO.id) &&
                Objects.equals(menuName, menuDTO.menuName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, menuName);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getMenuName() {
        return menuName;
    }

    @Override
    public void setMenuName(String menuName) {
        this.iconName = name_icon.get(menuName);
        this.menuName = menuName;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    @Override
    public String getMenuDescription() {
        return menuDescription;
    }

    @Override
    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    @Override
    public String getMenuUrl() {
        return menuUrl;
    }

    @Override
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<MenuDTO> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<MenuDTO> subMenus) {
        this.subMenus = subMenus;
    }
}
