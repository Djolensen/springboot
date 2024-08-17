package com.fioneer.homework.dto;

import java.util.List;


public class LoanTypeDto {

    private int durationOfAllSteps;
    private List<String> stepNames;
    private String loanTypeName;

    public LoanTypeDto() {
    }

    public LoanTypeDto(int duration, List<String> stepNames, String loanTypeName) {
        this.durationOfAllSteps = durationOfAllSteps;
        this.stepNames = stepNames;
        this.loanTypeName = loanTypeName;
    }

    public int getDurationOfAllSteps() {
        return durationOfAllSteps;
    }
    public void setDurationOfAllSteps(int durationOfAllSteps) {
        this.durationOfAllSteps = durationOfAllSteps;
    }

    public List<String> getStepNames() {
        return stepNames;
    }
    public void setStepNames(List<String> stepNames) {
        this.stepNames = stepNames;
    }

    public String getLoanTypeName() {
        return loanTypeName;
    }
    public void setLoanTypeName(String loanTypeName) {
        this.loanTypeName = loanTypeName;
    }
}

