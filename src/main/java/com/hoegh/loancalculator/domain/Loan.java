package com.hoegh.loancalculator.domain;

import java.math.BigDecimal;
import java.util.List;

public interface Loan {
	public BigDecimal calcMonthlyAmortization();

	public List<AmortizationSchedEntry> generateAmortizationSched();
}
