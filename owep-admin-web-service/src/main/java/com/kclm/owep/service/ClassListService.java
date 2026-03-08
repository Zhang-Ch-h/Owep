package com.kclm.owep.service;

import com.kclm.owep.dto.ProfessionDTO;
import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.entity.Profession;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/*******************
 * @Author zch
 * @Description
 */
public interface ClassListService {

    List<Clazz> selectClassList();

    List<PlanManager> getPlanManagerSuggest();

    List<Course> findAllCourseByPlan(Integer planId);

    List<Profession> getProfessionSuggest(String instituteName, String instituteBranchName);

    // 返回0表示成功，返回-1表示不存在要分配的教师，返回1表示sql异常
    int saveClass(String classNumber, String className, String instituteName, String branchName, String professionName,
                  String planManagerName, String teacherName, LocalDateTime startTime, LocalDateTime endTime, Integer classStatus,
                  String classDesc);

    List<Clazz> getClassByKeyWords(String classNumber, String className, String instituteName, String branchName, String professionName);

    void deleteById(Integer id);

    void deleteByGroups(List<Serializable> ids);

    Clazz findClassById(Integer id);

    int updateClass(Integer classId, String classNumber, String className, String instituteName, String branchName, String professionName,
                    String planManagerName, String teacherName, LocalDateTime startTime, LocalDateTime endTime, String classDesc);

    void switchStatus(Integer id, Integer status);
}
