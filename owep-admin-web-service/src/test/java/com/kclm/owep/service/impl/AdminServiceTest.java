package com.kclm.owep.service.impl;

import com.kclm.owep.dto.AdministratorDTO;
import com.kclm.owep.service.AdminService;
import com.kclm.owep.service.BaseServiceTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminServiceTest extends BaseServiceTests {

    @Autowired
    private AdminService adminService;

    @Test
    public void testSelectAdministrator() {
        List<AdministratorDTO> administratorList = adminService.selectAdministrator();
        //
        Assert.notNull(administratorList, "无任何管理员");
        //
        administratorList.forEach(System.out::println);
    }

    @Test
    void selectAdministratorByuserNameAndrealName() {

        List<AdministratorDTO> administratorDTOS = adminService.selectAdministratorByuserNameAndrealName("admin", "");
        administratorDTOS.forEach(System.out::println);
    }
}