package com.kclm.owep.service.impl;

import cn.hutool.core.lang.Assert;
import com.kclm.owep.convert.*;

import com.kclm.owep.dto.*;
import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Group;
import com.kclm.owep.entity.Student;
import com.kclm.owep.entity.User;
import com.kclm.owep.mapper.ClazzMapper;
import com.kclm.owep.mapper.StuMapper;
import com.kclm.owep.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

/*******************
 * @Author zch
 * @Description
 */
@Service
@Slf4j
public class StuServiceImpl implements StuService {

    @Autowired
    private StuConvert stuConvert;

    @Autowired
    private StuMapper stuMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private ClassConvert classConvert;

    @Autowired
    private StuSuggestConvert stuSuggestConvert;

    @Autowired
    private ClazzSuggestConvert clazzSuggestConvert;

    @Autowired
    private ClassStuConvert classStuConvert;

    @Override
    public List<StuManagementDTO> selectStudent() {
        try{
            List<Student> stus = stuMapper.selectAll();
            List<StuManagementDTO> StuManagementDTOS = stuConvert.toStuManagementDTO(stus);
            //StuManagementDTOS.forEach(System.out::println);
            return StuManagementDTOS;
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public NodeDTO selectClass() {
        //
        List<Clazz> clazzs = clazzMapper.selectAll();
        //
        List<NodeDTO> nodeDTOS = classConvert.toNodeDtoList(clazzs);
        //
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setText("班级");
        nodeDTO.setNodes(nodeDTOS);
        nodeDTO.setTags(0);
        //
        log.debug("nodeDTO:" + nodeDTO);
        //
        return nodeDTO;
    }

    @Override
    public StuClassDTO selectClassByStuId(Serializable stuId) {
        if (stuId != null) {
            System.out.println("==========>"+stuMapper);
            Student stu = stuMapper.selectClassByStuId(stuId);
            //
            StuClassDTO stuClassDTO = stuConvert.toStuClassDto(stu);
            //
            log.debug("StuClassDTO:" + stuClassDTO);
            //
            return stuClassDTO;
        } else {
            throw new IllegalArgumentException("stuId值不合法");
        }
    }

    @Override
    public int classAllocation(Integer stuId, Integer classId) {
        if (stuMapper.isExistClassId(stuId) != null) {
            log.debug("classId:" + stuMapper.isExistClassId(stuId));
            return 1;
        } else {
            stuMapper.updateClassIdByStuId(stuId, classId);
            return 0;
        }
    }

    @Override
    public List<StuSuggestDTO> searchByStuSuggest() {
        List<Student> students = stuMapper.searchBySuggestions();
        List<StuSuggestDTO> stuSuggestDTOS = stuSuggestConvert.toStuSuggestDTO(students);
        return stuSuggestDTOS;
    }

    @Override
    public List<ClazzSuggestDTO> searchByClassSuggest() {
        List<Clazz> clazzes = clazzMapper.searchBySuggestions();
        List<ClazzSuggestDTO> classSuggestDTOS = clazzSuggestConvert.toClazzSuggestDTO(clazzes);
        return classSuggestDTOS;
    }

    @Override
    public void deleteStudent(Integer id) {
        try {
            stuMapper.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void deleteSelect(List<Serializable> ids) {
        try {
            stuMapper.deleteSelect(ids);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public boolean isStuNameUnique(String stuName) {
        Student student = stuMapper.getStuByStuName(stuName);
        return student == null;
    }

    @Override
    public boolean isStuNumUnique(String stuNum) {
        Student student = stuMapper.getStuByStuNum(stuNum);
        return student == null;
    }

    @Override
    public void save(Student student) {
        stuMapper.save(student);
    }

    @Override
    public List<StuManagementDTO> searchByStuAndClass(String className, String stuRealName, String school, String college, String start, String end) {
        try {
            List<Student> student = stuMapper.selectStuInfo(className, stuRealName, school, college, start, end);
            List<StuManagementDTO> stuManagementDTO = stuConvert.toStuManagementDTO(student);
            return stuManagementDTO;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public void update(Student student) {
        stuMapper.update(student);
    }

    @Override
    public List<ClazzSuggestDTO> getOtherClassNames(Integer stuId) {
        List<Clazz> clazzes = stuMapper.getOtherClassNames(stuId);
        List<ClazzSuggestDTO> classSuggestDTOS = clazzSuggestConvert.toClazzSuggestDTO(clazzes);
        return classSuggestDTOS;
    }

    @Override
    public boolean isClassNameExist(String className) {
        Clazz clazz = clazzMapper.getClazzByClassName(className);
        return clazz != null;
    }

    @Override
    public void transferStu(Integer stuId, String className) {
            stuMapper.transferStu(stuId, className);
    }

    @Override
    public void switchStatus(Integer stuId, Integer status) {
        stuMapper.switchStatus(stuId, status);
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = stuMapper.selectAll();
        return students;
    }

    @Override
    public void saveAll(List<Student> studentList) {
        stuMapper.insertBatch(studentList);
    }

    @Override
    public void saveAllByClassId(List<Student> studentList, Integer classId) {
        stuMapper.insertBatchByClassId(studentList, classId);
    }

    @Override
    public List<ClassStuDTO> getStuByClassId(Integer classId) {
        try {
            List<Student> students = stuMapper.selectByClassId(classId);
            List<ClassStuDTO> classStuDTOS = classStuConvert.toClassStuDTOS(students);
            return classStuDTOS;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<ClassStuDTO> getStuByClassIdAndKeyword(Integer classId, String num, String name) {
        try {
            List<Student> students = stuMapper.selectByClassIdAndKeyword(classId, num, name);
            List<ClassStuDTO> classStuDTOS = classStuConvert.toClassStuDTOS(students);
            return classStuDTOS;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

}
