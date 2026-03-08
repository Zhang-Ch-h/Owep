package com.kclm.owep.service.impl;

import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.dto.RoleDTO;
import com.kclm.owep.dto.RolePermissionDTO;
import com.kclm.owep.entity.Role;
import com.kclm.owep.service.BaseServiceTests;
import com.kclm.owep.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: owep
 * @package: com.kclm.owep.service.impl.privilege
 * @description:
 * @author: qi_kran
 * @create: 2020-07-17 10:35
 **/
public class RoleServiceTest extends BaseServiceTests {

    @Autowired
    private RoleService roleService;
    @Test
    void saveOrUpdate() {
        Role role = new Role("啊啊", "aaa");
        role.setId(10);
        roleService.saveOrUpdate(role);
    }

    @Test
    void deleteRole() {
        roleService.deleteRole(Arrays.asList(10));
    }

    @Test
    void selectById() {
        RoleDTO roleDTO = roleService.selectById(10);
        System.out.println(roleDTO);
    }

    @Test
    void selectByName() {
        List<RoleDTO> s = roleService.selectByName("啊");
        s.forEach(System.out::println);
    }

    @Test
    void selectAllRoles() {
        List<RoleDTO> roleDTOS = roleService.selectAllRoles(0);
        roleDTOS.forEach(System.out::println);
    }

    @Test
    void selectAllDTO() {
        NodeDTO nodeDTO = roleService.selectAllDTO();
        System.out.println(nodeDTO);
        nodeDTO.getNodes().forEach(System.out::println);
    }

    @Test
    void selectPermissionByRoleId() {
        RolePermissionDTO rolePermissionDTO = roleService.selectPermissionByRoleId(3);
        System.out.println(rolePermissionDTO);
        rolePermissionDTO.getPermissionIds().forEach(System.out::println);
    }

    @Test
    void assignPermissionToRole() {
        Map<Integer,List<Integer>> map=new HashMap<>();

        map.put(1,Arrays.asList(1,2));
        roleService.assignPermissionToRole(map);
    }

    @Test
    void selectParentRole() {
        RoleDTO roleDTO = roleService.selectParentRole(3);
        System.out.println(roleDTO);
    }
}
