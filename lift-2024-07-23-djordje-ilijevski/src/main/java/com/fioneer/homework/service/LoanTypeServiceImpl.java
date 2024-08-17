package com.fioneer.homework.service;

import com.fioneer.homework.dto.LoanTypeDto;
import com.fioneer.homework.model.LoanType;
import com.fioneer.homework.model.LoanTypeStep;
import com.fioneer.homework.repository.LoanTypeRepository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class LoanTypeServiceImpl implements LoanTypeService {

    private LoanTypeRepository loanTypeRepository;


    public LoanTypeServiceImpl(LoanTypeRepository loanTypeRepository) {
        this.loanTypeRepository = loanTypeRepository;
    }

    /**
     * @param loanType
     * @return
     */
    @Override
    public LoanType addLoanType(LoanType loanType) {
        return loanTypeRepository.save(loanType);
    }

    /**
     * @param name
     * @return
     */
    @Override
    public LoanTypeDto findLoanTypeByName(String name) {

        LoanTypeDto loanTypeDto = new LoanTypeDto();

        // LoanType detail - just a name
        LoanType loanType = loanTypeRepository.findByName(name);

        log.info("METHOD findLoanTypeByName - loanType name: " + loanType.getName());

        // List of steps (names) and Calculate duration of all steps
        List<LoanTypeStep> loanTypeSteps = loanType.getLoanTypeSteps();

        log.info("METHOD findLoanTypeByName - loanTypeSteps size: " + loanType.getLoanTypeSteps().size());

        List<String> stepNames = new ArrayList<>();
        int totalNoOfDays = 0;

        for (LoanTypeStep step : loanTypeSteps) {
            stepNames.add(step.getStepName());
            totalNoOfDays += step.getNoOfDays();
        }

        log.info("METHOD findLoanTypeByName - setDurationOfAllSteps: " + totalNoOfDays);

        loanTypeDto.setLoanTypeName(loanType.getName());
        loanTypeDto.setStepNames(stepNames);
        loanTypeDto.setDurationOfAllSteps(totalNoOfDays);

     //   loanTypeDto = new LoanTypeDto(totalNoOfDays, stepNames, loanType.getName());

        stepNames.forEach(step -> log.info("METHOD findLoanTypeByName - Step name: " + step));


        return loanTypeDto;
    }

    @Override
    public void deleteLoanTypeByName(String name) {
        LoanType loanType = loanTypeRepository.findByName(name);
        loanTypeRepository.deleteById(loanType.getId());
    }

    @Override
    public List<LoanType> findAllLoanTypes() {
        return loanTypeRepository.findAll();
    }

}