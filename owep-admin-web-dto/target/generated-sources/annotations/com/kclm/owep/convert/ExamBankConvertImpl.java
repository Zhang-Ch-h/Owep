package com.kclm.owep.convert;

import com.kclm.owep.dto.ExamBankDTO;
import com.kclm.owep.entity.ExamBank;
import com.kclm.owep.entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class ExamBankConvertImpl implements ExamBankConvert {

    @Override
    public ExamBankDTO entityToDTO(ExamBank entity) {
        if ( entity == null ) {
            return null;
        }

        ExamBankDTO examBankDTO = new ExamBankDTO();

        Integer id = entityUserId( entity );
        if ( id != null ) {
            examBankDTO.setUserId( id );
        }
        examBankDTO.setUserName( entityUserUserName( entity ) );
        examBankDTO.setId( entity.getId() );
        examBankDTO.setVersion( entity.getVersion() );
        examBankDTO.setCreateTime( entity.getCreateTime() );
        examBankDTO.setLastAccessTime( entity.getLastAccessTime() );
        examBankDTO.setIsDelete( entity.getIsDelete() );
        examBankDTO.setBankName( entity.getBankName() );
        examBankDTO.setBankStatus( entity.getBankStatus() );
        examBankDTO.setBankDesc( entity.getBankDesc() );
        examBankDTO.setBankSecurity( entity.getBankSecurity() );
        examBankDTO.setQuesNumber( entity.getQuesNumber() );

        return examBankDTO;
    }

    private Integer entityUserId(ExamBank examBank) {
        if ( examBank == null ) {
            return null;
        }
        User user = examBank.getUser();
        if ( user == null ) {
            return null;
        }
        Integer id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityUserUserName(ExamBank examBank) {
        if ( examBank == null ) {
            return null;
        }
        User user = examBank.getUser();
        if ( user == null ) {
            return null;
        }
        String userName = user.getUserName();
        if ( userName == null ) {
            return null;
        }
        return userName;
    }
}
