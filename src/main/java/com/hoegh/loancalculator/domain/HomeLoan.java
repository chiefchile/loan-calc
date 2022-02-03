package com.hoegh.loancalculator.domain;

import static java.math.BigDecimal.ONE;
import static java.math.RoundingMode.HALF_EVEN;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HomeLoan implements Loan {
    private BigDecimal loanAmt;
    private int numYears;
    private BigDecimal yearlyInterest;

    public HomeLoan(BigDecimal loanAmt, int numYears, BigDecimal yearlyInterest) {
        super();
        this.loanAmt = loanAmt;
        this.numYears = numYears;
        this.yearlyInterest = yearlyInterest;
    }

    public BigDecimal getLoanAmt() {
        return loanAmt;
    }

    public int getNumYears() {
        return numYears;
    }

    public int getNumMonths() {
        return 12 * numYears;
    }

    public BigDecimal getYearlyInterest() {
        return yearlyInterest;
    }

    // TODO: Get formula for compound interest
    public BigDecimal getMonthlyInterest() {
        return yearlyInterest.divide(new BigDecimal("12"));
    }

    public BigDecimal calcMonthlyAmortization() {
        BigDecimal numerator = loanAmt.multiply(getMonthlyInterest())
                .multiply((ONE.add(getMonthlyInterest()).pow(getNumMonths())));
        BigDecimal denominator = (ONE.add(getMonthlyInterest())).pow(getNumMonths()).subtract(ONE);
        return numerator.divide(denominator, HALF_EVEN).setScale(2, HALF_EVEN);
    }

    public List<AmortizationSchedEntry> generateAmortizationSched() {
        List<AmortizationSchedEntry> amortizationSched = new ArrayList<AmortizationSchedEntry>();
        BigDecimal beginningBal = loanAmt;
        LocalDate date = LocalDate.now();
        for (int i = 0; i < getNumMonths(); i++) {
            AmortizationSchedEntry entry = new AmortizationSchedEntry(calcMonthlyAmortization(),
                    beginningBal, getMonthlyInterest(), date.getYear(), date.getMonthValue());
            beginningBal = entry.getEndingBal();
            amortizationSched.add(entry);
            date = date.plusMonths(1);
        }

        return amortizationSched;
    }

}
