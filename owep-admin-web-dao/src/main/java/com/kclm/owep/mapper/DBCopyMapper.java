package com.kclm.owep.mapper;

import com.kclm.owep.entity.DbCopy;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DBCopyMapper extends BaseMapper<DbCopy> {

    List<DbCopy> selectByTime(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
