package com.kclm.owep.mapper;

import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Student;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/*******************
 * @Author zch
 * @Description
 */
@Mapper
public interface StuMapper extends BaseMapper<Student> {

    Student selectClassByStuId(@Param("stuId") Serializable stuId);

    Integer isExistClassId(@Param("stuId") Integer stuId);

    void updateClassIdByStuId(@Param("stuId") Integer stuId, @Param("classId") Integer classId);

    List<Student> searchBySuggestions();

    Student getStuByStuName(String stuName);

    Student getStuByStuNum(String stuNum);

    List<Student> selectStuInfo(@Param("className") String className, @Param("stuRealName") String stuRealName,
                          @Param("school") String school, @Param("college") String college, @Param("start") String start,
                          @Param("end") String end);

    List<Clazz> getOtherClassNames(@Param("stuId") Integer stuId);

    void transferStu(@Param("stuId") Integer stuId, @Param("className") String className);

    void switchStatus(@Param("stuId") Integer stuId, @Param("status") Integer status);

    void insertBatch(List<Student> studentList);

    void insertBatchByClassId(@Param("studentList") List<Student> studentList, @Param("classId") Integer classId);

    List<Student> selectByClassId(Integer classId);

    List<Student> selectByClassIdAndKeyword(@Param("classId") Integer classId, @Param("num") String num, @Param("name") String name);
}
