package com.hoegh.loancalculator.domain;

import static java.math.RoundingMode.HALF_EVEN;
import java.math.BigDecimal;

public class AmortizationSchedEntry {
    private BigDecimal monthlyAmortization;
    private BigDecimal beginningBal;
    private BigDecimal monthlyInterest;
    private int year;
    private int month;

    public AmortizationSchedEntry(BigDecimal monthlyAmortization, BigDecimal beginningBal,
            BigDecimal monthlyInterest, int year, int month) {
        super();
        this.monthlyAmortization = monthlyAmortization;
        this.beginningBal = beginningBal;
        this.monthlyInterest = monthlyInterest;
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public BigDecimal getMonthlyAmortization() {
        return monthlyAmortization;
    }

    public BigDecimal getBeginningBal() {
        return beginningBal.setScale(2, HALF_EVEN);
    }

    public BigDecimal getMonthlyInterest() {
        return monthlyInterest.setScale(2, HALF_EVEN);
    }

    public BigDecimal getInterest() {
        return monthlyInterest.multiply(beginningBal).setScale(2, HALF_EVEN);
    }

    public BigDecimal getPrincipal() {
        return monthlyAmortization.subtract(getInterest());
    }

    public BigDecimal getEndingBal() {
        return beginningBal.subtract(getPrincipal());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AmortizationSchedEntry [beginningBal=").append(beginningBal)
                .append(", interest=").append(getInterest()).append(", principal=")
                .append(getPrincipal()).append(", endingBal=").append(getEndingBal()).append("]");
        return builder.toString();
    }

}
