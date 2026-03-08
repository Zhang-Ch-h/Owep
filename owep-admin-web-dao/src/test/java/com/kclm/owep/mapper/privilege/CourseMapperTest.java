package com.kclm.owep.mapper.privilege;

import com.kclm.owep.entity.Course;
import com.kclm.owep.mapper.BaseMapperTest;
import com.kclm.owep.mapper.CourseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseMapperTest extends BaseMapperTest {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    void selectByPlanId() {
        List<Course> courses = courseMapper.selectByPlanId(1);
        System.out.println(courses);
    }
}