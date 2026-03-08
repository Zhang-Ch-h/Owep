package com.kclm.owep.mapper.privilege;

import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Student;
import com.kclm.owep.mapper.BaseMapperTest;
import com.kclm.owep.mapper.StuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StuMapperTest extends BaseMapperTest {

    @Autowired
    private StuMapper stuMapper;

    @Test
    void selectClassByStuId() {
        Student student = stuMapper.selectClassByStuId(2);
        System.out.println(student);
    }

    @Test
    void isExistClassId() {
    }

    @Test
    void updateClassIdByStuId() {
    }

    @Test
    void searchBySuggestions(){
        List<Student> students = stuMapper.searchBySuggestions();
        students.forEach(System.out::println);
        // 拿出clazzes集合内的所有Clazz和Student对象的相关属性值并打印
        /*students.forEach(student -> {
            String stuRealName = student.getStuRealName(); // 获取className
            String stuSchool = student.getStuSchool(); // 获取startTime
            String stuCollege = student.getStuCollege(); // 获取endTime

            // 打印className, startTime和endTime
            System.out.println("stuRealName: " + stuRealName +
                    ", stuSchool: " + stuSchool +
                    ", stuCollege: " + stuCollege);

            Clazz clazz = student.getClazz();// 获取studentList
            String className = clazz.getClassName();
            System.out.println("className: " + className);
        });*/
    }

    @Test
    void searchStuInfo(){
        List<Student> student = stuMapper.selectStuInfo("updateClassName2", "zk", "111", "艺术学院", "2020-07-07 12:12:50", "2020-07-10 12:12:58");
        System.out.println(student);
    }

    @Test
    void getOtherClassNames() {
        List<Clazz> otherClassNames = stuMapper.getOtherClassNames(1);
        otherClassNames.forEach(System.out::println);
    }
}