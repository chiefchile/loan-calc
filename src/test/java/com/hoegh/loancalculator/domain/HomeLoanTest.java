package com.hoegh.loancalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

public class HomeLoanTest {

	@Test
	public void testGetNumMonths() {
		HomeLoan homeLoan = new HomeLoan(null, 1, null);
		assertThat(homeLoan.getNumMonths()).isEqualTo(12);
	}

	@Test
	public void testGetMonthlyInterest() {
		HomeLoan homeLoan = new HomeLoan(null, 0, new BigDecimal("0.06"));
		assertThat(homeLoan.getMonthlyInterest()).isEqualTo(new BigDecimal("0.005"));
	}

	@Test
	public void testCalcMonthlyAmortization() {
		BigDecimal loanAmt = new BigDecimal("2000");
		int numYears = 1;
		BigDecimal yearlyInterest = new BigDecimal("0.06");
		HomeLoan homeLoan = new HomeLoan(loanAmt, numYears, yearlyInterest);

		BigDecimal monthlyAmortization = homeLoan.calcMonthlyAmortization();

		assertThat(monthlyAmortization).isEqualTo(new BigDecimal("172.13"));
	}

	@Test
	public void testGenerateAmortizationSched() {
		BigDecimal loanAmt = new BigDecimal("2000");
		int numYears = 1;
		BigDecimal yearlyInterest = new BigDecimal("0.06");
		HomeLoan homeLoan = new HomeLoan(loanAmt, numYears, yearlyInterest);

		List<AmortizationSchedEntry> sched = homeLoan.generateAmortizationSched();

		assertThat(sched.size()).isEqualTo(12);
		AmortizationSchedEntry firstEntry = sched.get(0);
		assertThat(firstEntry.getBeginningBal()).isEqualTo(new BigDecimal("2000.00"));
		assertThat(firstEntry.getInterest()).isEqualTo(new BigDecimal("10.00"));
		assertThat(firstEntry.getPrincipal()).isEqualTo(new BigDecimal("162.13"));
		assertThat(firstEntry.getEndingBal()).isEqualTo(new BigDecimal("1837.87"));

		AmortizationSchedEntry lastEntry = sched.get(sched.size() - 1);
		assertThat(lastEntry.getBeginningBal()).isEqualTo(new BigDecimal("171.31"));
		assertThat(lastEntry.getInterest()).isEqualTo(new BigDecimal("0.86"));
		assertThat(lastEntry.getPrincipal()).isEqualTo(new BigDecimal("171.27"));
		assertThat(lastEntry.getEndingBal()).isEqualTo(new BigDecimal("0.04"));

	}

}
