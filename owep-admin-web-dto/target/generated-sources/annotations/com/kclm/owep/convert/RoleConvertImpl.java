package com.kclm.owep.convert;

import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.dto.RoleDTO;
import com.kclm.owep.dto.RolePermissionDTO;
import com.kclm.owep.entity.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:11+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class RoleConvertImpl implements RoleConvert {

    @Override
    public RoleDTO toDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( role.getId() );
        roleDTO.setRoleName( role.getRoleName() );
        roleDTO.setRoleDescription( role.getRoleDescription() );
        roleDTO.setCreateTime( role.getCreateTime() );

        return roleDTO;
    }

    @Override
    public List<RoleDTO> toDtoList(List<Role> roleList) {
        if ( roleList == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( roleList.size() );
        for ( Role role : roleList ) {
            list.add( toDto( role ) );
        }

        return list;
    }

    @Override
    public RolePermissionDTO toRolePermissionDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RolePermissionDTO rolePermissionDTO = new RolePermissionDTO();

        rolePermissionDTO.setRoleId( role.getId() );

        rolePermissionDTO.setPermissionIds( mapPermissionToId(role.getPermissions()) );

        return rolePermissionDTO;
    }

    @Override
    public List<NodeDTO> toNodeDtoList(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<NodeDTO> list = new ArrayList<NodeDTO>( roles.size() );
        for ( Role role : roles ) {
            list.add( roleToNodeDto( role ) );
        }

        return list;
    }

    @Override
    public NodeDTO roleToNodeDto(Role role) {
        if ( role == null ) {
            return null;
        }

        NodeDTO nodeDTO = new NodeDTO();

        nodeDTO.setText( role.getRoleName() );
        nodeDTO.setTags( role.getId() );

        return nodeDTO;
    }
}
