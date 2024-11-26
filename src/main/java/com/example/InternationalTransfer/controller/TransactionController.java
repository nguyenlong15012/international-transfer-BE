package com.example.InternationalTransfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.InternationalTransfer.model.Transaction;
import com.example.InternationalTransfer.service.TransactionService;

@RestController
@RequestMapping("/api/trans")
public class TransactionController {
	
	@Autowired
	private TransactionService tService;
	
	@GetMapping
	public List<Transaction> getAllTrans(){
		return tService.getAllTransaction();
	}
	
	@GetMapping("/{id}")
	public Transaction getTransById(@PathVariable Long id) {
		return tService.findTransactionById(id);
	}
	
	@PostMapping
	public Transaction creTransaction(@RequestBody Transaction transaction) {
		return tService.saveTransaction(transaction);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTrans(@PathVariable Long id) {
		tService.deleteTrans(id);
	}
}
