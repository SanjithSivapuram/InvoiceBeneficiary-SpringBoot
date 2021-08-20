package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Invoice;
import com.example.demo.repository.BeneficiaryRepository;
import com.example.demo.repository.InvoiceRepository;

@RestController
@CrossOrigin(origins = "http://localhost:59279", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class InvoiceController {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private BeneficiaryRepository beneficiaryRepository;
	
	@PostMapping("/invoice/{bid}")
	public Invoice postInvoice(@PathVariable("bid") Long bid,@RequestBody Invoice invoice) {
		invoice.setBeneficiary(beneficiaryRepository.getById(bid));
		return invoiceRepository.save(invoice);
	}
	
	@GetMapping("/invoice")
	public List<Invoice> getAllInvoice(@RequestParam(name = "page",required = false,defaultValue = "0") Integer page
	,@RequestParam(name = "size",required = false,defaultValue = "10000") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return invoiceRepository.findAll(pageable).getContent();
	}
	
	@GetMapping("/invoice/{id}")
	public Invoice getOneInvoice(@PathVariable("id") Long id) {
		return invoiceRepository.getById(id);
	}
	
	@PutMapping("/invoice/edit/{id}/{bid}")
	public Invoice editInvoice(@PathVariable("id") Long id,@PathVariable("bid") Long bid,@RequestBody Invoice invoice) {
		Invoice invoiceDB = invoiceRepository.getById(id);
		invoiceDB.setAmount(invoice.getAmount());
		invoiceDB.setApplyDate(invoice.getApplyDate());
		invoiceDB.setBeneficiary(beneficiaryRepository.getById(bid));
		return invoiceRepository.save(invoiceDB);
	}
	
	@DeleteMapping("/invoice/delete/{id}")
	public void deleteInvoice(@PathVariable("id") Long id) {
		invoiceRepository.deleteById(id);
	}
}
