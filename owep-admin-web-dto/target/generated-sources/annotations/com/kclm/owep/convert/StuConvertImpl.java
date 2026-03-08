package com.kclm.owep.convert;

import com.kclm.owep.dto.StuClassDTO;
import com.kclm.owep.dto.StuManagementDTO;
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
public class StuConvertImpl implements StuConvert {

    @Override
    public StuManagementDTO toStuManagementDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StuManagementDTO stuManagementDTO = new StuManagementDTO();

        stuManagementDTO.setStuNumber( student.getStuNumber() );
        stuManagementDTO.setStuPwd( student.getStuPwd() );
        stuManagementDTO.setStuName( student.getStuName() );
        stuManagementDTO.setStuRealName( student.getStuRealName() );
        stuManagementDTO.setStuPhone( student.getStuPhone() );
        stuManagementDTO.setStuEmail( student.getStuEmail() );
        stuManagementDTO.setStatus( student.getStatus() );
        stuManagementDTO.setLastAccessTime( student.getLastAccessTime() );
        stuManagementDTO.setStuSchool( student.getStuSchool() );
        stuManagementDTO.setId( student.getId() );
        stuManagementDTO.setEffectiveDate( student.getEffectiveDate() );

        stuManagementDTO.setGender( convertGender(student.getGender()) );

        return stuManagementDTO;
    }

    @Override
    public List<StuManagementDTO> toStuManagementDTO(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StuManagementDTO> list = new ArrayList<StuManagementDTO>( students.size() );
        for ( Student student : students ) {
            list.add( toStuManagementDTO( student ) );
        }

        return list;
    }

    @Override
    public StuClassDTO toStuClassDto(Student stu) {
        if ( stu == null ) {
            return null;
        }

        StuClassDTO stuClassDTO = new StuClassDTO();

        stuClassDTO.setStuId( stu.getId() );

        stuClassDTO.setClassId( mapClassToId(stu.getClazz()) );
        stuClassDTO.setClassName( mapClassToName(stu.getClazz()) );

        return stuClassDTO;
    }
}
