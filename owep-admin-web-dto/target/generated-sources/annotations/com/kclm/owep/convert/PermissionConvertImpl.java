package com.kclm.owep.convert;

import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.dto.PermissionDTO;
import com.kclm.owep.dto.PermissionMenuDTO;
import com.kclm.owep.entity.Action;
import com.kclm.owep.entity.Menu;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.entity.Role;
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
public class PermissionConvertImpl implements PermissionConvert {

    @Override
    public PermissionDTO toDto(Permission permission) {
        if ( permission == null ) {
            return null;
        }

        PermissionDTO permissionDTO = new PermissionDTO();

        permissionDTO.setId( permission.getId() );
        permissionDTO.setPermissionName( permission.getPermissionName() );
        permissionDTO.setPermissionDescription( permission.getPermissionDescription() );
        permissionDTO.setCreateTime( permission.getCreateTime() );
        permissionDTO.setLastAccessTime( permission.getLastAccessTime() );
        permissionDTO.setVersion( permission.getVersion() );
        List<Role> list = permission.getRoles();
        if ( list != null ) {
            permissionDTO.setRoles( new ArrayList<Role>( list ) );
        }
        List<Action> list1 = permission.getActions();
        if ( list1 != null ) {
            permissionDTO.setActions( new ArrayList<Action>( list1 ) );
        }
        List<Menu> list2 = permission.getMenus();
        if ( list2 != null ) {
            permissionDTO.setMenus( new ArrayList<Menu>( list2 ) );
        }

        return permissionDTO;
    }

    @Override
    public List<PermissionDTO> mapList(List<Permission> permissionList) {
        if ( permissionList == null ) {
            return null;
        }

        List<PermissionDTO> list = new ArrayList<PermissionDTO>( permissionList.size() );
        for ( Permission permission : permissionList ) {
            list.add( toDto( permission ) );
        }

        return list;
    }

    @Override
    public PermissionMenuDTO toPermissionMenuDto(Permission permission) {
        if ( permission == null ) {
            return null;
        }

        PermissionMenuDTO permissionMenuDTO = new PermissionMenuDTO();

        permissionMenuDTO.setPermissionId( permission.getId() );

        permissionMenuDTO.setMenuIds( mapMenuToIdList(permission.getMenus()) );

        return permissionMenuDTO;
    }

    @Override
    public List<NodeDTO> toNodeDtoList(List<Permission> permissions) {
        if ( permissions == null ) {
            return null;
        }

        List<NodeDTO> list = new ArrayList<NodeDTO>( permissions.size() );
        for ( Permission permission : permissions ) {
            list.add( permissionToNodeDto( permission ) );
        }

        return list;
    }

    @Override
    public NodeDTO permissionToNodeDto(Permission permission) {
        if ( permission == null ) {
            return null;
        }

        NodeDTO nodeDTO = new NodeDTO();

        nodeDTO.setText( permission.getPermissionName() );
        nodeDTO.setTags( permission.getId() );

        return nodeDTO;
    }
}
