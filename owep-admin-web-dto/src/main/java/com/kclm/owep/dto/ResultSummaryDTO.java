/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.dto;

import java.io.Serializable;
import java.util.Objects;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/13 14:09
 *@Description 业绩情况DTO
 *
 */
public class ResultSummaryDTO implements Serializable {

    /**
     * 订单总数
     */
    private double  orderTotal;

    /**
     *  贷款总数
     */
    private double loanTotal;

    /**
     * 预付款
     */
    private double prepayment;

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public double getLoanTotal() {
        return loanTotal;
    }

    public void setLoanTotal(double loanTotal) {
        this.loanTotal = loanTotal;
    }

    public double getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(double prepayment) {
        this.prepayment = prepayment;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ResultSummaryDTO{");
        sb.append("orderTotal=").append(orderTotal);
        sb.append(", loanTotal=").append(loanTotal);
        sb.append(", prepayment=").append(prepayment);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultSummaryDTO that = (ResultSummaryDTO) o;
        return Double.compare(that.orderTotal, orderTotal) == 0 &&
                Double.compare(that.loanTotal, loanTotal) == 0 &&
                Double.compare(that.prepayment, prepayment) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderTotal, loanTotal, prepayment);
    }
}
