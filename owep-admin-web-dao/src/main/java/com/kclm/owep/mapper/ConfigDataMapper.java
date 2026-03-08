package com.kclm.owep.mapper;

import com.kclm.owep.entity.SystemConfig;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ConfigDataMapper extends BaseMapper<SystemConfig> {

    void updateNameAndInfo(@Param("name") String name, @Param("info") String info);

    void insertLoginImage(@Param("name") String fileName);

    void insertSystemImage(@Param("name") String fileName);

    SystemConfig selectPage();
}
