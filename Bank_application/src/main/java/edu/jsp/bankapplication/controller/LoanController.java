package edu.jsp.bankapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.bankapplication.model.Loan;
import edu.jsp.bankapplication.service.LoanService;

@RestController
@RequestMapping("/loan")
public class LoanController {

	@Autowired
	private LoanService loanService;

	@PostMapping("/applyLoan")
	public Loan createLoan(@RequestParam Long userId, @RequestBody Loan loan) {
		return loanService.createLoan(userId, loan);
	}

	@GetMapping("/getLoanDetailsByUserId/{id}")
	public List<Loan> getLoanDetailsByUserId(@PathVariable Long id) {

		return loanService.getLoanDetailsByUserId(id);

	}

	@GetMapping("/getLoanDetailsById/{id}")
	public Loan getLoanDetailsById(@PathVariable Long id) {
		return loanService.getLoanDetailsById(id);
	}

	@DeleteMapping("/deleteloan/{id}")
	public String deleteLoanDetailsById(@PathVariable long id) {
		return loanService.deleteLoanDetailsById(id);
	}

	@PutMapping("/updateLoanDetailsById/{id}")
	public Loan updateLoanDetailsById(@PathVariable long id, @RequestBody Loan newLoan) {
		return loanService.updateLoanDetailsById(id, newLoan);
	}

	@PutMapping("/repayLoan")
	public Loan repayLoan(@RequestParam Long loanId, @RequestParam Double amount) {
		return loanService.repayLoan(loanId, amount);
	}

	@GetMapping("/getLoanStatus/{loanId}")
	public String getLoanStatus(@PathVariable Long loanId) {
		return loanService.getLoanStatus(loanId);
	}

}
