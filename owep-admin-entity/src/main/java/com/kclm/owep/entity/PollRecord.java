/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/*********************
 * @Author: ZhongLei
 * @Version : v1.0
 * @Create: 2020年7月03日
 * @Description 考评记录实体类
 */

public class PollRecord implements Serializable {

    /***
     * 主键
     */
    private Integer id;

    /***
     * 考评IP地址
     */
    private String ipAddress;

    /***
     *  考评得分
     */
    private Double pollScore;

    /***
     * 考评选项条数
     */
    private Integer pollCount;

    /***
     * 考评建议
     */
    private String pollSuggest;

    /***
     * 最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    /***
     * 版本号
     */
    private Integer version;

    /***
     * 考评时间
     */
    private LocalDateTime createTime;

    /***
     * 考评状态  0.有效 1.无效
     */
    private Boolean pollStatus;

    /***
     * 外键，教师考评id
     */
    private Integer fkTeacherPollId;

    /***
     * 所选模块中第一条,采用 条件:分值 的格式存储
     */
    private String pollItem1;

    /***
     * 所选模块中第一条,采用 条件:分值 的格式存储
     */
    private String pollItem2;

    /***
     * 所选模块中第一条,采用 条件:分值 的格式存储
     */
    private String pollItem3;

    /***
     * 所选模块中第一条,采用 条件:分值 的格式存储
     */
    private String pollItem4;

    /***
     * 所选模块中第一条,采用 条件:分值 的格式存储
     */
    private String pollItem5;

    /***
     * 所选模块中第一条,采用 条件:分值 的格式存储
     */
    private String pollItem6;

    /***
     * 所选模块中第一条,采用 条件:分值 的格式存储
     */
    private String pollItem7;

    /***
     * 所选模块中第一条,采用 条件:分值 的格式存储
     */
    private String pollItem8;

    /***
     * 所选模块中第一条,采用 条件:分值 的格式存储
     */
    private String pollItem9;

    /***
     * 所选模块中第一条,采用 条件:分值 的格式存储
     */
    private String pollItem10;

    /***
     * 所选模块中第一条,采用 条件:分值 的格式存储
     */
    private String pollItem11;

    /***
     * 所选模块中第一条,采用 条件:分值 的格式存储
     */
    private String pollItem12;

    /***
     * 所选模块中第一条,采用 条件:分值 的格式存储
     */
    private String pollItem13;

    /***
     * 所选模块中第一条,采用 条件:分值 的格式存储
     */
    private String pollItem14;

    /***
     * 所选模块中第一条,采用 条件:分值 的格式存储
     */
    private String pollItem15;

    /***
     * 空参构造
     */
    public PollRecord() {
    }

    /***
     * 有参构造
     * @param ipAddress
     * @param pollScore
     * @param pollCount
     * @param createTime
     * @param fkTeacherPollId
     */
    public PollRecord(String ipAddress, Double pollScore, Integer pollCount, LocalDateTime createTime, Integer fkTeacherPollId) {
        this.ipAddress = ipAddress;
        this.pollScore = pollScore;
        this.pollCount = pollCount;
        this.createTime = createTime;
        this.fkTeacherPollId = fkTeacherPollId;
    }

    /***
     * 全参构造
     * @return
     */
    public PollRecord(Integer id, String ipAddress, Double pollScore, Integer pollCount, String pollSuggest, LocalDateTime lastAccessTime, Integer version, LocalDateTime createTime, Boolean pollStatus, Integer fkTeacherPollId, String pollItem1, String pollItem2, String pollItem3, String pollItem4, String pollItem5, String pollItem6, String pollItem7, String pollItem8, String pollItem9, String pollItem10, String pollItem11, String pollItem12, String pollItem13, String pollItem14, String pollItem15) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.pollScore = pollScore;
        this.pollCount = pollCount;
        this.pollSuggest = pollSuggest;
        this.lastAccessTime = lastAccessTime;
        this.version = version;
        this.createTime = createTime;
        this.pollStatus = pollStatus;
        this.fkTeacherPollId = fkTeacherPollId;
        this.pollItem1 = pollItem1;
        this.pollItem2 = pollItem2;
        this.pollItem3 = pollItem3;
        this.pollItem4 = pollItem4;
        this.pollItem5 = pollItem5;
        this.pollItem6 = pollItem6;
        this.pollItem7 = pollItem7;
        this.pollItem8 = pollItem8;
        this.pollItem9 = pollItem9;
        this.pollItem10 = pollItem10;
        this.pollItem11 = pollItem11;
        this.pollItem12 = pollItem12;
        this.pollItem13 = pollItem13;
        this.pollItem14 = pollItem14;
        this.pollItem15 = pollItem15;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getIpAddress() {
        return ipAddress;
    }


    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }


    public Double getPollScore() {
        return pollScore;
    }


    public void setPollScore(Double pollScore) {
        this.pollScore = pollScore;
    }


    public Integer getPollCount() {
        return pollCount;
    }


    public void setPollCount(Integer pollCount) {
        this.pollCount = pollCount;
    }


    public String getPollSuggest() {
        return pollSuggest;
    }


    public void setPollSuggest(String pollSuggest) {
        this.pollSuggest = pollSuggest == null ? null : pollSuggest.trim();
    }


    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }


    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }


    public Integer getVersion() {
        return version;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }


    public LocalDateTime getCreateTime() {
        return createTime;
    }


    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }


    public Boolean getPollStatus() {
        return pollStatus;
    }


    public void setPollStatus(Boolean pollStatus) {
        this.pollStatus = pollStatus;
    }


    public Integer getFkTeacherPollId() {
        return fkTeacherPollId;
    }


    public void setFkTeacherPollId(Integer fkTeacherPollId) {
        this.fkTeacherPollId = fkTeacherPollId;
    }


    public String getPollItem1() {
        return pollItem1;
    }


    public void setPollItem1(String pollItem1) {
        this.pollItem1 = pollItem1 == null ? null : pollItem1.trim();
    }


    public String getPollItem2() {
        return pollItem2;
    }


    public void setPollItem2(String pollItem2) {
        this.pollItem2 = pollItem2 == null ? null : pollItem2.trim();
    }


    public String getPollItem3() {
        return pollItem3;
    }


    public void setPollItem3(String pollItem3) {
        this.pollItem3 = pollItem3 == null ? null : pollItem3.trim();
    }


    public String getPollItem4() {
        return pollItem4;
    }


    public void setPollItem4(String pollItem4) {
        this.pollItem4 = pollItem4 == null ? null : pollItem4.trim();
    }


    public String getPollItem5() {
        return pollItem5;
    }


    public void setPollItem5(String pollItem5) {
        this.pollItem5 = pollItem5 == null ? null : pollItem5.trim();
    }


    public String getPollItem6() {
        return pollItem6;
    }


    public void setPollItem6(String pollItem6) {
        this.pollItem6 = pollItem6 == null ? null : pollItem6.trim();
    }


    public String getPollItem7() {
        return pollItem7;
    }


    public void setPollItem7(String pollItem7) {
        this.pollItem7 = pollItem7 == null ? null : pollItem7.trim();
    }


    public String getPollItem8() {
        return pollItem8;
    }


    public void setPollItem8(String pollItem8) {
        this.pollItem8 = pollItem8 == null ? null : pollItem8.trim();
    }


    public String getPollItem9() {
        return pollItem9;
    }


    public void setPollItem9(String pollItem9) {
        this.pollItem9 = pollItem9 == null ? null : pollItem9.trim();
    }


    public String getPollItem10() {
        return pollItem10;
    }


    public void setPollItem10(String pollItem10) {
        this.pollItem10 = pollItem10 == null ? null : pollItem10.trim();
    }


    public String getPollItem11() {
        return pollItem11;
    }


    public void setPollItem11(String pollItem11) {
        this.pollItem11 = pollItem11 == null ? null : pollItem11.trim();
    }


    public String getPollItem12() {
        return pollItem12;
    }


    public void setPollItem12(String pollItem12) {
        this.pollItem12 = pollItem12 == null ? null : pollItem12.trim();
    }


    public String getPollItem13() {
        return pollItem13;
    }


    public void setPollItem13(String pollItem13) {
        this.pollItem13 = pollItem13 == null ? null : pollItem13.trim();
    }


    public String getPollItem14() {
        return pollItem14;
    }


    public void setPollItem14(String pollItem14) {
        this.pollItem14 = pollItem14 == null ? null : pollItem14.trim();
    }


    public String getPollItem15() {
        return pollItem15;
    }


    public void setPollItem15(String pollItem15) {
        this.pollItem15 = pollItem15 == null ? null : pollItem15.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PollRecord)) return false;
        PollRecord that = (PollRecord) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getIpAddress(), that.getIpAddress()) &&
                Objects.equals(getPollScore(), that.getPollScore()) &&
                Objects.equals(getPollCount(), that.getPollCount()) &&
                Objects.equals(getPollSuggest(), that.getPollSuggest());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIpAddress(), getPollScore(), getPollCount(), getPollSuggest());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PollRecord{");
        sb.append("id=").append(id);
        sb.append(", ipAddress='").append(ipAddress).append('\'');
        sb.append(", pollScore=").append(pollScore);
        sb.append(", pollCount=").append(pollCount);
        sb.append(", pollSuggest='").append(pollSuggest).append('\'');
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", pollStatus=").append(pollStatus);
        sb.append(", fkTeacherPollId=").append(fkTeacherPollId);
        sb.append(", pollItem1='").append(pollItem1).append('\'');
        sb.append(", pollItem2='").append(pollItem2).append('\'');
        sb.append(", pollItem3='").append(pollItem3).append('\'');
        sb.append(", pollItem4='").append(pollItem4).append('\'');
        sb.append(", pollItem5='").append(pollItem5).append('\'');
        sb.append(", pollItem6='").append(pollItem6).append('\'');
        sb.append(", pollItem7='").append(pollItem7).append('\'');
        sb.append(", pollItem8='").append(pollItem8).append('\'');
        sb.append(", pollItem9='").append(pollItem9).append('\'');
        sb.append(", pollItem10='").append(pollItem10).append('\'');
        sb.append(", pollItem11='").append(pollItem11).append('\'');
        sb.append(", pollItem12='").append(pollItem12).append('\'');
        sb.append(", pollItem13='").append(pollItem13).append('\'');
        sb.append(", pollItem14='").append(pollItem14).append('\'');
        sb.append(", pollItem15='").append(pollItem15).append('\'');
        sb.append('}');
        return sb.toString();
    }
}