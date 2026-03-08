/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/3 16:05
 *@Description 节实体类
 *
 */
public class Section implements Serializable {
    /**
     *节 id
     */
    private Integer id;

    /**
     *节名称
     */
    private String sectionName;

    /**
     *节编号
     */
    private String sectionNumber;

    /**
     *节描述
     */
    private String sectionDesc;

    /**
     *创建时间
     */
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     *视频观看状态：0不允许观看、1允许观看
     */
    private Integer videoStatus;

    /**
     *关联章对象
     */
    private Chapter chapter;

    /**
     *逻辑删除：0未删除、1已删除
     */
    private Integer isDelete;

    /**
     *实验文档路径
     */
    private String experimentDucumentFile;

    /**
     *实验环境地址
     */
    private String experimentEnvironmentAddr;

    /**
     *是否开启实验：0不开启实验、1开启实验
     */
    private Integer experiment;

    /**
     *未登录是否可以观看：0表示不可以、1表示可以
     */
    private Integer lookVideoStatus;

    /**
     *版本
     */
    private Integer version = 1;

    /**
     *最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    /**
     *实验说明
     */
    private String experimentInstrusction;

    public Section() {
    }

    public Section(String sectionName, String sectionNumber, String sectionDesc, LocalDateTime createTime, Chapter chapter, Integer lookVideoStatus) {
        this.sectionName = sectionName;
        this.sectionNumber = sectionNumber;
        this.sectionDesc = sectionDesc;
        this.chapter = chapter;
        this.lookVideoStatus = lookVideoStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(String sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public String getSectionDesc() {
        return sectionDesc;
    }

    public void setSectionDesc(String sectionDesc) {
        this.sectionDesc = sectionDesc;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getVideoStatus() {
        return videoStatus;
    }

    public void setVideoStatus(Integer videoStatus) {
        this.videoStatus = videoStatus;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getExperimentDucumentFile() {
        return experimentDucumentFile;
    }

    public void setExperimentDucumentFile(String experimentDucumentFile) {
        this.experimentDucumentFile = experimentDucumentFile;
    }

    public String getExperimentEnvironmentAddr() {
        return experimentEnvironmentAddr;
    }

    public void setExperimentEnvironmentAddr(String experimentEnvironmentAddr) {
        this.experimentEnvironmentAddr = experimentEnvironmentAddr;
    }

    public Integer getExperiment() {
        return experiment;
    }

    public void setExperiment(Integer experiment) {
        this.experiment = experiment;
    }

    public Integer getLookVideoStatus() {
        return lookVideoStatus;
    }

    public void setLookVideoStatus(Integer lookVideoStatus) {
        this.lookVideoStatus = lookVideoStatus;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public String getExperimentInstrusction() {
        return experimentInstrusction;
    }

    public void setExperimentInstrusction(String experimentInstrusction) {
        this.experimentInstrusction = experimentInstrusction;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Section{");
        sb.append("id=").append(id);
        sb.append(", sectionName='").append(sectionName).append('\'');
        sb.append(", sectionNumber='").append(sectionNumber).append('\'');
        sb.append(", sectionDesc='").append(sectionDesc).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", videoStatus=").append(videoStatus);
        sb.append(", chapter=").append(chapter);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", experimentDucumentFile='").append(experimentDucumentFile).append('\'');
        sb.append(", experimentEnvironmentAddr='").append(experimentEnvironmentAddr).append('\'');
        sb.append(", experiment=").append(experiment);
        sb.append(", lookVideoStatus=").append(lookVideoStatus);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", experimentInstrusction='").append(experimentInstrusction).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(sectionName, section.sectionName) &&
                Objects.equals(sectionNumber, section.sectionNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sectionName, sectionNumber);
    }
}