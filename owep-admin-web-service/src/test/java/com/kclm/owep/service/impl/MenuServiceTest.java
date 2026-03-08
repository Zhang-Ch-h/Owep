package com.kclm.owep.service.impl;

import com.kclm.owep.dto.ActionMenuPermissionDTO;
import com.kclm.owep.dto.MenuDTO;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.entity.Menu;
import com.kclm.owep.service.BaseServiceTests;
import com.kclm.owep.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: owep
 * @package: com.kclm.owep.service
 * @description:
 * @author: qi_kran
 * @create: 2020-07-17 10:34
 **/
public class MenuServiceTest extends BaseServiceTests {

    @Autowired
    private MenuService menuService;

    @Test
    void saveOrUpdate() {
        Menu menu = new Menu("sssaa", "aa", "aa", "aa");
        menu.setId(12);
        menuService.saveOrUpdate(menu);

    }

    @Test
    void deleteMenu() {
        menuService.deleteMenu(Arrays.asList(12));
    }

    @Test
    void selectById() {
        MenuDTO menuDTO = menuService.selectById(2);
        System.out.println(menuDTO);
    }

    @Test
    void selectAllMenu() {
        List<MenuDTO> menuDTOS = menuService.selectAllMenu();
        menuDTOS.forEach(System.out::println);
    }

    @Test
    void assignActionToMenu() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(3, Arrays.asList(2, 3));
        menuService.assignActionToMenu(map);
    }

    @Test
    void selectActionAndPermissionNyMenuId() {
        ActionMenuPermissionDTO actionMenuPermissionDTO = menuService.selectActionAndPermissionByMenuId(3);
        System.out.println(actionMenuPermissionDTO);
        actionMenuPermissionDTO.getPermissionIds().forEach(System.out::println);
        System.out.println("--------");
        actionMenuPermissionDTO.getActionIds().forEach(System.out::println);
    }

    @Test
    void selectActionByPermissionId() {
        menuService.selectActionByPermissionId(1, 2);

    }

    @Test
    void selectAllAction() {
        NodeDTO nodeDTO = menuService.selectAllAction();
        System.out.println(nodeDTO);
    }

    @Test
    void selectActionByMenuIdAndPermissionId() {
        NodeDTO nodeDTO = menuService.selectActionByMenuIdAndPermissionId(3, 1);
        System.out.println(nodeDTO);
    }

    @Test
    void selectActionByMenuId() {
        NodeDTO nodeDTO = menuService.selectActionByMenuId(3);
        System.out.println(nodeDTO);
    }
}
