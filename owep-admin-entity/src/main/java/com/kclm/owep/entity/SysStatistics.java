/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.Objects;

/******************
 * @Author yejf
 * @Version v1.0
 * @Create 2020-07-07 23:02
 * @Description 系统统计表对应的实体类
 */
public class SysStatistics {

    /** 主键 */
    private Integer id;
    /** 统计此条记录的时间，通过时间线来记录这个数据，将来可以按年、月、日、周、小时 来统计图表 */
    private LocalDateTime createTime;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SysStatistics() {
    }

    public SysStatistics(LocalDateTime createTime, int onlineCount, int accessCount, int clazzCount, int studentCount, int planCount, int courseCount, int videoCount, int docCount, int examCount, int testItemCount) {
        this.createTime = createTime;
        this.onlineCount = onlineCount;
        this.accessCount = accessCount;
        this.clazzCount = clazzCount;
        this.studentCount = studentCount;
        this.planCount = planCount;
        this.courseCount = courseCount;
        this.videoCount = videoCount;
        this.docCount = docCount;
        this.examCount = examCount;
        this.testItemCount = testItemCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SysStatistics{");
        sb.append("id=").append(id);
        sb.append(", createTime=").append(createTime);
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
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysStatistics that = (SysStatistics) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime);
    }
}
