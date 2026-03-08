package com.kclm.owep.mapper;

import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanManagerMapper extends BaseMapper<PlanManager> {

    List<PlanManager> selectPlanName();

    PlanManager selectByPlanName(String planName);
}
