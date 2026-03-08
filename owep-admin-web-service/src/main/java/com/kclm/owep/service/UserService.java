package com.kclm.owep.service;

import com.kclm.owep.dto.AdministratorDTO;
import com.kclm.owep.dto.UserDto;
import com.kclm.owep.dto.UserProfileDTO;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.entity.User;

import java.util.List;

/**********************************8
 * @author yejf
 * 这里只是提供了一个用来
 */
public interface UserService {

    UserDto selectByName(String name);

    List<Permission> getPermissionListByUserId(Integer userId);

    int refreshLoginTime(Integer userId);

    UserProfileDTO getUserByUserName(String userName);
}
