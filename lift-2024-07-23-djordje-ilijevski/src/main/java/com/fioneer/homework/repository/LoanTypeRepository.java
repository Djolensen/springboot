package com.fioneer.homework.repository;

import com.fioneer.homework.model.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanTypeRepository extends JpaRepository<LoanType, Integer> {

    public LoanType findByName(String name);
}
