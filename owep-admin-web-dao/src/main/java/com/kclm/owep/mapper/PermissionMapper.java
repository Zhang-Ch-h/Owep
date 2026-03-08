/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.mapper;

import com.kclm.owep.entity.Permission;

import java.io.Serializable;
import java.util.List;

import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/7 15:54
 * @description:权限接口
 **/
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
    /**
     * 根据名字查询
     */
    List<Permission> selectByName(String name);

    /**
     * 外联查询 查询关联某个权限的所有角色 可传Id进行条件查询。不传则默认查询所有
     */
    List<Permission> selectRoleInPermission(Serializable perId);

    /**
     * 外联查询 查询权限下所关联的菜单 可传Id进行条件查询。传0则默认查询所有
     */
    List<Permission> selectMenuInPermission(Serializable perId);

    /**
     * 外联查询 查询权限下所关联的行为 可传Id进行条件查询。传0则默认查询所有
     */
    List<Permission> selectActionInPermission(Serializable perId);

    /**
     * 向中间表插入数据 给权限分配菜单
     */
    int assignMenuToPermission(@Param("perId") Serializable perId, @Param("menuId") Serializable menuId);

    /**
     * 向中间表删除数据 根据权限Id删除关联的菜单
     */
    int deleteMenusByPermissionId(List<Serializable> perIds);

    /**
     * 以菜单ID删除菜单权限中间表的数据
     * @param menuIds
     * @return
     */
    int deleteMenusByMenuId(List<Serializable> menuIds);
    /**
     * 向中间表插入数据 给权限分配行为
     */
/*
    int assignActionToPermission(@Param("perId") Integer perId, @Param("menuId") Integer menuId,@Param("actionId") Integer actionId);
*/

}