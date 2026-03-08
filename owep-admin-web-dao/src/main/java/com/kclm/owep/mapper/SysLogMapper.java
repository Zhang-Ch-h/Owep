package com.kclm.owep.mapper;

import com.kclm.owep.entity.SystLog;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface SysLogMapper extends BaseMapper<SystLog> {

    List<SystLog> selectByKeyWords(@Param("name") String userName, @Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
