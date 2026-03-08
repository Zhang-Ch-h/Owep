package com.kclm.owep.convert;

import com.kclm.owep.dto.ClientDTO;
import com.kclm.owep.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientConvert {
    ClientConvert INSTANCE = Mappers.getMapper(ClientConvert.class);

    @Mapping(target = "channelTypeName", source = "channel.channelType.channelTypeName")
    @Mapping(target = "userName", source = "user.userName")
    @Mapping(target = "profession", source = "profession.profName")
    @Mapping(target = "channelName",source = "channel.channelName")
    ClientDTO entityToDTO(Client entity);

}
