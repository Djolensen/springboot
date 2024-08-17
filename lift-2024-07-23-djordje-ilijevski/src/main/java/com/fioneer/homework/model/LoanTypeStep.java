package com.fioneer.homework.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class LoanTypeStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String stepName;
    private String orderName;
    private int noOfDays;

    @ManyToOne
    @JoinColumn(name = "loan_type_id")
    private LoanType loanType;

    public LoanTypeStep() {
    }

    public LoanTypeStep(String stepName, String orderName, int noOfDays, LoanType loanType) {
        this.stepName = stepName;
        this.orderName = orderName;
        this.noOfDays = noOfDays;
        this.loanType = loanType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    @JsonBackReference
    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

}

