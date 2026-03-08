/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.dto;

import java.io.Serializable;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/13 14:56
 *@Description 客户来源DTO
 *
 */
public class CustomerSourceDTO implements Serializable {

    /**
     * 前途无忧
     */
    private long futureCarefree;

    /**
     * 智联招聘
     */
    private long jobFair;

    public long getFutureCarefree() {
        return futureCarefree;
    }

    public void setFutureCarefree(long futureCarefree) {
        this.futureCarefree = futureCarefree;
    }

    public long getJobFair() {
        return jobFair;
    }

    public void setJobFair(long jobFair) {
        this.jobFair = jobFair;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CustomerSourceDTO{");
        sb.append("futureCarefree=").append(futureCarefree);
        sb.append(", jobFair=").append(jobFair);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerSourceDTO that = (CustomerSourceDTO) o;
        return futureCarefree == that.futureCarefree &&
                jobFair == that.jobFair;
    }

    @Override
    public int hashCode() {
        return Objects.hash(futureCarefree, jobFair);
    }
}
