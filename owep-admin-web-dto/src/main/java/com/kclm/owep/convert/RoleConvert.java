package com.kclm.owep.convert;

import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.dto.RoleDTO;
import com.kclm.owep.dto.RolePermissionDTO;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/************************************************
 * @author yejf
 */
@Mapper(componentModel = "spring")
public interface RoleConvert {

    /** 定义一个本类型的常量实例，并通过Mappers来初始化,通过 spring ioc来管理时，可以不写的 */
    RoleConvert instance = Mappers.getMapper(RoleConvert.class);

    /****
     * 由于被映射的属性名在两个类中是一样的，无需映射
     * @param role
     * @return
     */
    RoleDTO toDto(Role role);

    /*****
     * 也无需映射， 会自动供助上面的 toDto方法来完成转换
     * @param roleList
     * @return
     */
    List<RoleDTO> toDtoList(List<Role> roleList);


    /***********************************************
     * 此处有集合属性的映射，我采用了 expression 表达式来调用我定义好的 default方法
     * @param role
     * @return
     */
    @Mapping(source = "id",target = "roleId")
    @Mapping(target = "permissionIds",expression = "java(mapPermissionToId(role.getPermissions()))")
    RolePermissionDTO toRolePermissionDto(Role role);

    /******
     * 此方法把 List<Permission> 转换成 List<Integer>，我们只需要Permission的id
     * @param permissionList
     * @return
     */
    default List<Integer> mapPermissionToId(List<Permission> permissionList) {
        List<Integer> permissionIds = new ArrayList<>();
        //
        if(permissionList != null) {
            permissionIds = permissionList.stream().map(Permission::getId).collect(Collectors.toList());
        }
        return permissionIds;
    }

    /****
     * 这里是要把 List<Role>转换成 List<NodeDTO>, 所以，我们需要提供把 Role转换成 NodeDTO的方法
     * @param roles
     * @return
     */
    List<NodeDTO> toNodeDtoList(List<Role> roles);

    /******
     * 把角色转换成 NodeDTO
     * @param role
     * @return
     */
    @Mapping(source = "roleName", target = "text")
    @Mapping(source = "id", target = "tags")
    NodeDTO roleToNodeDto(Role role);

}
