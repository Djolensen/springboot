package com.fioneer.homework.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class LoanType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanType", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<LoanTypeStep> loanTypeSteps;

    public LoanType() {
    }

    public LoanType(Integer id, String name, List<LoanTypeStep> loanTypeSteps) {
        this.id = id;
        this.name = name;
        this.loanTypeSteps = loanTypeSteps;
    }

    public LoanType(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonManagedReference
    public List<LoanTypeStep> getLoanTypeSteps() {
        return loanTypeSteps;
    }

    public void setLoanTypeSteps(List<LoanTypeStep> loanTypeSteps) {
        this.loanTypeSteps = loanTypeSteps;
    }

    @Override
    public String toString() {
        return "LoanType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loanTypeSteps=" + loanTypeSteps +
                '}';
    }
}
