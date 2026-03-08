package com.kclm.owep.mapper.privilege;

import com.kclm.owep.entity.Role;
import com.kclm.owep.mapper.BaseMapperTest;
import com.kclm.owep.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @package: com.kclm.owep.mapper
 * @author: qi_kran
 * @create: 2020-07-06 11:22
 * @description: 角色测试类
 **/
class RoleMapperTest extends BaseMapperTest {
    @Autowired
    private RoleMapper roleMapper;


    @Test
    void updateRole() {
        Role role3 = roleMapper.selectById(3);
        Role role4 = roleMapper.selectById(4);
        Role role1 = roleMapper.selectById(1);
        role3.setParent(role1);
        role4.setParent(role1);
        /*更新父亲角色*/
        //roleMapper.update(role3);
        roleMapper.update(role4);

    }
    @Test
    void update(){
        Role role = roleMapper.selectById(1);
        roleMapper.update(role);
    }

    @Test
    void delRoleById() {
        roleMapper.deleteById(5);
    }

    @Test
    void findAll() {
        List<Role> roles = roleMapper.selectAll();
        roles.forEach(System.out::println);
    }

    @Test
    void findById() {
        Role role = roleMapper.selectById(1);
        System.out.println(role);
    }

    @Test
    void findByName() {
        List<Role> roleList = roleMapper.selectByName("1");
        System.out.println(roleList);
    }

    @Test
    void findChilds() {
        List<Role> role = roleMapper.selectChild(0);
    }

    @Test
    void findParent() {
        List<Role> parent = roleMapper.selectParent(3);
        parent.forEach(System.out::println);

    }

    @Test
    void findGroupsByRoleId() {
        List<Role> groups = roleMapper.selectGroupsByRoleId(1);

    }

    @Test
    void findPermissionInRole() {
        List<Role> role = roleMapper.selectPermissionInRole(2);
    }

    @Test
    void saveRoleForPermission() {
        roleMapper.assignPermissionToRole(1, 1);
        roleMapper.assignPermissionToRole(1, 2);
        roleMapper.assignPermissionToRole(2, 2);
        roleMapper.assignPermissionToRole(2, 1);
    }

    @Test
    void delPermissionByRoleId() {
        roleMapper.deletePermissionByRoleId(Arrays.asList(1));
    }

    @Test
    void delPermissionByPerIdAndRoleId() {
        roleMapper.deletePermissionByPerIdAndRoleId(2, 2);
    }

    @Test
    void countPermissionByRoleId() {
        int i = roleMapper.countPermissionByRoleId(1);
        System.out.println(i);
    }

    @Test
    void count() {
        int count = roleMapper.count();
        System.out.println(count);
    }
}