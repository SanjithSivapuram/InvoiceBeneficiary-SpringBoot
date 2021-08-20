package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Beneficiary;
import com.example.demo.repository.BeneficiaryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:59279", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class BeneficiaryController {
	
	@Autowired
	private BeneficiaryRepository beneficiaryRepository;
	
	@PostMapping("/beneficiary")
	public Beneficiary postBeneficiary(@RequestBody Beneficiary beneficiary) {
		return beneficiaryRepository.save(beneficiary);
	}
	
	@GetMapping("/beneficiary")
	public List<Beneficiary> getAllBeneficiaries() {
		return beneficiaryRepository.findAll();
	}
	
	@GetMapping("/beneficiary/{id}")
	public Beneficiary getOneBeneficiary(@PathVariable("id") Long id) {
		return beneficiaryRepository.getById(id);
	}
}
