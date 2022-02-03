package com.hoegh.loancalculator.domain;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.hoegh.loancalculator.dto.LoanDto;

public class LoanFactoryTest {

    @Test
    public void testCreate_HomeLoan() {
        LoanDto loanDto = new LoanDto();
        loanDto.setLoanType(LoanType.HOME);

        Loan homeLoan = LoanFactory.create(loanDto);

        assertTrue(homeLoan instanceof HomeLoan);
    }

}
