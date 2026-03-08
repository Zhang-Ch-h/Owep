package com.kclm.owep.convert;

import com.kclm.owep.dto.StuSuggestDTO;
import com.kclm.owep.entity.Student;
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
public class StuSuggestConvertImpl implements StuSuggestConvert {

    @Override
    public List<StuSuggestDTO> toStuSuggestDTO(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StuSuggestDTO> list = new ArrayList<StuSuggestDTO>( students.size() );
        for ( Student student : students ) {
            list.add( studentToStuSuggestDTO( student ) );
        }

        return list;
    }

    protected StuSuggestDTO studentToStuSuggestDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StuSuggestDTO stuSuggestDTO = new StuSuggestDTO();

        stuSuggestDTO.setStuRealName( student.getStuRealName() );
        stuSuggestDTO.setStuSchool( student.getStuSchool() );
        stuSuggestDTO.setStuCollege( student.getStuCollege() );

        return stuSuggestDTO;
    }
}
