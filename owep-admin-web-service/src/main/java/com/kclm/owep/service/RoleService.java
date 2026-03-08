/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.service;

import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.dto.PermissionDTO;
import com.kclm.owep.dto.RoleDTO;
import com.kclm.owep.dto.RolePermissionDTO;
import com.kclm.owep.entity.Role;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/13 10:58
 * @description: 角色接口
 **/

public interface RoleService {

    int PAGE_SIZE=10;

    /**
     * 添加或更新角色，根据传入的role中的id是否为空来判断执行哪个mapper
     * @param role
     * @return 大于0则执行成功  等于或小于0执行失败
     */
    int saveOrUpdate(Role role);

    /**
     * 根据传入的集合进行单个删除或批量删除
     * @param ids
     * @return 大于0则执行成功  等于或小于0执行失败
     */
    int deleteRole(List<Serializable> ids);

    /**
     * 根据传入的id值进行查询
     * @param id
     * @return 大于0则执行成功  等于或小于0执行失败
     */
    RoleDTO selectById(Serializable id);

    /**
     * 根据传入的字符串进行模糊查询
     * @param name
     * @return
     */
    List<RoleDTO> selectByName(String name);

    /**
     * 查询所有的角色 需要进行分页
     * @param pageNum
     * @return 返回当前页的10条数据
     */
    List<RoleDTO> selectAllRoles(int pageNum);

    /**
     * 查询所有的权限数据，需要封装程NODE对象
     * 写死一个text为权限的对象并在子（list）中写入数据库的所有权限。
     * @return
     */
    NodeDTO selectAllDTO();

    /**
     * 根据传入的角色ID查询所所关联的权限。并抽取里面的ID到中间表对象中返回
     * @param roleId
     * @return
     */
    RolePermissionDTO selectPermissionByRoleId(Serializable roleId);

    /**
     * 给角色分配权限，具体业务逻辑同用户组分配角色，
     * @param map
     * @return 大于0则执行成功  等于或小于0执行失败
     */
    int assignPermissionToRole(Map<Integer,List<Integer>> map);

    /**
     * 根据传入的id对角色查询其是否拥有父角色
     * @param roleId
     * @return null则没有父角色，否则返回父角色
     */
    RoleDTO selectParentRole(Serializable roleId);



}
