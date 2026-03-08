package com.kclm.owep.convert;

import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.entity.Clazz;
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
public class ClassConvertImpl implements ClassConvert {

    @Override
    public List<NodeDTO> toNodeDtoList(List<Clazz> Clazzs) {
        if ( Clazzs == null ) {
            return null;
        }

        List<NodeDTO> list = new ArrayList<NodeDTO>( Clazzs.size() );
        for ( Clazz clazz : Clazzs ) {
            list.add( classToNodeDto( clazz ) );
        }

        return list;
    }

    @Override
    public NodeDTO classToNodeDto(Clazz clazz) {
        if ( clazz == null ) {
            return null;
        }

        NodeDTO nodeDTO = new NodeDTO();

        nodeDTO.setTags( clazz.getId() );
        nodeDTO.setText( clazz.getClassName() );

        return nodeDTO;
    }
}
