package com.fioneer.homework.controller;


import com.fioneer.homework.dto.LoanTypeDto;
import com.fioneer.homework.model.LoanType;
import com.fioneer.homework.service.LoanTypeServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class LoanTypeController {

    private LoanTypeServiceImpl loanTypeServiceImpl;

    public LoanTypeController(LoanTypeServiceImpl loanTypeServiceImpl) {
        this.loanTypeServiceImpl = loanTypeServiceImpl;
    }

    /**
     * Loan Type creation.
     *
     * @param loanType
     * @return
     */
    @PostMapping("/loantypes")
    public LoanType createLoanType(@RequestBody LoanType loanType) {
        return loanTypeServiceImpl.addLoanType(loanType);
    }


    /**
     * Find Loan Type by name.
     *
     * @param name
     * @return LoanTypeDto
     */
    @GetMapping("/loantypes/name/{name}")
    public LoanTypeDto getLoanTypeByName(@PathVariable String name) {
        return loanTypeServiceImpl.findLoanTypeByName(name);
    }


    /**
     * Delete Loan Type by name
     *
     * @param name
     */
    @DeleteMapping("/loantypes/name/{name}")
    public void deleteLoanTypeByName(@PathVariable String name) {
        loanTypeServiceImpl.deleteLoanTypeByName(name);
    }


// ---------------------------------Added - not required in the project req

    @Operation(summary = "Loan Types", description = "Get all loan types.")
    @GetMapping("/loantypes")
    public List<LoanType> getAllLoanTypes() {
        return loanTypeServiceImpl.findAllLoanTypes();
    }


//    @GetMapping("/loantypes/{id}")
//    public LoanType findLoanTypeById(@PathVariable Integer id) throws Exception {
//        return loanTypeRepository.findById(id)
//                .orElseThrow(() -> new Exception("No FT id: " + id));
//    }


//    @DeleteMapping("/loantypes/{id}")
//    public void deleteLoanType(@PathVariable Integer id) throws Exception {
//        LoanType loanType = loanTypeRepository.findById(id)
//                .orElseThrow(() -> new Exception("There is no Loan Type with id :" + id));
//
//        loanTypeRepository.deleteById(id);
//    }
//

//    //We have only name property to change
//    @PatchMapping("/loantypes/{id}")
//    public LoanType updateLoanType(@PathVariable Integer id, @RequestBody LoanType loanType) throws Exception {
//        LoanType updateLoanType = loanTypeRepository.findById(id)
//                .orElseThrow(() -> new Exception("There is no Loan Type with id :" + id));
//
//        if (loanType.getName() != null)
//            updateLoanType.setName(loanType.getName());
//        return loanTypeService.modifyLoanType(updateLoanType);
//    }

    //--------------------------------------------

}
