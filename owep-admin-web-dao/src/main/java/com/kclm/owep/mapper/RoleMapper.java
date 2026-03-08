/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Role;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/5 9:41
 * @description: 角色接口
 **/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据角色名字 模糊查询
     * */
    List<Role> selectByName(String roleName);


    /**
     * 自关联查询,查询出该角色下的所有子角色
     * 传入 0 则列出所有角色 同时查出其子角色
     * */
    List<Role> selectChild(Serializable Id);
    /**
     * 自关联查询，查询父角色
     * 传入0则查询所有角色 同时查出该角色的父角色
     * */
    List<Role> selectParent(Serializable Id);
    /**
     * 外关联查询,某角色下的所有组
     * 传入0则查询所有
     * */
    List<Role> selectGroupsByRoleId(Serializable roleId);

    /**
     * 外关联查询,查询该角色下所分配的权限
     * 传入0则查询所有
     * */
    List<Role> selectPermissionInRole(Serializable roleId);

    /**
     * 向角色权限中间表添加数据 给角色发呢配权限
     * */
    int assignPermissionToRole(@Param("roleId") Serializable roleId, @Param("perId") Serializable perId);

    /**
     * 删除该角色所分配的所有的权限
     * */
    int deletePermissionByRoleId(List<Serializable> roleIds);

    /**
     * 根据角色ID删除group_role中间表相关的数据
     * @param roleIds
     * @return
     */
    int deleteRoleInGR(List<Serializable> roleIds);
    /**
     * 删除某角色下的某个权限
     * */
    int deletePermissionByPerIdAndRoleId(@Param("roleId") Serializable roleId, @Param("perId") Serializable perId);

    /**
     * 统计该角色所具有的权限数量 传入0则查询所有
     * */
    int countPermissionByRoleId(Serializable roleId);

    /**
     * 统计表中数据
     * */
    int count();


}