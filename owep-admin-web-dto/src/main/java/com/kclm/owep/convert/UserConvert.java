package com.kclm.owep.convert;

import com.kclm.owep.dto.UserDto;
import com.kclm.owep.dto.UserGroupDTO;
import com.kclm.owep.dto.UserProfileDTO;
import com.kclm.owep.entity.Group;
import com.kclm.owep.entity.Role;
import com.kclm.owep.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

/********************
 * @author yejf
 * 此接口是基于mapstruct组件技术来完成实体类与DTO之前的映射，包含集合或集合属性都可以。
 */
@Mapper(componentModel = "spring")
public interface UserConvert {

    /** 实例:用spring IOC管理时，此句可以不用写 */
    UserConvert instance = Mappers.getMapper(UserConvert.class);

    /*************************************************************
     *
     * @param user
     * @return
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "userPwd", target = "userPwd")
    UserDto toUserDto(User user);

    /*****
     * 把User中的id映射成 UserGroupDTO中的groupId
     * 把User中的Groups集合 映射成 UserGroupDTO中的 GroupId集合
     * @param user
     * @return
     */
    @Mapping(source = "id", target = "userId")
    @Mapping(target = "groupIds", expression = "java(mapGroupToIdList(user.getGroups()))")
    UserGroupDTO toUserGroupDto(User user);

    /*************
     * 定义默认方法，此方法在映射中，可以通过 expression 属性来调用，如上的@Mapping
     * @param groups
     * @return
     */
    default List<Integer> mapGroupToIdList(List<Group> groups) {
        //
        if(groups != null) {
            //
            return groups.stream().map(Group::getId).collect(Collectors.toList());
        }
        return null;
    }

    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "realName", target = "realName")
    UserProfileDTO toUserProfileDTO(User user);
}
