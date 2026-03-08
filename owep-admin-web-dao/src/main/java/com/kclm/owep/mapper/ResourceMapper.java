package com.kclm.owep.mapper;

import com.kclm.owep.entity.Resource;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {

    List<Resource> selectResourceByClassId(@Param("classId") Integer classId);

    void deleteResourceFromClass(@Param("cid") Integer cid, @Param("rid") Integer rid);

    void deleteResourcesFromClass(@Param("cid") Integer classId, @Param("idList") List<Integer> idList);

    List<Resource> selectResourceByKeyword(@Param("classId") Integer classId, @Param("resourceName") String resourceName,
                                           @Param("resourceTypeName") String resourceTypeName);

    void insertResourceToClass(@Param("cid") Integer cid, @Param("rid") Integer rid);

    List<Resource> selectAllResourceByKeyWord(@Param("name") String resourceName, @Param("type") String resourceType,
                                              @Param("start") LocalDateTime startTime, @Param("end") LocalDateTime endTime);

    void insertSelectedResourceToClass(@Param("cid") Integer cid, @Param("ridList") List<Integer> ridList);
}
