package com.kclm.owep.service;

import com.kclm.owep.dto.*;
import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Student;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/*******************
 * @Author zch
 * @Description
 */
public interface StuService {

    List<Student> findAll();

    List<StuManagementDTO> selectStudent();

    NodeDTO selectClass();

    StuClassDTO selectClassByStuId(Serializable stuId);

    /********
     * 返回0代表分配成功, 返回1代表已经存在班级
     */
    int classAllocation(Integer stuId, Integer classId);

    List<StuSuggestDTO> searchByStuSuggest();

    List<ClazzSuggestDTO> searchByClassSuggest();

    void deleteStudent(Integer id);

    void deleteSelect(List<Serializable> ids);

    boolean isStuNameUnique(String stuName);

    boolean isStuNumUnique(String stuNum);

    void save(Student student);

    List<StuManagementDTO> searchByStuAndClass(String className, String stuRealName, String school, String college, String start, String end);

    void update(Student student);

    List<ClazzSuggestDTO> getOtherClassNames(Integer stuId);


    boolean isClassNameExist(String className);

    void transferStu(Integer stuId, String className);

    void switchStatus(Integer stuId, Integer status);

    void saveAll(List<Student> studentList);

    void saveAllByClassId(List<Student> studentList, Integer classId);

    List<ClassStuDTO> getStuByClassId(Integer classId);

    List<ClassStuDTO> getStuByClassIdAndKeyword(Integer classId, String num, String name);
}
