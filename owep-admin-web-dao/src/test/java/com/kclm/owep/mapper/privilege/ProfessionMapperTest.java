package com.kclm.owep.mapper.privilege;

import com.kclm.owep.entity.Profession;
import com.kclm.owep.mapper.BaseMapperTest;
import com.kclm.owep.mapper.ProfessionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ProfessionMapperTest extends BaseMapperTest {

    @Autowired
    private ProfessionMapper professionMapper;

    @Test
    void selectByProNameAndInstituteNameAndInstituteBranchName() {
    }

    @Test
    void save() {
        Profession profession = new Profession();
        profession.setProfName("测试");
        profession.setInstituteName("测试");
        profession.setInstituteBranchName("测试");
        profession.setProfStatus(1);
        profession.setProfDesc("测试");
        //
        System.out.println(profession);
        professionMapper.save(profession);
    }
}