package com.kclm.owep.mapper.privilege;

import com.kclm.owep.entity.Permission;
import com.kclm.owep.mapper.BaseMapperTest;
import com.kclm.owep.mapper.PermissionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @program: owep
 * @package: com.kclm.owep.mapper.privilege
 * @description:
 * @author: qi_kran
 * @create: 2020-07-08 14:01
 **/
class PermissionMapperTest extends BaseMapperTest {
    @Autowired
    private PermissionMapper permissionMapper;

    @Test
    void save() {
       /* permissionMapper.save(new Permission("权限1", "测试权限1"));
        permissionMapper.save(new Permission("权限2", "测试权限2"));
        permissionMapper.save(new Permission("权限3", "测试权限3"));
        permissionMapper.save(new Permission("权限4", "测试权限4"));
        */
        permissionMapper.save(new Permission("权限5", "测试权限5"));
        permissionMapper.save(new Permission("权限6", "测试权限6"));
        permissionMapper.save(new Permission("权限7", "测试权限7"));

    }

    @Test
    void selectById() {
        Permission permission = permissionMapper.selectById(1);
        System.out.println(permission);
    }

    @Test
    void selectByAll() {
        List<Permission> permissions = permissionMapper.selectAll();
        permissions.forEach(System.out::println);
    }

    @Test
    void update() {
        Permission permission = permissionMapper.selectById(4);
        permissionMapper.update(permission);

    }

    @Test
    void deleteById() {
        permissionMapper.deleteById(7);
        permissionMapper.deleteSelect(Arrays.asList(6, 5));
    }

    @Test
    void findByName() {
        List<Permission> name = permissionMapper.selectByName("1");
        name.forEach(System.out::println);
    }

    @Test
    void findRoleInPermission() {
        List<Permission> permission = permissionMapper.selectRoleInPermission(1);
        permission.forEach(System.out::println);
    }

    @Test
    void findMenuInPermission() {
        List<Permission> menuInPermission = permissionMapper.selectMenuInPermission(1);
        menuInPermission.forEach(System.out::println);
        menuInPermission.get(0).getMenus().forEach(System.out::println);
    }

    @Test
    void findActionInPermission() {
    }

    @Test
    void assignMenuToPermission() {
      /*  permissionMapper.assignMenuToPermission(1, 1);
        permissionMapper.assignMenuToPermission(1, 2);
        permissionMapper.assignMenuToPermission(2, 1);
        permissionMapper.assignMenuToPermission(2, 2);*/
        permissionMapper.assignMenuToPermission(1, 3);
        permissionMapper.assignMenuToPermission(2, 3);
        permissionMapper.assignMenuToPermission(3, 4);
        permissionMapper.assignMenuToPermission(2, 4);
    }

    @Test
    void deleteMenusByPermissionId() {
        permissionMapper.deleteMenusByPermissionId(Arrays.asList(1));
    }
}