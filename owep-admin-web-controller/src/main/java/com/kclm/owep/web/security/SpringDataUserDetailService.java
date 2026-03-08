package com.kclm.owep.web.security;

import com.kclm.owep.dto.ActionMenuPermissionDTO;
import com.kclm.owep.dto.UserDto;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.service.ActionService;
import com.kclm.owep.service.MenuService;
import com.kclm.owep.service.PermissionService;
import com.kclm.owep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/***
 * By:Artherine
 * Date:20.10.24
 * For:用户认证与授权绑定
 */

@Service
public class SpringDataUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    ActionService actionService;
    @Autowired
    MenuService menuService;

    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        System.out.println("name="+name);
        UserDto userDto = userService.selectByName(name);
        System.out.println(userDto);
        System.out.println(userService);
        Set<Permission> permissionSet = new HashSet<>(userService.getPermissionListByUserId(userDto.getId()));//使用set筛除重复元素
        if(permissionSet.size()>0){
//            Set<String> permissionIds = new HashSet<>();//以数组形式提取权限id
//            permissionSet.forEach(permission -> permissionIds.add(permission.getId().toString()));
//            System.out.print("已找到用户"+name+"拥有的权限"+permissionIds);//todo

//            Set<Action> actions = new HashSet<>();
//            permissionIds.forEach(permissionId-> actions.addAll(permissionService.selectActionByPermission(permissionId)));//permission 到 action
//            String[] actioncodes = new String[actions.size()];
//            int index=0;
//            for (Action action  : actions){
//                System.out.println("根据权限授权的行为："+action.getActionName());//todo
//                actioncodes[index++] =action.getActionCode();
//            }

            Set<ActionMenuPermissionDTO> actMenuSumSet= new HashSet<>();
            for(Permission perm:permissionSet) {
                Set<ActionMenuPermissionDTO> actionMenuSet = menuService.selectActionByPermissionIdFromAMP(perm.getId());
                actMenuSumSet.addAll(actionMenuSet);
            }
            String[] authoritiesCodes = new String[actMenuSumSet.size()];
            Integer index = 0;
            for(ActionMenuPermissionDTO am :actMenuSumSet){
                Integer menuId = am.getMenuId();
                Integer actionId = am.getActionId();
                authoritiesCodes[index++] = menuId.toString()+"-"+actionId.toString();
            }
            //刷新用户登录时间
            userService.refreshLoginTime(userDto.getId());
            return User.withUsername(userDto.getUserName()).password(userDto.getUserPwd()).roles().authorities(authoritiesCodes).build();
        }else{
            System.out.println("用户"+name+"无特殊权限");//todo
            return User.withUsername(userDto.getUserName()).password(userDto.getUserPwd()).authorities("common").build();
        }



    }
}
