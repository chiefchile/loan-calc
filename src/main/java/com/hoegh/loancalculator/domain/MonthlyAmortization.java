package com.hoegh.loancalculator.domain;

import java.math.BigDecimal;

public class MonthlyAmortization {
	private BigDecimal beginningBal;
	private BigDecimal interest;
	private BigDecimal principal;
	private BigDecimal endingBal;

	public MonthlyAmortization(BigDecimal beginningBal, BigDecimal interest, BigDecimal principal,
			BigDecimal endingBal) {
		super();
		this.beginningBal = beginningBal;
		this.interest = interest;
		this.principal = principal;
		this.endingBal = endingBal;
	}

	public BigDecimal getBeginningBal() {
		return beginningBal;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public BigDecimal getPrincipal() {
		return principal;
	}

	public BigDecimal getEndingBal() {
		return endingBal;
	}

}
