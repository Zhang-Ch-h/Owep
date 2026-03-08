package com.kclm.owep.mapper.privilege;

import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.entity.Student;
import com.kclm.owep.mapper.BaseMapperTest;
import com.kclm.owep.mapper.ClazzMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClazzMapperTest extends BaseMapperTest {

    @Autowired
    private ClazzMapper clazzMapper;

    /*@Test
    void searchBySuggestions(){
        List<Clazz> clazzes = clazzMapper.searchBySuggestions();
        //clazzes.forEach(System.out::println);
        // 拿出clazzes集合内的所有Clazz和Student对象的相关属性值并打印
        clazzes.forEach(clazz -> {
            String className = clazz.getClassName(); // 获取className

            // 打印className, startTime和endTime
            System.out.println("className: " + className);

            List<Student> students = clazz.getStudents(); // 获取students
            students.forEach(student -> {
                String stuRealName = student.getStuRealName(); // 获取className
                String stuSchool = student.getStuSchool(); // 获取startTime
                String stuCollege = student.getStuCollege(); // 获取endTime

                // 打印className, startTime和endTime
                System.out.println("stuRealName: " + stuRealName +
                        ", stuSchool: " + stuSchool +
                        ", stuCollege: " + stuCollege);
            });
        });
    }*/

    @Test
    void selectClassList() {
        List<Clazz> clazzes = clazzMapper.selectClassList();
        clazzes.forEach(System.out::println);
        //拿出clazzes集合中的所有Clazz对象的Profession属性的ProfName属性值并打印
        clazzes.forEach(profession -> {
            String professionName = profession.getProfession().getProfName();
            System.out.println("professionName: " + professionName);
        });
    }

    @Test
    void selectById() {
        Clazz clazz = clazzMapper.selectById(1);
        //System.out.println(clazz.getProfession());
        List<PlanManager> planManagerList = clazz.getPlanManagerList();
        planManagerList.forEach(System.out::println);
    }

    @Test
    void updatePlanIdInCP() {
        clazzMapper.updatePlanIdInCP(1, 3, 1);
    }
}