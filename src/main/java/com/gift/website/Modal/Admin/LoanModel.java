package com.gift.website.Modal.Admin;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loans")
public class LoanModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loanType;
    private Double loanAmount;
    private Double interestRate;
    private Integer loanTenure;
    private String eligibilityCriteria;
    private String feesAndCharges;
    private String documentationRequirements;
    private String disbursementDetails;
    private String supportAndServices;
    private String termsAndConditions;
    private String riskAssessment;
}
