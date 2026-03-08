package com.kclm.owep.convert;

import com.kclm.owep.dto.ClassStuDTO;
import com.kclm.owep.entity.Student;
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
public class ClassStuConvertImpl implements ClassStuConvert {

    @Override
    public ClassStuDTO toClassStuDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        ClassStuDTO classStuDTO = new ClassStuDTO();

        classStuDTO.setId( student.getId() );
        classStuDTO.setStuNumber( student.getStuNumber() );
        classStuDTO.setStuRealName( student.getStuRealName() );
        classStuDTO.setEffectiveDate( student.getEffectiveDate() );

        classStuDTO.setStatus( convertStatus(student.getStatus()) );

        return classStuDTO;
    }

    @Override
    public List<ClassStuDTO> toClassStuDTOS(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<ClassStuDTO> list = new ArrayList<ClassStuDTO>( students.size() );
        for ( Student student : students ) {
            list.add( toClassStuDTO( student ) );
        }

        return list;
    }
}
