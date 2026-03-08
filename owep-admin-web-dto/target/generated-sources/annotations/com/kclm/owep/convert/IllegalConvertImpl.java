package com.kclm.owep.convert;

import com.kclm.owep.dto.IllegalDTO;
import com.kclm.owep.entity.Illegal;
import com.kclm.owep.entity.Student;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class IllegalConvertImpl implements IllegalConvert {

    @Override
    public IllegalDTO entityIllegal(Illegal illegal) {
        if ( illegal == null ) {
            return null;
        }

        IllegalDTO illegalDTO = new IllegalDTO();

        illegalDTO.setStuNumber( illegalStudentStuNumber( illegal ) );
        illegalDTO.setStudentName( illegalStudentStuName( illegal ) );
        illegalDTO.setDisciplineTime( illegal.getDisciplineTime() );
        illegalDTO.setPresentationCondition( illegal.getPresentationCondition() );
        illegalDTO.setId( illegal.getId() );

        return illegalDTO;
    }

    private String illegalStudentStuNumber(Illegal illegal) {
        if ( illegal == null ) {
            return null;
        }
        Student student = illegal.getStudent();
        if ( student == null ) {
            return null;
        }
        String stuNumber = student.getStuNumber();
        if ( stuNumber == null ) {
            return null;
        }
        return stuNumber;
    }

    private String illegalStudentStuName(Illegal illegal) {
        if ( illegal == null ) {
            return null;
        }
        Student student = illegal.getStudent();
        if ( student == null ) {
            return null;
        }
        String stuName = student.getStuName();
        if ( stuName == null ) {
            return null;
        }
        return stuName;
    }
}
