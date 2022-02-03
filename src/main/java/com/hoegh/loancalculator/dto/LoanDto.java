package com.hoegh.loancalculator.dto;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import com.hoegh.loancalculator.domain.LoanType;

public class LoanDto {
    private LoanType loanType;

    @NotNull(message = "Input loan amount")
    private BigDecimal loanAmt;

    private int numYears = 1;

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public BigDecimal getLoanAmt() {
        return loanAmt;
    }

    public void setLoanAmt(BigDecimal loanAmt) {
        this.loanAmt = loanAmt;
    }

    public int getNumYears() {
        return numYears;
    }

    public void setNumYears(int numYears) {
        this.numYears = numYears;
    }

}
