/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.dto;

import java.time.LocalDateTime;

/******************
 * @Author yejf
 * @Version v1.0
 * @Create 2020-07-13 16:57
 * @Description 系统统计信息 DTO 类
 */
public class SysStatisticsDTO {

    /** 主键 */
    private Integer id;
    /** 在某个时间统计点上的 在线人数 */
    private int onlineCount;
    /** 在某个时间统计点上的 访问人数 */
    private int accessCount;
    /** 在某个时间统计点上的  班级数量 */
    private int clazzCount;
    /** 在某个时间统计点上的 学员数量 */
    private int studentCount;
    /** 在某个时间统计点上的 实训方案数量 */
    private int planCount;
    /** 在某个时间统计点上的 课程数量 */
    private int courseCount;
    /** 在某个时间统计点上的 视频数量 */
    private int videoCount;
    /** 在某个时间统计点上的 文档资源数量 */
    private int docCount;
    /** 在某个时间统计点上的 试卷数量 */
    private int examCount;
    /** 在某个时间统计点上的 题库数量 */
    private int testItemCount;

    /** 分组统计所需的非表中属性 */
    private String type;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SysStatisticsDTO{");
        sb.append("id=").append(id);
        sb.append(", onlineCount=").append(onlineCount);
        sb.append(", accessCount=").append(accessCount);
        sb.append(", clazzCount=").append(clazzCount);
        sb.append(", studentCount=").append(studentCount);
        sb.append(", planCount=").append(planCount);
        sb.append(", courseCount=").append(courseCount);
        sb.append(", videoCount=").append(videoCount);
        sb.append(", docCount=").append(docCount);
        sb.append(", examCount=").append(examCount);
        sb.append(", testItemCount=").append(testItemCount);
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }

    public int getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(int accessCount) {
        this.accessCount = accessCount;
    }

    public int getClazzCount() {
        return clazzCount;
    }

    public void setClazzCount(int clazzCount) {
        this.clazzCount = clazzCount;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getPlanCount() {
        return planCount;
    }

    public void setPlanCount(int planCount) {
        this.planCount = planCount;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public int getDocCount() {
        return docCount;
    }

    public void setDocCount(int docCount) {
        this.docCount = docCount;
    }

    public int getExamCount() {
        return examCount;
    }

    public void setExamCount(int examCount) {
        this.examCount = examCount;
    }

    public int getTestItemCount() {
        return testItemCount;
    }

    public void setTestItemCount(int testItemCount) {
        this.testItemCount = testItemCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
