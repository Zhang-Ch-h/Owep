/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.service.impl;

import com.github.pagehelper.PageHelper;
import com.kclm.owep.convert.PermissionConvert;
import com.kclm.owep.convert.RoleConvert;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.dto.RoleDTO;
import com.kclm.owep.dto.RolePermissionDTO;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.entity.Role;
import com.kclm.owep.mapper.PermissionMapper;
import com.kclm.owep.mapper.RoleMapper;
import com.kclm.owep.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/15 11:27
 * @description:
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RoleConvert roleConvert;
    @Autowired
    private PermissionConvert permissionConvert;

    @Override
    public int saveOrUpdate(Role role) {
        Assert.notNull(role.getRoleName(), "role");
        Integer id = role.getId();
        if (id == null) {
            return roleMapper.save(role);

        } else if (id > 0) {
            return roleMapper.update(role);
        }
        return -1;
    }

    @Override
    public int deleteRole(List<Serializable> ids) {
        Assert.notNull(ids, "ids对象不能为空");
        roleMapper.deletePermissionByRoleId(ids);
        roleMapper.deleteRoleInGR(ids);
        if (ids.size() == 1) {
            return roleMapper.deleteById(ids.get(0));
        } else if (ids.size() > 1) {
            return roleMapper.deleteSelect(ids);
        }
        return -1;
    }

    @Override
    public RoleDTO selectById(Serializable id) {
        if (id != null) {
            Role role = roleMapper.selectById(id);
            //
            return roleConvert.toDto(role);
        } else {
            throw new IllegalArgumentException("id值不合法");
        }

    }

    @Override
    public List<RoleDTO> selectByName(String name) {
        Assert.notNull(name, "name为空");
        List<Role> roles = roleMapper.selectByName(name);
        return roleConvert.toDtoList(roles);
    }

    @Override
    public List<RoleDTO> selectAllRoles(int pageNum) {
        if (pageNum >= 0) {
            //PageHelper.startPage(pageNum, PAGE_SIZE);
            List<Role> roles = roleMapper.selectAll();
            return roleConvert.toDtoList(roles);
        } else {
            throw new IllegalArgumentException("pageNum值不合法");
        }
    }

    @Override
    public NodeDTO selectAllDTO() {
        List<Permission> permissions = permissionMapper.selectAll();
        List<NodeDTO> nodeDTOS = permissionConvert.toNodeDtoList(permissions);
        //
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setText("权限");
        nodeDTO.setNodes(nodeDTOS);
        nodeDTO.setTags(0);
        return nodeDTO;
    }

    @Override
    public RolePermissionDTO selectPermissionByRoleId(Serializable roleId) {
        if (roleId != null) {
            List<Role> roleList = roleMapper.selectPermissionInRole(roleId);
            Role role = roleList.get(0);
            //todo 有可能转换不正确
            return roleConvert.toRolePermissionDto(role);

        } else {
            throw new IllegalArgumentException("roleId值不合法");
        }
    }

    @Override
    public int assignPermissionToRole(Map<Integer, List<Integer>> map) {
        Assert.notNull(map, "map对象不能为空");
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        for (Map.Entry<Integer, List<Integer>> next : entries) {
            Integer key = next.getKey();
            roleMapper.deletePermissionByRoleId(Arrays.asList(key));
            List<Integer> value = next.getValue();
            value.forEach(e -> roleMapper.assignPermissionToRole(key, e));
        }
        return 1;
    }

    @Override
    public RoleDTO selectParentRole(Serializable roleId) {
        Assert.notNull(roleId, "roleId不能为空");
        List<Role> roles = roleMapper.selectParent(roleId);
        if (!roles.isEmpty()) {
            return roleConvert.toDto(roles.get(0).getParent());
        } else {
            return null;
        }


    }
}
