package com.kclm.owep.convert;

import com.kclm.owep.dto.ExamQuesDTO;
import com.kclm.owep.entity.ExamBank;
import com.kclm.owep.entity.ExamQues;
import com.kclm.owep.entity.ExamQuesAnswerSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class ExamQuesConvertImpl implements ExamQuesConvert {

    @Override
    public ExamQuesDTO entityToDTO(ExamQues entity) {
        if ( entity == null ) {
            return null;
        }

        ExamQuesDTO examQuesDTO = new ExamQuesDTO();

        examQuesDTO.setExamBankName( entityExamBankBankName( entity ) );
        examQuesDTO.setId( entity.getId() );
        examQuesDTO.setVersion( entity.getVersion() );
        examQuesDTO.setCreateTime( entity.getCreateTime() );
        examQuesDTO.setLastAccessTime( entity.getLastAccessTime() );
        examQuesDTO.setIsDelete( entity.getIsDelete() );
        examQuesDTO.setTypeName( entity.getTypeName() );
        examQuesDTO.setHardLevel( entity.getHardLevel() );
        examQuesDTO.setSource( entity.getSource() );
        examQuesDTO.setLable( entity.getLable() );
        examQuesDTO.setStatus( entity.getStatus() );
        examQuesDTO.setQuesContent( entity.getQuesContent() );
        List<ExamQuesAnswerSet> list = entity.getAnswerSetList();
        if ( list != null ) {
            examQuesDTO.setAnswerSetList( new ArrayList<ExamQuesAnswerSet>( list ) );
        }
        examQuesDTO.setCorrectAnswer( entity.getCorrectAnswer() );
        examQuesDTO.setAnalyze( entity.getAnalyze() );
        examQuesDTO.setUseCount( entity.getUseCount() );
        examQuesDTO.setUserName( entity.getUserName() );

        return examQuesDTO;
    }

    private String entityExamBankBankName(ExamQues examQues) {
        if ( examQues == null ) {
            return null;
        }
        ExamBank examBank = examQues.getExamBank();
        if ( examBank == null ) {
            return null;
        }
        String bankName = examBank.getBankName();
        if ( bankName == null ) {
            return null;
        }
        return bankName;
    }
}
