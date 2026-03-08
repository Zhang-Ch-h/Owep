package com.kclm.owep.entity.vo;

public class SummaryPay {
    private String total;     //总金额
    private String loan;      //贷款金额
    private String advance;   // 预付金额

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getLoan() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }

    public String getAdvance() {
        return advance;
    }

    public void setAdvance(String advance) {
        this.advance = advance;
    }

    @Override
    public String toString() {
        return "SummaryPay{" +
                "total='" + total + '\'' +
                ", loan='" + loan + '\'' +
                ", advance='" + advance + '\'' +
                '}';
    }
}
