package com.kclm.owep.convert;


import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.dto.PermissionDTO;
import com.kclm.owep.dto.PermissionMenuDTO;
import com.kclm.owep.entity.Menu;
import com.kclm.owep.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

/***********************************************
 * @author yejf
 */
@Mapper(componentModel = "spring")
public interface PermissionConvert {

    /** 定义一个本类型的常量实例，并通过Mappers来初始化 */
    PermissionConvert instance = Mappers.getMapper(PermissionConvert.class);

    //以下的映射也可以省略
    @Mapping(source = "id", target = "id")
    @Mapping(source = "permissionName", target = "permissionName")
    @Mapping(source = "permissionDescription", target = "permissionDescription")
    @Mapping(source = "createTime", target = "createTime")
    PermissionDTO toDto(Permission permission);

    /****
     * 由于PermissionDTO中的属性名与 Permission中的属性名相同，故可以不用做映射
     * 此方法在翻译后会调用上面的 toDto方法
     * @param permissionList
     * @return
     */
    List<PermissionDTO> mapList(List<Permission> permissionList);


    /***************************************
     * 此例中有集合属性映射，我这里采用了 expression 表达式来调用我定义的 default方法
     * @param permission
     * @return
     */
    @Mapping(source = "id" ,target = "permissionId")
    @Mapping(target = "menuIds", expression = "java(mapMenuToIdList(permission.getMenus()))")
    PermissionMenuDTO toPermissionMenuDto(Permission permission);

    /******
     * 把 List<Menu>中的id取出来，转换成 List<Integer>
     * @param menuList
     * @return
     */
    default List<Integer> mapMenuToIdList(List<Menu> menuList) {
        if(menuList != null) {
            return menuList.stream().map(Menu::getId).collect(Collectors.toList());
        }
        //
        return null;
    }

    /****
     * 此方法中集合的转换，需要用到 Permission到 NodeDTO的转换，故定义了
     * permissionToNodeDto方法，来把Permission转换成NodeDTO
     * @param permissions
     * @return
     */
    List<NodeDTO> toNodeDtoList(List<Permission> permissions);

    /*******************
     * 把Permission转换成 NodeDTO
     * @param permission
     * @return
     */
    @Mapping(source = "permissionName", target = "text")
    @Mapping(source = "id", target = "tags")
    NodeDTO permissionToNodeDto(Permission permission);
}
