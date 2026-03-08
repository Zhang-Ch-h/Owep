/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.service;

import com.kclm.owep.dto.ActionMenuPermissionDTO;
import com.kclm.owep.dto.MenuDTO;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.entity.Menu;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/13 15:41
 * @description: 菜单
 **/
public interface MenuService {
    /**
     * 添加或更新菜单，根据ID是否为空来判断执行哪种方法。
     *
     * @param menu
     * @return 大于0执行成功，等于或小于0执行失败。
     */
    int saveOrUpdate(Menu menu);

    /**
     * 批量或单个删除
     *
     * @param ids
     * @return 大于0执行成功，等于或小于0执行失败。
     */
    int deleteMenu(List<Serializable> ids);

    /**
     * 根据ID获取菜单
     *
     * @param id
     * @return
     */
    MenuDTO selectById(Serializable id);

    /**
     * 查询所有菜单并展示其父子级，无需分页,无需封装成Node。
     *
     * @return
     */
    List<MenuDTO> selectAllMenu();

    /**
     * 为菜单分配行为
     *
     * @param map
     * @return
     */
    int assignActionToMenu(Map<Integer, List<Integer>> map);

    /**
     * 该方法可能弃用！！
     * 根据菜单ID获取相关的权限和行为
     * 注意：该查询会出现 部分数据重复 从而导致记录数无法匹配 如 菜单3 下对应两条 权限为2 两条行为为1 2的记录
     * 这其中 两条权限为2的记录因为是重复的 所有会变成一条。
     * @param menuId
     * @return
     */
    ActionMenuPermissionDTO selectActionAndPermissionByMenuId(Serializable menuId);

    /**
     * 根据权限id查询相关的行为
     * @param perId
     * @return
     */
    ActionMenuPermissionDTO selectActionByPermissionId(Serializable perId,Serializable menuId);

    Set<ActionMenuPermissionDTO> selectActionByPermissionIdFromAMP(Serializable perId);

    /**
     * 查询所有的行为，并封装成Node对象，需写死一个text为行为的父对象，在子（list中）
     * 写入数据库中所拥有的行为数据。text对应名字，tags对应id
     * @return
     */
    NodeDTO selectAllAction();

    /**
     * 根据菜单ID和权限ID查询它所包含的一些默认行为。并封装成NODE对象
     * 同样需写死一个text为分配行为的父对象，在子（list）写入
     * 数据中跟当前菜单相关的行为。
     * @param menuId
     * @return
     */
    NodeDTO selectActionByMenuIdAndPermissionId(Serializable menuId,Serializable perId);

    /**
     * 根据菜单ID查询所有的相关联的行为
     * @param menuId
     * @return
     */
    NodeDTO selectActionByMenuId(Serializable menuId);

    Menu selectChildMenus(Serializable menuId);

    int assignActionToMenuAndPermission( ActionMenuPermissionDTO actionMenuPermissionDTO);

}
