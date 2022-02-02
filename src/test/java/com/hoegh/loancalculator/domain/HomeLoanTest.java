package com.hoegh.loancalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class HomeLoanTest {

	@Test
	public void testGetNumMonths() {
		HomeLoan homeLoan = new HomeLoan(null, 1, null);
		assertThat(homeLoan.getNumMonths()).isEqualTo(12);
	}

	@Test
	public void testGetNumMonthlyInterest() {
		HomeLoan homeLoan = new HomeLoan(null, 0, new BigDecimal("0.06"));
		assertThat(homeLoan.getMonthlyInterest()).isEqualTo("0.005");
	}

	@Test
	public void testCalcMonthlyAmortization() {
		BigDecimal loanAmt = new BigDecimal("2000");
		int numYears = 1;
		BigDecimal yearlyInterest = new BigDecimal("0.06");
		HomeLoan homeLoan = new HomeLoan(loanAmt, numYears, yearlyInterest);

		BigDecimal expected = homeLoan.calcMonthlyAmortization();

		assertThat(expected).isEqualTo(new BigDecimal("172.13"));
	}

}
