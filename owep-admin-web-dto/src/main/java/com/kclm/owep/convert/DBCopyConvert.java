package com.kclm.owep.convert;

import com.kclm.owep.dto.DbCopyDTO;
import com.kclm.owep.entity.DbCopy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DBCopyConvert {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "fileName", target = "fileName")
    @Mapping(source = "createTime", target = "createTime")
    @Mapping(target = "status", expression = "java(convertStatus(dbCopy.getStatus()))")
    DbCopyDTO toDbCopyDTO(DbCopy dbCopy);

    List<DbCopyDTO> toDbCopyDTO(List<DbCopy> dbCopies);

    default String convertStatus(Integer status) {
        if (status == null) {
            return null;
        }
        return status == 1 ? "成功" : "失败";
    }
}
