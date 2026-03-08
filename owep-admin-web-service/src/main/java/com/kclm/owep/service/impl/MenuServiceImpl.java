/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.convert.ActionConvert;
import com.kclm.owep.convert.MenuConvert;
import com.kclm.owep.dto.ActionMenuPermissionDTO;
import com.kclm.owep.dto.MenuDTO;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.entity.Action;
import com.kclm.owep.entity.Menu;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.mapper.ActionMapper;
import com.kclm.owep.mapper.MenuMapper;
import com.kclm.owep.mapper.PermissionMapper;
import com.kclm.owep.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/15 14:00
 * @description:
 **/
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private ActionMapper actionMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private MenuConvert menuConvert;
    @Autowired
    private ActionConvert actionConvert;

    @Override
    public int saveOrUpdate(Menu menu) {
        Assert.notNull(menu.getMenuName(), "对象不能为空");
        Integer id = menu.getId();
        if (id == null) {
            return menuMapper.save(menu);

        } else if (id > 0) {
            return menuMapper.update(menu);
        }
        return -1;
    }

    @Override
    public int deleteMenu(List<Serializable> ids) {
        Assert.notNull(ids, "ids对象不能为空");
        menuMapper.deleteByMenuIdInAPM(ids);
        permissionMapper.deleteMenusByMenuId(ids);
        if (ids.size() == 1) {
            return menuMapper.deleteById(ids.get(0));
        } else if (ids.size() > 1) {
            return menuMapper.deleteSelect(ids);
        }
        return -1;
    }


    @Override
    public MenuDTO selectById(Serializable id) {
        if (id != null) {
            Menu menu = selectChildMenus(id);
            MenuDTO menuDTO = new MenuDTO();
            if(menu != null) {
                menuDTO.setId(menu.getId());
                menuDTO.setMenuName(menu.getMenuName());
                menuDTO.setMenuUrl(menu.getMenuUrl());
                menuDTO.setMenuDescription(menu.getMenuDescription());
                List<MenuDTO> subMenus = new ArrayList<>();
                for (Menu childMenu : menu.getChildMenus()) {
                    MenuDTO subMenu = new MenuDTO();
                    subMenu.setId(childMenu.getId());
                    subMenu.setMenuDescription(childMenu.getMenuDescription());
                    subMenu.setMenuName(childMenu.getMenuName());
                    subMenu.setMenuUrl(childMenu.getMenuUrl());
                    subMenu.setPid(menu.getId());
                    subMenus.add(subMenu);
                }
                menuDTO.setSubMenus(subMenus);
            }
            return menuDTO;
        }
         else {
            throw new IllegalArgumentException("id值不合法");
        }
    }

    @Override
    public List<MenuDTO> selectAllMenu() {
        List<Menu> menus = menuMapper.selectAll();
        List<MenuDTO> menuDTOS =new ArrayList<>();
        for (Menu menu: menus) {//
            menu.setParent(menuMapper.selectParent(menu.getId()).getParent());

            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setMenuName(menu.getMenuName());
            menuDTO.setId(menu.getId());
            menuDTO.setMenuDescription(menu.getMenuDescription());
            menuDTO.setMenuUrl(menu.getMenuUrl());

            if(menu.getParent() != null){
                menuDTO.setPid(menu.getParent().getId());
            }
            menuDTOS.add(menuDTO);//平坦设置
        }//遍历完
        return menuDTOS;

    }

    @Override
    public int assignActionToMenu(Map<Integer, List<Integer>> map) {
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        try {
            for (Map.Entry<Integer, List<Integer>> next : entries) {
                Integer key = next.getKey();
                menuMapper.deleteByMenuIdInAPM(Arrays.asList(key));
                Menu menu = menuMapper.selectPermissionInMenu(key).get(0);
                List<Permission> permissions = menu.getPermissions();
                List<Integer> value = next.getValue();
                for (Permission p : permissions) {
                    value.forEach(e -> menuMapper.assignActionToMenuAndPermission(key, e, p.getId()));
                }
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int assignActionToMenuAndPermission(ActionMenuPermissionDTO actionMenuPermissionDTO){
        List<Integer> actionIds = actionMenuPermissionDTO.getActionIds();
        Integer menuId = actionMenuPermissionDTO.getMenuId();
        Integer permissionId = actionMenuPermissionDTO.getPermissionId();
        try {
            menuMapper.deleteByPermIdAndMenuIdInAPM(permissionId,menuId);
            for (Integer actionId:actionIds){
                System.out.println("assign action:"+actionId+"to P:"+permissionId+" M:"+menuId);//todo
                menuMapper.assignActionToMenuAndPermission(menuId,actionId,permissionId);
            }
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public ActionMenuPermissionDTO selectActionAndPermissionByMenuId(Serializable menuId) {
        Assert.notNull(menuId, "menuId不能为空");
        List<Menu> menus = menuMapper.selectAllInAPM(menuId, 0, 0);
        //
        if(menus != null && !menus.isEmpty()) {
            return menuConvert.toActionMenuPermissionDto(menus.get(0));
        }
        //
        return null;
    }

    @Override
    public ActionMenuPermissionDTO selectActionByPermissionId(Serializable perId, Serializable menuId) {
        List<Menu> menus = menuMapper.selectAllInAPM(menuId, perId, 0);
        //
        if(menus != null && !menus.isEmpty()) {
            return menuConvert.toActionMenuPermissionDto(menus.get(0));
        }
        //
        return null;
    }

    @Override
    public Set<ActionMenuPermissionDTO> selectActionByPermissionIdFromAMP(Serializable perId) {
        List<Menu> menus = menuMapper.selectAllInAPM(0, perId, 0);
        Set<ActionMenuPermissionDTO> resultSet = new HashSet<>();
        for (Menu menu:menus) {
            Integer menuId = menu.getId();
            for(Action action :menu.getActions()){
                ActionMenuPermissionDTO actionMenuPermissionDTO = new ActionMenuPermissionDTO();
                actionMenuPermissionDTO.setActionId(action.getId());
                actionMenuPermissionDTO.setMenuId(menuId);
                actionMenuPermissionDTO.setPermissionId((Integer) perId);
                resultSet.add(actionMenuPermissionDTO);
            }
        }
        return resultSet;
    }

    @Override
    public NodeDTO selectAllAction() {
        List<Action> actions = actionMapper.selectAll();
        //
        List<NodeDTO> nodeDTOS = actionConvert.toNodeDtoList(actions);
        //组装
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setTags(0);
        nodeDTO.setText("分配行为");
        nodeDTO.setNodes(nodeDTOS);
        return nodeDTO;
    }

    @Override
    public NodeDTO selectActionByMenuIdAndPermissionId(Serializable menuId, Serializable perId) {
        List<Menu> menus = menuMapper.selectAllInAPM(menuId, perId, 0);
        //
        List<NodeDTO> nodeDTOS = actionConvert.toNodeDtoList(menus.get(0).getActions());
        //组装
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setTags(0);
        nodeDTO.setText("分配行为");
        nodeDTO.setNodes(nodeDTOS);
        return nodeDTO;
    }

    @Override
    public NodeDTO selectActionByMenuId(Serializable menuId) {
        List<Menu> menus = menuMapper.selectActionInMenu(menuId);
        //
        List<NodeDTO> nodeDTOS = actionConvert.toNodeDtoList(menus.get(0).getActions());
        //组装
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setTags(0);
        nodeDTO.setText("分配行为");
        nodeDTO.setNodes(nodeDTOS);
        return nodeDTO;
    }

    @Override
    public Menu selectChildMenus(Serializable menuId) {
        Assert.notNull(menuId, "菜单id不允许为null");
        return menuMapper.selectMenuChild(menuId);
    }
}
