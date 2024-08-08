package com.gift.website.Controller.Admin;



import  com.gift.website.Modal.Admin.LoanModel;
import com.gift.website.service.Admin.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/getAllLoans")
    public ResponseEntity<List<com.gift.website.Modal.Admin.LoanModel>> getAllLoans() {
        List<LoanModel> loans = loanService.getAllLoans();
        return ResponseEntity.ok(loans);
    }

    @PostMapping("/editLoan/{id}")
    public ResponseEntity<LoanModel> editLoan(@PathVariable Long id, @RequestBody LoanModel loanDetails) {
        return loanService.getLoanById(id)
            .map(loan -> {
                loan.setLoanType(loanDetails.getLoanType());
                loan.setLoanAmount(loanDetails.getLoanAmount());
                loan.setInterestRate(loanDetails.getInterestRate());
                loan.setLoanTenure(loanDetails.getLoanTenure());
                loan.setEligibilityCriteria(loanDetails.getEligibilityCriteria());
                loan.setFeesAndCharges(loanDetails.getFeesAndCharges());
                loan.setDocumentationRequirements(loanDetails.getDocumentationRequirements());
                loan.setDisbursementDetails(loanDetails.getDisbursementDetails());
                loan.setSupportAndServices(loanDetails.getSupportAndServices());
                loan.setTermsAndConditions(loanDetails.getTermsAndConditions());
                loan.setRiskAssessment(loanDetails.getRiskAssessment());

                LoanModel updatedLoan = loanService.saveOrUpdateLoan(loan);
                return ResponseEntity.ok(updatedLoan);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/addLoan")
public ResponseEntity<LoanModel> addLoan(@RequestBody LoanModel loanDetails) {
    LoanModel newLoan = loanService.saveOrUpdateLoan(loanDetails);
    return ResponseEntity.ok(newLoan);
}
}
