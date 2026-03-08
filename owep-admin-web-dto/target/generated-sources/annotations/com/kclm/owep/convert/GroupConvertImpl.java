package com.kclm.owep.convert;

import com.kclm.owep.dto.GroupDTO;
import com.kclm.owep.dto.GroupRoleDTO;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.entity.Group;
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
public class GroupConvertImpl implements GroupConvert {

    @Override
    public GroupDTO toDto(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupDTO groupDTO = new GroupDTO();

        groupDTO.setId( group.getId() );
        groupDTO.setGroupName( group.getGroupName() );
        groupDTO.setGroupDescription( group.getGroupDescription() );
        groupDTO.setCreateTime( group.getCreateTime() );

        return groupDTO;
    }

    @Override
    public List<GroupDTO> toListDto(List<Group> groups) {
        if ( groups == null ) {
            return null;
        }

        List<GroupDTO> list = new ArrayList<GroupDTO>( groups.size() );
        for ( Group group : groups ) {
            list.add( toDto( group ) );
        }

        return list;
    }

    @Override
    public GroupRoleDTO toGroupRoleDto(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupRoleDTO groupRoleDTO = new GroupRoleDTO();

        groupRoleDTO.setGroupId( group.getId() );

        groupRoleDTO.setRoleIds( mapRoleToIdList(group.getRoles()) );

        return groupRoleDTO;
    }

    @Override
    public List<NodeDTO> toNodeDtoList(List<Group> groups) {
        if ( groups == null ) {
            return null;
        }

        List<NodeDTO> list = new ArrayList<NodeDTO>( groups.size() );
        for ( Group group : groups ) {
            list.add( groupToNodeDto( group ) );
        }

        return list;
    }

    @Override
    public NodeDTO groupToNodeDto(Group group) {
        if ( group == null ) {
            return null;
        }

        NodeDTO nodeDTO = new NodeDTO();

        nodeDTO.setTags( group.getId() );
        nodeDTO.setText( group.getGroupName() );

        return nodeDTO;
    }
}
