package com.kclm.owep.mapper;

import com.kclm.owep.entity.BranchInstitute;
import com.kclm.owep.entity.OrgInstitute;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrgInstituteMapper  extends BaseMapper<OrgInstitute> {


    List<OrgInstitute> selectAllByKeyWords(@Param("orgName") String orgName, @Param("orgTypeInt") Integer orgTypeInt);

    void updateOrg(@Param("id") Integer id, @Param("name") String name, @Param("type") Integer type);
}
