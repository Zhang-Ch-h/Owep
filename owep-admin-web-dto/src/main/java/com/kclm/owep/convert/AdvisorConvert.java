package com.kclm.owep.convert;

import com.kclm.owep.dto.AdvisorDTO;
import com.kclm.owep.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/*******************
 * @Author zch
 * @Description
 */
@Mapper(componentModel = "spring")
public interface AdvisorConvert {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "realName", target = "realName")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "userPhone", target = "userPhone")
    @Mapping(source = "userEmail", target = "userEmail")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "effectiveDate", target = "effectiveDate")
    @Mapping(source = "lastAccessTime", target = "lastAccessTime")
    List<AdvisorDTO> toAdvisorDTO(List<User> users);

    AdvisorDTO toAdvisorDTO(User user);
}
