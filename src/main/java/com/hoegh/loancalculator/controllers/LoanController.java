package com.hoegh.loancalculator.controllers;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.hoegh.loancalculator.domain.AmortizationSchedEntry;
import com.hoegh.loancalculator.domain.Loan;
import com.hoegh.loancalculator.domain.LoanFactory;
import com.hoegh.loancalculator.domain.LoanType;
import com.hoegh.loancalculator.dto.LoanDto;

@Controller
public class LoanController {

    @GetMapping("/")
    public String toIndex(LoanDto loanDto) {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(LoanDto loanDto, Model model) {
        loanDto.setLoanType(LoanType.HOME);
        Loan loan = LoanFactory.create(loanDto);
        BigDecimal monthlyAmortization = loan.calcMonthlyAmortization();
        List<AmortizationSchedEntry> sched = loan.generateAmortizationSched();
        model.addAttribute("monthlyAmortization", monthlyAmortization);
        model.addAttribute("sched", sched);
        return "index";
    }

}
