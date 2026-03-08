package com.kclm.owep.service.impl;

import com.kclm.owep.dto.AdministratorDTO;
import com.kclm.owep.dto.UserDto;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.service.AdminService;
import com.kclm.owep.service.BaseServiceTests;
import com.kclm.owep.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class UserServiceTest extends BaseServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void testSelectByName() {
        UserDto admin = userService.selectByName("admin");
        //
        Assert.notNull(admin,"无此对象");
        //
        System.out.println(admin);
    }

    @Test
    public void testGetPermissionListByUserId() {
        List<Permission> permissionList = userService.getPermissionListByUserId(1);
        //
        Assert.notNull(permissionList, "无任何权限");
        //
        permissionList.forEach(System.out::println);
    }
}
