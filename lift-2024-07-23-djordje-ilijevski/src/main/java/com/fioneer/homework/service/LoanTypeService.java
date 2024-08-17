package com.fioneer.homework.service;

import com.fioneer.homework.dto.LoanTypeDto;
import com.fioneer.homework.model.LoanType;

import java.util.List;

public interface LoanTypeService {

    public LoanType addLoanType(LoanType loanType);

    public LoanTypeDto findLoanTypeByName(String name);

    public void deleteLoanTypeByName(String name);

    public List<LoanType> findAllLoanTypes();

}
