package com.kclm.owep.mapper;

import com.kclm.owep.entity.Section;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SectionMapper extends BaseMapper<Section> {

    List<Section> selectByChapterId(@Param("chapterId") Integer chapterId);
}
