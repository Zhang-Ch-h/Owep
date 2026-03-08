/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.dto;

import java.io.Serializable;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/13 14:27
 *@Description 客户量DTO
 *
 */
public class ClientQuantityDTO implements Serializable {

    /**
     * 潜在客户
     */
    private long  latentClient;

    /**
     * 一面邀约客户
     */
    private long AInviteClient;

    /**
     * 邀约失败客户
     */
    private long failInviteClient;

    /**
     * 一面可跟进客户
     */
    private long AFollowUpClient;

    /**
     * 二面可跟进客户
     */
    private long twoFollowUpClient;

    /**
     * 丢单
     */
    private long loseOrder;

    /**
     * 签约成功
     */
    private long signSuccess;

    public long getLatentClient() {
        return latentClient;
    }

    public void setLatentClient(long latentClient) {
        this.latentClient = latentClient;
    }

    public long getAInviteClient() {
        return AInviteClient;
    }

    public void setAInviteClient(long AInviteClient) {
        this.AInviteClient = AInviteClient;
    }

    public long getFailInviteClient() {
        return failInviteClient;
    }

    public void setFailInviteClient(long failInviteClient) {
        this.failInviteClient = failInviteClient;
    }

    public long getAFollowUpClient() {
        return AFollowUpClient;
    }

    public void setAFollowUpClient(long AFollowUpClient) {
        this.AFollowUpClient = AFollowUpClient;
    }

    public long getTwoFollowUpClient() {
        return twoFollowUpClient;
    }

    public void setTwoFollowUpClient(long twoFollowUpClient) {
        this.twoFollowUpClient = twoFollowUpClient;
    }

    public long getLoseOrder() {
        return loseOrder;
    }

    public void setLoseOrder(long loseOrder) {
        this.loseOrder = loseOrder;
    }

    public long getSignSuccess() {
        return signSuccess;
    }

    public void setSignSuccess(long signSuccess) {
        this.signSuccess = signSuccess;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ClientQuantityDTO{");
        sb.append("latentClient=").append(latentClient);
        sb.append(", AInviteClient=").append(AInviteClient);
        sb.append(", failInviteClient=").append(failInviteClient);
        sb.append(", AFollowUpClient=").append(AFollowUpClient);
        sb.append(", twoFollowUpClient=").append(twoFollowUpClient);
        sb.append(", loseOrder=").append(loseOrder);
        sb.append(", signSuccess=").append(signSuccess);
        sb.append('}');
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientQuantityDTO that = (ClientQuantityDTO) o;
        return latentClient == that.latentClient &&
                AInviteClient == that.AInviteClient &&
                failInviteClient == that.failInviteClient &&
                AFollowUpClient == that.AFollowUpClient &&
                twoFollowUpClient == that.twoFollowUpClient &&
                loseOrder == that.loseOrder &&
                signSuccess == that.signSuccess;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latentClient, AInviteClient, failInviteClient, AFollowUpClient, twoFollowUpClient, loseOrder, signSuccess);
    }
}
