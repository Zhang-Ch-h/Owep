package com.kclm.owep.convert;

import com.kclm.owep.dto.GroupDTO;
import com.kclm.owep.dto.GroupRoleDTO;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.entity.Group;
import com.kclm.owep.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

/*****************************************
 * @author yejf
 */
@Mapper(componentModel = "spring")
public interface GroupConvert {

    /** 实例:用spring IOC管理时，此句可以不用写 */
    GroupConvert instance = Mappers.getMapper(GroupConvert.class);

    /***********
     * 属性相同时，无需指定映射，默认即可
     * @param group
     * @return
     */
    GroupDTO toDto(Group group);

    /**********
     * 属性相同时，集合也无需指定映射，默认即可
     * @param groups
     * @return
     */
    List<GroupDTO> toListDto(List<Group> groups);


    /*****
     * 把Group中的id映射成 GroupRoleDTO中的groupId
     * 把Group中的roles集合 映射成 GroupRoleDTO中的 roleId集合
     * @param group
     * @return
     */
    @Mapping(source = "id", target = "groupId")
    @Mapping(target = "roleIds", expression = "java(mapRoleToIdList(group.getRoles()))")
    GroupRoleDTO toGroupRoleDto(Group group);

    /*************
     * 定义默认方法，此方法在映射中，可以通过 expression 属性来调用，如上的@Mapping
     * @param roles
     * @return
     */
    default List<Integer> mapRoleToIdList(List<Role> roles) {
        //
        if(roles != null) {
            //
            return roles.stream().map(Role::getId).collect(Collectors.toList());
        }
        return null;
    }

    /*******************
     *这里把List<Group> 转换成 List<NodeDTO>
     */
    List<NodeDTO> toNodeDtoList(List<Group> groups);

    /******
     * 把用户组转换成 NodeDTO
     * @param group
     * @return
     */
    @Mapping(source = "id", target = "tags")
    @Mapping(source = "groupName", target = "text")
    NodeDTO groupToNodeDto(Group group);
}
