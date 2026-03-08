package com.kclm.owep.service.impl;

import com.kclm.owep.dto.ProfessionDTO;
import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.entity.Profession;
import com.kclm.owep.mapper.*;
import com.kclm.owep.service.ClassListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*******************
 * @Author zch
 * @Description
 */
@Service
@Slf4j
public class ClassListServiceImpl implements ClassListService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private PlanManagerMapper planManagerMapper;

    @Autowired
    private ProfessionMapper professionMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Clazz> selectClassList() {
        try {
            return clazzMapper.selectClassList();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<PlanManager> getPlanManagerSuggest() {
        try {
            return planManagerMapper.selectPlanName();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<Profession> getProfessionSuggest(String instituteName, String instituteBranchName) {
        try {
            return professionMapper.selectByInstituteNameAndInstituteBranchName(instituteName, instituteBranchName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<Course> findAllCourseByPlan(Integer planId) {
        try {
            return courseMapper.selectByPlanId(planId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public int saveClass(String classNumber, String className, String instituteName, String branchName,
                         String professionName, String planManagerName, String teacherName, LocalDateTime startTime,
                         LocalDateTime endTime, Integer classStatus, String classDesc) {
        try {
            if (userMapper.getUserByTeacherRealName(teacherName).isEmpty()) {
                return -1;
            } else {
                /********
                 * 通过专业方向名、所属机构、所属分支查找专业表中的唯一性id，为后面的班级表添加外键专业id做准备
                 * 通过方案名查找方案表中的唯一性id，为后面的添加班级方案中间表中的方案外键id做准备
                 */
                Profession profession = professionMapper.selectByProfNameAndInstituteNameAndInstituteBranchName(professionName,
                                                                                                        instituteName, branchName);
                Integer profId = profession.getId();
                //
                PlanManager planManager = planManagerMapper.selectByPlanName(planManagerName);
                Integer planId = planManager.getId();
                // 先执行插入班级表的操作
                clazzMapper.saveClass(classNumber, className, instituteName, branchName, profId, teacherName, startTime,
                        endTime, classStatus, classDesc);
                // 0.获取插入班级表后自动生成的主键id
                Clazz clazz = clazzMapper.selectBySaveClass(classNumber, className, instituteName, branchName, profId, teacherName, startTime,
                        endTime, classStatus, classDesc);
                Integer classId = clazz.getId();
                // 1.插入班级方案中间表
                clazzMapper.insertClassPlan(planId, classId);
                return 0;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return 1;
        }
    }

    @Override
    public List<Clazz> getClassByKeyWords(String classNumber, String className, String instituteName, String branchName, String professionName) {
        try {
            if (!professionName.equals("")) {
                log.debug("Enter professionName not empty string.");
                log.debug("professionName: " + professionName);
                // 通过专业方向名、所属机构、所属分支查找专业表中的唯一性id，为后面的查询做准备
                Profession profession = professionMapper.selectByProfNameAndInstituteNameAndInstituteBranchName(professionName,
                        instituteName, branchName);
                Integer profId;
                if (profession == null) {
                    profId = null;
                } else {
                    profId = profession.getId();
                }
                log.debug("id: " + profId);
                // 查询班级表
                return clazzMapper.selectByKeyWords(classNumber, className, instituteName, branchName, profId);
            } else {
                log.debug("Enter professionName is empty string.");
                Profession profession = professionMapper.selectByInstituteNameAndInstituteBranchNameAndIsDelete(instituteName, branchName);
                Integer profId = profession.getId();
                log.debug("id: " + profId);
                return clazzMapper.selectByKeyWords(classNumber, className, instituteName, branchName, profId);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            clazzMapper.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("error");
        }
    }

    @Override
    public void deleteByGroups(List<Serializable> ids) {
        try {
            clazzMapper.deleteSelect(ids);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("error");
        }
    }

    @Override
    public Clazz findClassById(Integer id) {
        try {
            Clazz clazz = clazzMapper.selectById(id);
            System.out.println(clazz.getProfession());

            // 检查 PlanManagerList 是否为空
            if (clazz.getPlanManagerList() == null || clazz.getPlanManagerList().isEmpty()) {
                List<PlanManager> planManagerList = new ArrayList<>();
                planManagerList.add(new PlanManager()); // 添加一个空的 PlanManager 对象
                clazz.setPlanManagerList(planManagerList); // 设置列表
            }

            // 独立检查 Profession 是否为空
            if (clazz.getProfession() == null) {
                log.debug("Enter the judgment where 'Profession' is empty.");
                clazz.setProfession(new Profession()); // 设置新的 Profession 对象
            }

            // 返回更新后的 clazz 对象
            return clazz;

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public int updateClass(Integer classId, String classNumber, String className, String instituteName, String branchName,
                           String professionName, String planManagerName, String teacherName, LocalDateTime startTime,
                           LocalDateTime endTime, String classDesc) {
        try {
            if (userMapper.getUserByTeacherRealName(teacherName).isEmpty()) {
                return -1;
            } else {
                /********
                 * 通过专业方向名、所属机构、所属分支查找专业表中的唯一性id，为后面的班级表添加外键专业id做准备
                 * 通过方案名查找方案表中的唯一性id，为后面的添加班级方案中间表中的方案外键id做准备
                 */
                Profession profession = professionMapper.selectByProfNameAndInstituteNameAndInstituteBranchName(professionName,
                        instituteName, branchName);
                Integer profId = profession.getId();
                // 拿到原先的方案id
                int prePlanId = clazzMapper.selectById(classId).getId();
                // 拿到修改后的方案id
                PlanManager planManager = planManagerMapper.selectByPlanName(planManagerName);
                Integer planId;
                if (planManager == null) {
                    planId = null;
                } else {
                    planId = planManager.getId();
                }
                // 更新班级表
                clazzMapper.updateClass(classId, classNumber, className, instituteName, branchName, profId, teacherName,
                                        startTime, endTime, classDesc);
                // 修改班级方案中间表
                // 根据 planId 的存在以及是否存在计划/班级的组合来修改班级计划关系
                if (clazzMapper.isExistPlanIdAndClassId(prePlanId, classId) != null) {
                    if (planId != null) {
                        // 如果存在班级和计划的关系，并且有新的 planId，那么就更新它
                        clazzMapper.updatePlanIdInCP(planId, prePlanId, classId);
                    }
                    // 如果存在班级和计划的关系，但是没有新的 planId，那么就什么都不做
                } else if (planId != null) {
                    // 如果没有班级和计划的关系，但是有新的 planId，那么就插入它
                    clazzMapper.insertClassPlan(planId, classId);
                }
                // 如果两个条件都不满足，那么就什么都不做
                return 0;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return 1;
        }
    }

    @Override
    public void switchStatus(Integer id, Integer status) {
        try {
            clazzMapper.switchStatus(id, status);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
