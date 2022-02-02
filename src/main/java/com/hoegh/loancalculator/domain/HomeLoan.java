package com.hoegh.loancalculator.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class HomeLoan {
	private BigDecimal loanAmt;
	private int numYears;
	private BigDecimal yearlyInterest;
//	private BigDecimal monthlyInterest;

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

	public BigDecimal getMonthlyInterest() {
		return yearlyInterest.divide(new BigDecimal("12"));
	}

	public BigDecimal calcMonthlyAmortization() {
		BigDecimal numerator = loanAmt.multiply(getMonthlyInterest())
				.multiply((BigDecimal.ONE.add(getMonthlyInterest()).pow(getNumMonths())));
		BigDecimal denominator = (BigDecimal.ONE.add(getMonthlyInterest())).pow(getNumMonths())
				.subtract(BigDecimal.ONE);
		return numerator.divide(denominator, RoundingMode.HALF_EVEN).setScale(2, RoundingMode.HALF_EVEN);
	}

	public List<MonthlyAmortization> getAllMonthlyAmortizations() {
		return null;
	}

}
