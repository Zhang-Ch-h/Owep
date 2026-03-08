package com.kclm.owep.convert;

import com.kclm.owep.dto.DbCopyDTO;
import com.kclm.owep.entity.DbCopy;
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
public class DBCopyConvertImpl implements DBCopyConvert {

    @Override
    public DbCopyDTO toDbCopyDTO(DbCopy dbCopy) {
        if ( dbCopy == null ) {
            return null;
        }

        DbCopyDTO dbCopyDTO = new DbCopyDTO();

        dbCopyDTO.setId( dbCopy.getId() );
        dbCopyDTO.setFileName( dbCopy.getFileName() );
        dbCopyDTO.setCreateTime( dbCopy.getCreateTime() );

        dbCopyDTO.setStatus( convertStatus(dbCopy.getStatus()) );

        return dbCopyDTO;
    }

    @Override
    public List<DbCopyDTO> toDbCopyDTO(List<DbCopy> dbCopies) {
        if ( dbCopies == null ) {
            return null;
        }

        List<DbCopyDTO> list = new ArrayList<DbCopyDTO>( dbCopies.size() );
        for ( DbCopy dbCopy : dbCopies ) {
            list.add( toDbCopyDTO( dbCopy ) );
        }

        return list;
    }
}
