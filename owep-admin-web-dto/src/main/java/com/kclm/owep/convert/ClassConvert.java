package com.kclm.owep.convert;

import com.kclm.owep.dto.ClazzDTO;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/*******************
 * @Author zch
 * @Description
 */
@Mapper(componentModel = "spring")
public interface ClassConvert {

    /*******************
     *这里把List<Clazz> 转换成 List<NodeDTO>
     */
    List<NodeDTO> toNodeDtoList(List<Clazz> Clazzs);

    /******
     * 把班级转换成 NodeDTO
     * @param clazz
     * @return
     */
    @Mapping(source = "id", target = "tags")
    @Mapping(source = "className", target = "text")
    NodeDTO classToNodeDto(Clazz clazz);

    /*@Mapping(source = "id", target = "id")
    @Mapping(source = "classNumber", target = "classNumber")
    @Mapping(source = "className", target = "className")
    @Mapping(source = "profession.profName", target = "profName")
    @Mapping(source = "startTime", target = "startTime")
    @Mapping(source = "endTime", target = "endTime")
    @Mapping(source = "classStatus", target = "classStatus")
    @Mapping(source = "profession.instituteName", target = "instituteName")
    @Mapping(source = "profession.instituteBranchName", target = "branchName")

    List<ClazzDTO> toClazzDtoList(List<Clazz> clazzs);*/
}
