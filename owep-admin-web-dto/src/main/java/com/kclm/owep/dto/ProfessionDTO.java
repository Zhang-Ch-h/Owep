/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.dto;

import java.util.Objects;

/*****************
 *
 * @author tanj
 * @date 2020/7/13 10:22
 * @version v1.0
 * @description 专业相关的DTO
 *
 */
public class ProfessionDTO {
    /***
     * id
     */
    private Integer id;
    /***
     * 专业名称
     */
    private String profName;
    /**
     * 所属机构
     */
    private String instituteName;
    /**
     * 所属分支
     */
    private String instituteBranchName;
    /**
     * 是否启用
     */
    private int profStatus;

    /**
     * 专业描述
     */
    private String profDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getInstituteBranchName() {
        return instituteBranchName;
    }

    public void setInstituteBranchName(String instituteBranchName) {
        this.instituteBranchName = instituteBranchName;
    }

    public int getProfStatus() {
        return profStatus;
    }

    public void setProfStatus(int profStatus) {
        this.profStatus = profStatus;
    }

    public String getProfDesc() {
        return profDesc;
    }

    public void setProfDesc(String profDesc) {
        this.profDesc = profDesc;
    }

    public ProfessionDTO() {
    }

    public ProfessionDTO(String profName, String instituteName, String instituteBranchName, int profStatus) {
        this.profName = profName;
        this.instituteName = instituteName;
        this.instituteBranchName = instituteBranchName;
        this.profStatus = profStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionDTO that = (ProfessionDTO) o;
        return profStatus == that.profStatus &&
                Objects.equals(profName, that.profName) &&
                Objects.equals(instituteName, that.instituteName) &&
                Objects.equals(instituteBranchName, that.instituteBranchName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profName, instituteName, instituteBranchName, profStatus);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProfessionDTO{");
        sb.append("id=").append(id);
        sb.append(", profName='").append(profName).append('\'');
        sb.append(", instituteName='").append(instituteName).append('\'');
        sb.append(", instituteBranchName='").append(instituteBranchName).append('\'');
        sb.append(", profStatus=").append(profStatus);
        sb.append(", profDesc=").append(profDesc);
        sb.append('}');
        return sb.toString();
    }
}
