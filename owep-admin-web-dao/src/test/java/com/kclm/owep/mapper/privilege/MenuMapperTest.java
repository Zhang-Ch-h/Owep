package com.kclm.owep.mapper.privilege;


import com.kclm.owep.entity.Menu;
import com.kclm.owep.mapper.BaseMapperTest;
import com.kclm.owep.mapper.MenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @program: owep
 * @package: com.kclm.owep.mapper.privilege
 * @description:
 * @author: qi_kran
 * @create: 2020-07-08 15:17
 **/
class MenuMapperTest extends BaseMapperTest {
    @Autowired
    private MenuMapper menuMapper;

    @Test
    void save() {
        menuMapper.save(new Menu("菜单1", "/menu1", "测试菜单1", "a11"));
        menuMapper.save(new Menu("菜单2", "/menu2", "测试菜单2", "a12"));
        menuMapper.save(new Menu("菜单3", "/menu3", "测试菜单3", "a13"));
        menuMapper.save(new Menu("菜单4", "/menu4", "测试菜单4", "a14"));
        menuMapper.save(new Menu("菜单5", "/menu5", "测试菜单5", "a15"));
        menuMapper.save(new Menu("菜单6", "/menu6", "测试菜单6", "a16"));
    }

    @Test
    void update() {
        Menu menu4 = menuMapper.selectById(4);
        Menu menu3 = menuMapper.selectById(3);
        Menu menu1 = menuMapper.selectById(1);
        menu3.setParent(menu1);
        menu4.setParent(menu1);
        menuMapper.update(menu3);
        menuMapper.update(menu4);

    }
    @Test
    void updateTest() {
        menuMapper.update(menuMapper.selectById(1));

    }
    @Test
    void findAll() {
        List<Menu> menus = menuMapper.selectAll();
        menus.forEach(System.out::println);
    }

    @Test
    void findById() {
        Menu menu6 = menuMapper.selectById(6);
        System.out.println(menu6);

    }

    @Test
    void delete() {
        menuMapper.deleteById(6);
        menuMapper.deleteSelect(Arrays.asList(5));
    }

    @Test
    void findParent() {
        Menu parent = menuMapper.selectParent(0);
        System.out.println(parent);

    }

    @Test
    void findMenuChild() {
        List<Menu> menuChild = menuMapper.selectMenuChild(0).getChildMenus();
        System.out.println(menuChild.size());
        for (Menu m : menuChild) {
            System.out.println(m);
            System.out.println("m的孩子");
            m.getChildMenus().forEach(System.out::println);
            System.out.println("------");
        }
        menuChild.get(0).getChildMenus().forEach(System.out::println);
    }

    @Test
    void assignActionToMenuAndPermission() {
        /*enuMapper.assignActionToMenuAndPermission(1, 1, 1);
        menuMapper.assignActionToMenuAndPermission(1, 2, 2);*/
        menuMapper.assignActionToMenuAndPermission(2, 2, 2);
        menuMapper.assignActionToMenuAndPermission(3, 2, 2);
        menuMapper.assignActionToMenuAndPermission(4, 2, 2);
        menuMapper.assignActionToMenuAndPermission(4, 2, 3);
    }

    @Test
    void updateInAPM() {

    }

    @Test
    void deleteByMenuIdInAPM() {
        List<Serializable> integers = Arrays.asList(1,4);
        menuMapper.deleteByMenuIdInAPM(integers);
    }

    @Test
    void findActionInMenu() {
        menuMapper.selectActionInMenu(1);
    }

    @Test
    void findPermissionInMenu() {
        menuMapper.selectPermissionInMenu(1);
    }

    @Test
    void findAllInAPM() {
        menuMapper.selectAllInAPM(0,0,0);
    }

    @Test
    void countInAPM() {
        int i = menuMapper.countInAPM();
        System.out.println(i);
    }

    @Test
    void count() {
        int count = menuMapper.count();
        System.out.println(count);
    }
}