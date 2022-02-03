package com.hoegh.loancalculator.domain;

import java.math.BigDecimal;
import com.hoegh.loancalculator.dto.LoanDto;

public class LoanFactory {

    public static Loan create(LoanDto loanDto) {
        switch (loanDto.getLoanType()) {
            case HOME:
                return new HomeLoan(loanDto.getLoanAmt(), loanDto.getNumYears(),
                        new BigDecimal("0.06"));

            default:
                throw new RuntimeException("Invalid loan type");

        }
    }

}
