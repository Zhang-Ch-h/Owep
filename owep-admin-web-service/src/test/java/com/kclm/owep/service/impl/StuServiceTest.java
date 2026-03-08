package com.kclm.owep.service.impl;

import com.kclm.owep.dto.ClazzSuggestDTO;
import com.kclm.owep.dto.StuSuggestDTO;
import com.kclm.owep.entity.Student;
import com.kclm.owep.service.BaseServiceTests;
import com.kclm.owep.service.StuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StuServiceTest extends BaseServiceTests {

    @Autowired
    private StuService stuService;

    @Test
    void selectStudent() {
    }

    @Test
    void selectClass() {
    }

    @Test
    void selectClassByStuId() {
    }

    @Test
    void classAllocation() {
    }

    @Test
    void searchBySuggestions(){
        List<StuSuggestDTO> stuSuggestDTOS = stuService.searchByStuSuggest();
        stuSuggestDTOS.forEach(System.out::println);
        System.out.println("-------------------------------");
        List<ClazzSuggestDTO> classSuggestDTOS = stuService.searchByClassSuggest();
        classSuggestDTOS.forEach(System.out::println);
    }
}