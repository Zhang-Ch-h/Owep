package com.kclm.owep.mapper;

import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Student;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ClazzMapper extends BaseMapper<Clazz> {

    List<Clazz> searchBySuggestions();

    Clazz getClazzByClassName(String className);

    List<Clazz> getClazzByIsDelete(Integer isDelete);

    List<Clazz> selectClassList();

    void saveClass(@Param("classNumber") String classNumber, @Param("className") String className,
                   @Param("instituteName") String instituteName, @Param("branchName") String branchName,
                   @Param("profId") Integer profId, @Param("teacherName") String teacherName,
                   @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime,
                   @Param("classStatus") Integer classStatus, @Param("classDesc") String classDesc);

    Clazz selectBySaveClass(@Param("classNumber") String classNumber, @Param("className") String className,
                            @Param("instituteName") String instituteName, @Param("branchName") String branchName,
                            @Param("profId") Integer profId, @Param("teacherName") String teacherName,
                            @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime,
                            @Param("classStatus") Integer classStatus, @Param("classDesc") String classDesc);

    void insertClassPlan(@Param("planId") Integer planId, @Param("classId") Integer classId);

    List<Clazz> selectByKeyWords(@Param("classNumber") String classNumber, @Param("className") String className,
                                 @Param("instituteName") String instituteName, @Param("branchName") String branchName,
                                 @Param("profId") Integer profId);

    void updatePlanIdInCP(@Param("planId") Integer planId, @Param("prePlanId") Integer prePlanId, @Param("classId") Integer classId);

    Integer isExistPlanIdAndClassId(@Param("planId") Integer planId, @Param("classId") Integer classId);

    void updateClass(@Param("classId") Integer classId, @Param("classNumber") String classNumber, @Param("className") String className,
                     @Param("instituteName") String instituteName, @Param("branchName") String branchName, @Param("profId") Integer profId,
                     @Param("teacherName") String teacherName, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime,
                     @Param("classDesc") String classDesc);

    int selectPlanIdByClassIdInCP(@Param("classId") Integer classId);

    void switchStatus(@Param("id") Integer id, @Param("status") Integer status);

    List<Clazz> selectClassByKeyWords(@Param("profId") Integer profId, @Param("instituteName") String instituteName,
                                      @Param("instituteBranchName") String instituteBranchName);
}
