/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Menu;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/7 15:54
 * @description:菜单接口
 **/
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 自关联查询 查询菜单的父级菜单
     * 传入0则查出所有菜单 并且查出其父级菜单
     */
    Menu selectParent(Serializable id);

    /**
     * 自关联查询 查询子菜单 传入0则查询所有
     */
    Menu selectMenuChild(Serializable menuId);

    /**
     * 向中间表插入数据 给菜单分配行为 需要传入该菜单所关联的权限
     */
    int assignActionToMenuAndPermission(@Param("menuId") Serializable menuId, @Param("actionId") Serializable actionId, @Param("perId") Serializable perId);

    /**
     * 更新中间表的数据
     * 以菜单Id为条件
     */
    int updateInAPMByMenuId(@Param("perId") Serializable perId, @Param("actionId") Serializable actionId, @Param("menuId") Serializable menuId);

    /**
     * 更新中间表的数据
     * 以权限Id为条件
     */
    int updateInAPMByPerId(@Param("perId") Serializable perId, @Param("actionId") Serializable actionId, @Param("menuId") Serializable menuId);

    /**
     * 删除中间表的数据 以MenuId为准
     */
    int deleteByMenuIdInAPM(List<Serializable> menuId);

    /**
     * 以行为ID删除中间表数据
     *
     * @param actionId
     * @return
     */
    int deleteByActionIdInAPM(List<Serializable> actionId);

    /**
     * 以权限ID删除中间表数据
     *
     * @param perId
     * @return
     */
    int deleteByPerIdInAPM(List<Serializable> perId);

    int deleteByPermIdAndMenuIdInAPM(@Param("perId") Serializable perId, @Param("menuId") Serializable menuId);

    /**
     * 外联查询 查询菜单所关联的行为 可利用ID查单个对象
     */
    List<Menu> selectActionInMenu(Serializable ac);

    /**
     * 外联查询  查询菜单所关联的权限 可利用进行条件查询
     */
    List<Menu> selectPermissionInMenu(Serializable menuId);

    /**
     * 外联查询 三表关联查询 同时附加menu自关联查询 查询其子孩子
     * 传入0 则查询所有
     */
    List<Menu> selectAllInAPM(@Param("menuId") Serializable menuId, @Param("perId") Serializable perId, @Param("actionId") Serializable actionId);

    /**
     * 统计中间表数据
     */
    int countInAPM();

    /**
     * 统计菜单表的数据
     */
    int count();
}