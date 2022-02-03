package com.hoegh.loancalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class AmortizationSchedEntryTest {

	@Test
	public void testGetInterest() {
		AmortizationSchedEntry entry = new AmortizationSchedEntry(null, new BigDecimal("2000"), new BigDecimal("0.005"),
				0, 0);
		assertThat(entry.getInterest()).isEqualTo(new BigDecimal("10.00"));
	}

	@Test
	public void testGetPrincipal() {
		AmortizationSchedEntry entry = new AmortizationSchedEntry(new BigDecimal("172.13"), new BigDecimal("2000"),
				new BigDecimal("0.005"), 0, 0);
		assertThat(entry.getPrincipal()).isEqualTo(new BigDecimal("162.13"));
	}

	@Test
	public void testGetEndingBal() {
		AmortizationSchedEntry entry = new AmortizationSchedEntry(new BigDecimal("172.13"), new BigDecimal("2000"),
				new BigDecimal("0.005"), 0, 0);
		assertThat(entry.getEndingBal()).isEqualTo(new BigDecimal("1837.87"));
	}

}
