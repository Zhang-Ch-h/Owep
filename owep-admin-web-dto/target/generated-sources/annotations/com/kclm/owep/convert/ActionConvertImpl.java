package com.kclm.owep.convert;

import com.kclm.owep.dto.ActionDTO;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.entity.Action;
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
public class ActionConvertImpl implements ActionConvert {

    @Override
    public ActionDTO toDto(Action action) {
        if ( action == null ) {
            return null;
        }

        ActionDTO actionDTO = new ActionDTO();

        actionDTO.setCreateTime( action.getCreateTime() );
        actionDTO.setLastAccessTime( action.getLastAccessTime() );
        actionDTO.setVersion( action.getVersion() );
        actionDTO.setActionCode( action.getActionCode() );
        actionDTO.setActionValue( action.getActionValue() );
        actionDTO.setId( action.getId() );
        actionDTO.setActionName( action.getActionName() );
        actionDTO.setActionDescription( action.getActionDescription() );
        actionDTO.setActionUrl( action.getActionUrl() );

        return actionDTO;
    }

    @Override
    public List<ActionDTO> toListDto(List<Action> actions) {
        if ( actions == null ) {
            return null;
        }

        List<ActionDTO> list = new ArrayList<ActionDTO>( actions.size() );
        for ( Action action : actions ) {
            list.add( toDto( action ) );
        }

        return list;
    }

    @Override
    public List<NodeDTO> toNodeDtoList(List<Action> actions) {
        if ( actions == null ) {
            return null;
        }

        List<NodeDTO> list = new ArrayList<NodeDTO>( actions.size() );
        for ( Action action : actions ) {
            list.add( actionToNodeDTO( action ) );
        }

        return list;
    }

    @Override
    public NodeDTO actionToNodeDTO(Action action) {
        if ( action == null ) {
            return null;
        }

        NodeDTO nodeDTO = new NodeDTO();

        nodeDTO.setText( action.getActionName() );
        nodeDTO.setTags( action.getId() );

        return nodeDTO;
    }
}
