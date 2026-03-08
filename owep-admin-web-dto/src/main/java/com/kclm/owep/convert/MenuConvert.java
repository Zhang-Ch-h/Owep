package com.kclm.owep.convert;

import com.kclm.owep.dto.ActionMenuPermissionDTO;
import com.kclm.owep.dto.MenuDTO;
import com.kclm.owep.entity.Action;
import com.kclm.owep.entity.Menu;
import com.kclm.owep.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

/***************************************
 * @author yejf
 */
@Mapper(componentModel = "spring")
public interface MenuConvert {

    /** 实例:用spring IOC管理时，此句可以不用写 */
    MenuConvert instance = Mappers.getMapper(MenuConvert.class);

    /*************
     * 属性名相同时，无需指定映射关系
     * @param menu
     * @return
     */
    MenuDTO toDto(Menu menu);

    /************
     * 把Menu中的id映射成 ActionMenuPermissionDTO中的menuId
     * 把Menu中的permissions映射成 ActionMenuPermissionDTO中的permissionIds
     * 把Menu中的actions映射成 ActionMenuPermissionDTO中的actionIds
     * @param menu
     * @return
     */
    @Mapping(source = "id", target = "menuId")
    @Mapping(target = "permissionIds", expression = "java(mapPermissionToIntegerList(menu.getPermissions()))")
    @Mapping(target = "actionIds", expression = "java(mapActionToIntegerList(menu.getActions()))")
    ActionMenuPermissionDTO toActionMenuPermissionDto(Menu menu);

    /****
     * 此方法是为了把 List<Permission> 转换成 List<Integer>
     * @param permissions
     * @return
     */
    default List<Integer> mapPermissionToIntegerList(List<Permission> permissions) {
        if(permissions != null) {
            return permissions.stream().map(Permission::getId).collect(Collectors.toList());
        }
        return null;
    }

    /****
     * 此方法是为了把 List<Action> 转换成 List<Integer>
     * @param actions
     * @return
     */
    default List<Integer> mapActionToIntegerList(List<Action> actions) {
        if(actions != null) {
            return actions.stream().map(Action::getId).collect(Collectors.toList());
        }
        return null;
    }
}
