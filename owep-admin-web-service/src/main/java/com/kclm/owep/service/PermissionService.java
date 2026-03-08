/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.service;

import com.kclm.owep.dto.*;
import com.kclm.owep.entity.Action;
import com.kclm.owep.entity.Permission;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/13 14:26
 * @description: 权限
 **/
public interface PermissionService {
    int PAGE_SIZE = 10;

    /**
     * 添加或更新权限，根据permission中的id是否为空来执行哪种方法。
     *
     * @param permission
     * @return 大于0则执行成功，等于或小于0则执行失败
     */
    int saveOrUpdate(Permission permission);

    /**
     * 根据传入的iD集合来删除或批量删除权限
     *
     * @param ids
     * @return 大于0则执行成功，等于或小于0则执行失败
     */
    int deletePermission(List<Serializable> ids);

    /**
     * 根据iD查询
     *
     * @param id
     * @return 大于0则执行成功，等于或小于0则执行失败
     */
    PermissionDTO selectById(Serializable id);

    /**
     * 根据字符串进行模糊查询
     *
     * @param name
     * @return 大于0则执行成功，等于或小于0则执行失败
     */
    List<PermissionDTO> selectByName(String name);

    /**
     * 分页查询所有的权限
     *
     * @param pageNum
     * @return 返回当前页的10条数据
     */
    List<PermissionDTO> selectAllPermission(int pageNum);

    /**
     *  根据权限id查询相关的菜单
     * @param perId
     * @return
     */

    PermissionMenuDTO selectMenuByPermissionId(Serializable perId);

    /**
     * 查询所有的菜单，并且需要将其封装程Node对象将其返回
     * 无需先写死对象，将数据库中的所有菜单信息封装到Node中，tags对应ID信息，text对象菜单名
     * list对应子菜单。
     * @return
     */
    List<NodeDTO> selectAllMenus();

    /**
     * 为权限分配菜单
     * @param map
     * @return 大于0则执行成功，等于或小于0则执行失败
     */
    int assignMenuToPermission(Map<Integer, List<Integer>> map);

    List<Action> selectActionByPermission(Serializable perId);

}
