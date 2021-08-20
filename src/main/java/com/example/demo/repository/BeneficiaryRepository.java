package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Beneficiary;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {

}
