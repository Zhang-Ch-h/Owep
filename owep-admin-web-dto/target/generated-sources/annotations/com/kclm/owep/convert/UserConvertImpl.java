package com.kclm.owep.convert;

import com.kclm.owep.dto.UserDto;
import com.kclm.owep.dto.UserGroupDTO;
import com.kclm.owep.dto.UserProfileDTO;
import com.kclm.owep.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:11+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class UserConvertImpl implements UserConvert {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUserName( user.getUserName() );
        userDto.setUserPwd( user.getUserPwd() );

        return userDto;
    }

    @Override
    public UserGroupDTO toUserGroupDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserGroupDTO userGroupDTO = new UserGroupDTO();

        userGroupDTO.setUserId( user.getId() );

        userGroupDTO.setGroupIds( mapGroupToIdList(user.getGroups()) );

        return userGroupDTO;
    }

    @Override
    public UserProfileDTO toUserProfileDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserProfileDTO userProfileDTO = new UserProfileDTO();

        userProfileDTO.setUserName( user.getUserName() );
        userProfileDTO.setRealName( user.getRealName() );

        return userProfileDTO;
    }
}
