package com.kclm.owep.convert;

import com.kclm.owep.dto.TeacherDTO;
import com.kclm.owep.entity.Group;
import com.kclm.owep.entity.User;
import java.time.LocalDateTime;
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
public class TeacherConvertImpl implements TeacherConvert {

    @Override
    public List<TeacherDTO> toTeacherDTO(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<TeacherDTO> list = new ArrayList<TeacherDTO>( users.size() );
        for ( User user : users ) {
            list.add( toTeacherDTO( user ) );
        }

        return list;
    }

    @Override
    public TeacherDTO toTeacherDTO(User user) {
        if ( user == null ) {
            return null;
        }

        Integer id = null;
        String userName = null;
        String realName = null;
        Integer gender = null;
        String userPhone = null;
        String userEmail = null;
        Integer status = null;
        LocalDateTime effectiveDate = null;
        LocalDateTime lastAccessTime = null;

        id = user.getId();
        userName = user.getUserName();
        realName = user.getRealName();
        gender = user.getGender();
        userPhone = user.getUserPhone();
        userEmail = user.getUserEmail();
        status = user.getStatus();
        effectiveDate = user.getEffectiveDate();
        lastAccessTime = user.getLastAccessTime();

        TeacherDTO teacherDTO = new TeacherDTO( id, userName, realName, gender, userPhone, userEmail, status, effectiveDate, lastAccessTime );

        List<Group> list = user.getGroups();
        if ( list != null ) {
            teacherDTO.setGroups( new ArrayList<Group>( list ) );
        }

        return teacherDTO;
    }
}
