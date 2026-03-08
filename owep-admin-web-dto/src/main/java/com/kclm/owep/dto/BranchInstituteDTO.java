/*******
 * 2018-2021版权所有 CopyRight(c) 快程乐码信息有限公司 未经授权，不得随意使用！ 
 */
package com.kclm.owep.dto;

import com.kclm.owep.entity.OrgInstitute;

import java.time.LocalDateTime;

/*******
 * @Author yangwr
 * @Version v1.0
 * @Create 2020/7/13 10:27
 * @Description TODO
 */
public class BranchInstituteDTO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    /***
     * 分支机构id
     */
    private Integer branchId;
    /***
     * 分支名称
     */
    private String branchName;
    /***
     * 组织机构（外键）所属机构
     */
    private OrgInstitute orgInstitute;
    /***
     * 是否逻辑删除，1表示未删除，0表示已删除
     */
    private Integer delete;
    /***
     * 创建时间
     */
    private LocalDateTime createTime;

    /***
     *构造方法
     * @return
     */
    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public OrgInstitute getOrgInstitute() {
        return orgInstitute;
    }

    public void setOrgInstitute(OrgInstitute orgInstitute) {
        this.orgInstitute = orgInstitute;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
