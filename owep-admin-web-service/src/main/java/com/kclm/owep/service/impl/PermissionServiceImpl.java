/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.convert.PermissionConvert;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.dto.PermissionDTO;
import com.kclm.owep.dto.PermissionMenuDTO;
import com.kclm.owep.entity.Action;
import com.kclm.owep.entity.Menu;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.mapper.MenuMapper;
import com.kclm.owep.mapper.PermissionMapper;
import com.kclm.owep.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/15 12:01
 * @description:
 **/
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private PermissionConvert permissionConvert;

    @Override
    public int saveOrUpdate(Permission permission) {
        Assert.notNull(permission.getPermissionName(), "对象不能为空");
        Integer id = permission.getId();
        if (id == null) {
            return permissionMapper.save(permission);

        } else if (id > 0) {
            return permissionMapper.update(permission);
        }
        return -1;
    }

    @Override
    public int deletePermission(List<Serializable> ids) {
        Assert.notNull(ids, "ids对象不能为空");


        menuMapper.deleteByPerIdInAPM(ids);
        if (ids.size() == 1) {
            permissionMapper.deleteMenusByPermissionId(ids);
            return permissionMapper.deleteById(ids.get(0));
        } else if (ids.size() > 1) {
            for(int i=0;i<ids.size();i++){  permissionMapper.deleteMenusByPermissionId(ids.subList(i,i+1));}
            return permissionMapper.deleteSelect(ids);
        }
        return -1;
    }

    @Override
    public PermissionDTO selectById(Serializable id) {
        if (id != null) {
            Permission permission = permissionMapper.selectById(id);
            return permissionConvert.toDto(permission);
        } else {
            throw new IllegalArgumentException("id值不合法");
        }
    }

    @Override
    public List<PermissionDTO> selectByName(String name) {
        Assert.notNull(name, "name为空");
        List<Permission> permissions = permissionMapper.selectByName(name);
        return permissionConvert.mapList(permissions);
    }

    @Override
    public List<PermissionDTO> selectAllPermission(int pageNum) {
        if (pageNum >= 0) {
            //PageHelper.startPage(pageNum, PAGE_SIZE);
            List<Permission> permissions = permissionMapper.selectAll();
            return permissionConvert.mapList(permissions);
        } else {
            throw new IllegalArgumentException("pageNum值不合法");
        }
    }

    @Override
    public PermissionMenuDTO selectMenuByPermissionId(Serializable perId) {
        if (perId != null) {
            List<Permission> permissions = permissionMapper.selectMenuInPermission(perId);//获取所有与本权限相关的菜单（p-m中间表）
            Permission permission = permissions.get(0);
            return permissionConvert.toPermissionMenuDto(permission);

        } else {
            throw new IllegalArgumentException("perId值不合法");
        }
    }

    @Override
    public List<NodeDTO> selectAllMenus() {

        List<Menu> menus = menuMapper.selectAll();
        List<NodeDTO> nodeDTOs = new ArrayList<>();
        for (Menu menu: menus) {
            menu.setParent(menuMapper.selectParent(menu.getId()).getParent());
            if(menu.getParent()==null){//只处理顶级节点
            NodeDTO nodeDTO = new NodeDTO();
            nodeDTO.setTags(menu.getId());
            nodeDTO.setText(menu.getMenuName());
                List<Menu> childMenus = menuMapper.selectMenuChild(menu.getId()).getChildMenus();//查子菜单
                if(childMenus!=null&&childMenus.size()>0){//不为空则处理
                    List<NodeDTO> nodes = new ArrayList<>();
                    for (Menu childMenu :childMenus) {
                        NodeDTO childNode = new NodeDTO();
                        childNode.setTags(childMenu.getId());
                        childNode.setText(childMenu.getMenuName());
                        nodes.add(childNode);
                    }
                    nodeDTO.setNodes(nodes);
                }//nodes已添加
                nodeDTOs.add(nodeDTO);
            }//if
            else{//如果不是顶级节点
                System.out.println("非顶级节点，抛弃"+menu.getId());;//爱咋咋地，抛弃
            }
        }//遍历完所有menu
        return nodeDTOs;
    }

    @Override
    public int assignMenuToPermission(Map<Integer, List<Integer>> map) {
        Assert.notNull(map, "map对象不能为空");
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        try {
            for (Map.Entry<Integer, List<Integer>> next : entries) {
                Integer key = next.getKey();
                List<Integer> value = next.getValue();
                permissionMapper.deleteMenusByPermissionId(Arrays.asList(key));
                value.forEach(e -> permissionMapper.assignMenuToPermission(key, e));
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;

        }
    }

    @Override
    public List<Action> selectActionByPermission(Serializable perId) {
        List<Permission> permissionList = permissionMapper.selectActionInPermission(perId);
        Permission permission = permissionList.get(0);
        if (permission!=null){
            List<Action> actions = permission.getActions();
           return actions;
            }
        return null;
        }
    }

