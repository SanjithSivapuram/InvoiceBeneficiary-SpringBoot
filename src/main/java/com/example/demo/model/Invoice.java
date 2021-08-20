package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double amount;
	private LocalDate applyDate;

	@OneToOne
	private Beneficiary beneficiary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(LocalDate applyDate) {
		this.applyDate = applyDate;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", amount=" + amount + ", applyDate=" + applyDate + ", beneficiary=" + beneficiary
				+ "]";
	}

}
