/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/13 15:51
 *@Description 客户DTO
 *
 */
public class ClientDTO implements Serializable {

    /**
     * 意向客户id
     */
    private Integer id;

    /**
     * 意向客户的姓名
     */
    private String clientName;

    /**
     * 意向客户电话
     */
    private String clientPhone;

    /**
     * 客户性别：0女、1男
     */
    private Integer gender;

    /**
     * 意向客户的工作经历，或自我介绍
     */
    private String clientExperience;

    /**
     * 市场人员对意向客户的评价
     */
    private String salsemanDescribe;

    /**
     * 预付金额
     */
    private Double advancePay;

    /**
     * 总金额
     */
    private Double totalPay;

    /**
     * 每月还款
     */
    private Double monthPay;

    /**
     * 还款金额
     */
    private Integer payMent;

    /**
     * 是否分配班级：0未分配、1已分配
     */
    private Integer isAssignClass;

    /**
     * 邮箱
     */
    private String clientEmail;

    /**
     * 是否贷款：0未贷款、1贷款
     */
    private Integer loanStatus;

    /**
     * 贷款金额
     */
    private Double loan;

    /**
     * 还款方式
     */
    private String repaymentPlan;

    /**
     * 面试起始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate interviewTimeStart;
    /**
     * 面试终止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate interviewTimeEnd;

    /**
     * 客户类型：0无意向、1已签约、2潜在客户、3标准客户
     */
    private Integer clientState;

    /**
     * 意向专业
     */
    private String profession;

    /**
     * 原本专业
     */
    private String major;

    /**
     * 签约时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime signTime;

    /**
     * 渠道类型名称
     */
    private String channelTypeName;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 咨询师的姓名
     */
    private String userName;

    /**
     * 客户的跟踪记录
     */
    private List<ClientNoteDTO> clientNoteList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getClientExperience() {
        return clientExperience;
    }

    public void setClientExperience(String clientExperience) {
        this.clientExperience = clientExperience;
    }

    public String getSalsemanDescribe() {
        return salsemanDescribe;
    }

    public void setSalsemanDescribe(String salsemanDescribe) {
        this.salsemanDescribe = salsemanDescribe;
    }

    public Double getAdvancePay() {
        return advancePay;
    }

    public void setAdvancePay(Double advancePay) {
        this.advancePay = advancePay;
    }

    public Double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Double totalPay) {
        this.totalPay = totalPay;
    }

    public Double getMonthPay() {
        return monthPay;
    }

    public void setMonthPay(Double monthPay) {
        this.monthPay = monthPay;
    }

    public Integer getPayMent() {
        return payMent;
    }

    public void setPayMent(Integer payMent) {
        this.payMent = payMent;
    }

    public String getRepaymentPlan() {
        return repaymentPlan;
    }

    public void setRepaymentPlan(String repaymentPlan) {
        this.repaymentPlan = repaymentPlan;
    }

    public Integer getIsAssignClass() {
        return isAssignClass;
    }

    public void setIsAssignClass(Integer isAssignClass) {
        this.isAssignClass = isAssignClass;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public Integer getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

    public Double getLoan() {
        return loan;
    }

    public void setLoan(Double loan) {
        this.loan = loan;
    }

    public LocalDate getInterviewTimeStart() {
        return interviewTimeStart;
    }

    public void setInterviewTimeStart(LocalDate interviewTimeStart) {
        this.interviewTimeStart = interviewTimeStart;
    }

    public LocalDate getInterviewTimeEnd() {
        return interviewTimeEnd;
    }

    public void setInterviewTimeEnd(LocalDate interviewTimeEnd) {
        this.interviewTimeEnd = interviewTimeEnd;
    }

    public Integer getClientState() {
        return clientState;
    }

    public void setClientState(Integer clientState) {
        this.clientState = clientState;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public LocalDateTime getSignTime() {
        return signTime;
    }

    public void setSignTime(LocalDateTime signTime) {
        this.signTime = signTime;
    }

    public String getChannelTypeName() {
        return channelTypeName;
    }

    public void setChannelTypeName(String channelTypeName) {
        this.channelTypeName = channelTypeName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<ClientNoteDTO> getClientNoteList() {
        return clientNoteList;
    }

    public void setClientNoteList(List<ClientNoteDTO> clientNoteList) {
        this.clientNoteList = clientNoteList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ClientDTO{");
        sb.append("id=").append(id);
        sb.append(", clientName='").append(clientName).append('\'');
        sb.append(", clientPhone='").append(clientPhone).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", clientExperience='").append(clientExperience).append('\'');
        sb.append(", salsemanDescribe='").append(salsemanDescribe).append('\'');
        sb.append(", advancePay=").append(advancePay);
        sb.append(", totalPay=").append(totalPay);
        sb.append(", monthPay=").append(monthPay);
        sb.append(", payMent=").append(payMent);
        sb.append(", isAssignClass=").append(isAssignClass);
        sb.append(", clientEmail='").append(clientEmail).append('\'');
        sb.append(", loanStatus=").append(loanStatus);
        sb.append(", loan=").append(loan);
        sb.append(", repaymentPlan=").append(repaymentPlan);
        sb.append(", interviewTimeStart=").append(interviewTimeStart);
        sb.append(", interviewTimeEnd=").append(interviewTimeEnd);
        sb.append(", clientState=").append(clientState);
        sb.append(", profession='").append(profession).append('\'');
        sb.append(", major='").append(major).append('\'');
        sb.append(", signTime=").append(signTime);
        sb.append(", channelTypeName='").append(channelTypeName).append('\'');
        sb.append(", channelName='").append(channelName).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return Objects.equals(id, clientDTO.id) &&
                Objects.equals(clientName, clientDTO.clientName) &&
                Objects.equals(clientPhone, clientDTO.clientPhone) &&
                Objects.equals(gender, clientDTO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientName, clientPhone, gender);
    }
}
