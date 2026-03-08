package com.kclm.owep.web.controller;

import com.kclm.owep.convert.UserConvert;
import com.kclm.owep.dto.MenuDTO;
import com.kclm.owep.dto.UserDto;
import com.kclm.owep.dto.UserProfileDTO;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.entity.User;
import com.kclm.owep.service.MenuService;
import com.kclm.owep.service.PermissionService;
import com.kclm.owep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class LoginController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UserService userService;

    @Autowired
    private UserConvert userConvert;

    @GetMapping("/login.html")
    public String _toLoginPage(){
        return "/login.html";
    }



    @GetMapping("/login")
    public String toLoginPage(){

        System.out.println("to login page");
        return "/login.html";
    }

    @PostMapping("/login")
    public String loginAuthentication(String username, String password, HttpSession session){
        System.out.println("having msg: username:"+username+",password:"+password);
        //可以通过 SecurityContextHolder来获取认证过的对象
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            //
            UserDetails userDetails = (UserDetails)principal;
            //
            System.out.println("认证过的用户是："+userDetails.getUsername());
            //
            //UserProfileDTO userByUserName = userService.getUserByUserName(userDetails.getUsername());
            //
            session.setAttribute("LOGIN_USER", userDetails);
            //session.setAttribute("LOGIN_USER_NAME", userByUserName);
            //
        }
        return "/index.html";
    }


    @GetMapping(value = "/getMenu", produces = "application/json")
    @ResponseBody
    public Object getMenu(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();//通过security 过滤器链得到目前用户凭证
        String name = authentication.getName();

        //由用户name获取permissionId
            UserDto userDto = userService.selectByName(name);
            Set<Permission> permissionList = new HashSet<>(userService.getPermissionListByUserId(userDto.getId()));//使用set筛除重复元素
//            String[] permissionCodes = new String[permissionList.size()];//字符串数组存放提取的权限名
                Set<String> permissionIds = new HashSet<>();//以数组形式提取权限id
                permissionList.forEach(permission -> permissionIds.add(permission.getId().toString()));
//                String[] permIdArr = (String[]) permissionIds.toArray();}
        System.out.println("已获得用户"+authentication.getName()+"所有权限id:"+permissionIds);//TODO 反馈

        Set<Integer> menuIds = new HashSet<>();
        permissionIds.forEach(permId_str-> menuIds.addAll(permissionService.selectMenuByPermissionId(Integer.valueOf(permId_str)).getMenuIds()));//由权限到菜单

        Set<MenuDTO> menuSet = new HashSet<>();
        menuIds.forEach(menuId->{
            MenuDTO menuDTO = menuService.selectById(menuId);
            List<MenuDTO> subMenus = menuDTO.getSubMenus();
            if (subMenus!=null&&subMenus.size()>0){//查询的【菜单】包括二级菜单，检查子菜单集排除二级菜单
                menuSet.add(menuDTO);//存入
            }

        } );//取菜单


        {
            Set<String> authorityWords = new HashSet<>();
            authentication.getAuthorities().forEach(authority -> authorityWords.add(authority.getAuthority()));//取出授权关键字并以Set存放以筛除重复
            System.out.println("用户拥有的授权字段：" + authorityWords);
            if(authorityWords.size()==0) System.out.println("用户没有得到授权字段");
        }//todo 测试用

        return menuSet.toArray();
    }

    /*@GetMapping("/getProfile")
    public void getProfile(HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        UserProfileDTO userProfileDTO = userService.getUserByUserName(userName);
        session.setAttribute("USERPROFILE", userProfileDTO);
    }*/
}
