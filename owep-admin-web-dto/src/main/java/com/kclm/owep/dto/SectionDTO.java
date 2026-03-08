/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.dto;

import java.io.Serializable;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/13 15:35
 *@Description 节 DTO
 *
 */
public class SectionDTO implements Serializable {
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
     *未登录是否可以观看：0表示不可以、1表示可以
     */
    private Integer lookVideoStatus;

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
     *实验说明
     */
    private String experimentInstrusction;

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

    public Integer getLookVideoStatus() {
        return lookVideoStatus;
    }

    public void setLookVideoStatus(Integer lookVideoStatus) {
        this.lookVideoStatus = lookVideoStatus;
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

    public String getExperimentInstrusction() {
        return experimentInstrusction;
    }

    public void setExperimentInstrusction(String experimentInstrusction) {
        this.experimentInstrusction = experimentInstrusction;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SectionDTO{");
        sb.append("id=").append(id);
        sb.append(", sectionName='").append(sectionName).append('\'');
        sb.append(", sectionNumber='").append(sectionNumber).append('\'');
        sb.append(", sectionDesc='").append(sectionDesc).append('\'');
        sb.append(", lookVideoStatus=").append(lookVideoStatus);
        sb.append(", experimentDucumentFile='").append(experimentDucumentFile).append('\'');
        sb.append(", experimentEnvironmentAddr='").append(experimentEnvironmentAddr).append('\'');
        sb.append(", experiment=").append(experiment);
        sb.append(", experimentInstrusction='").append(experimentInstrusction).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionDTO that = (SectionDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(sectionName, that.sectionName) &&
                Objects.equals(sectionNumber, that.sectionNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sectionName, sectionNumber);
    }
}
