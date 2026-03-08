package com.kclm.owep.convert;

import com.kclm.owep.dto.ActionMenuPermissionDTO;
import com.kclm.owep.dto.MenuDTO;
import com.kclm.owep.entity.Action;
import com.kclm.owep.entity.Menu;
import com.kclm.owep.entity.Permission;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class MenuConvertImpl implements MenuConvert {

    @Override
    public MenuDTO toDto(Menu menu) {
        if ( menu == null ) {
            return null;
        }

        MenuDTO menuDTO = new MenuDTO();

        menuDTO.setMenuCode( menu.getMenuCode() );
        menuDTO.setCreateTime( menu.getCreateTime() );
        menuDTO.setLastAccessTime( menu.getLastAccessTime() );
        menuDTO.setVersion( menu.getVersion() );
        menuDTO.setParent( toDto( menu.getParent() ) );
        List<Menu> list = menu.getChildMenus();
        if ( list != null ) {
            menuDTO.setChildMenus( new ArrayList<Menu>( list ) );
        }
        List<Permission> list1 = menu.getPermissions();
        if ( list1 != null ) {
            menuDTO.setPermissions( new ArrayList<Permission>( list1 ) );
        }
        List<Action> list2 = menu.getActions();
        if ( list2 != null ) {
            menuDTO.setActions( new ArrayList<Action>( list2 ) );
        }
        menuDTO.setId( menu.getId() );
        menuDTO.setMenuName( menu.getMenuName() );
        menuDTO.setMenuDescription( menu.getMenuDescription() );
        menuDTO.setMenuUrl( menu.getMenuUrl() );

        return menuDTO;
    }

    @Override
    public ActionMenuPermissionDTO toActionMenuPermissionDto(Menu menu) {
        if ( menu == null ) {
            return null;
        }

        ActionMenuPermissionDTO actionMenuPermissionDTO = new ActionMenuPermissionDTO();

        actionMenuPermissionDTO.setMenuId( menu.getId() );

        actionMenuPermissionDTO.setPermissionIds( mapPermissionToIntegerList(menu.getPermissions()) );
        actionMenuPermissionDTO.setActionIds( mapActionToIntegerList(menu.getActions()) );

        return actionMenuPermissionDTO;
    }
}
