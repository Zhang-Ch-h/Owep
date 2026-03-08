package com.kclm.owep.convert;

import com.kclm.owep.dto.ClazzSuggestDTO;
import com.kclm.owep.entity.Clazz;
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
public class ClazzSuggestConvertImpl implements ClazzSuggestConvert {

    @Override
    public List<ClazzSuggestDTO> toClazzSuggestDTO(List<Clazz> clazzs) {
        if ( clazzs == null ) {
            return null;
        }

        List<ClazzSuggestDTO> list = new ArrayList<ClazzSuggestDTO>( clazzs.size() );
        for ( Clazz clazz : clazzs ) {
            list.add( clazzToClazzSuggestDTO( clazz ) );
        }

        return list;
    }

    protected ClazzSuggestDTO clazzToClazzSuggestDTO(Clazz clazz) {
        if ( clazz == null ) {
            return null;
        }

        ClazzSuggestDTO clazzSuggestDTO = new ClazzSuggestDTO();

        clazzSuggestDTO.setClassName( clazz.getClassName() );

        return clazzSuggestDTO;
    }
}
