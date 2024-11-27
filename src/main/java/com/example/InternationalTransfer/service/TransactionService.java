package com.example.InternationalTransfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.InternationalTransfer.dto.TransactionEmail;
import com.example.InternationalTransfer.model.Transaction;
import com.example.InternationalTransfer.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository tRepository;
	
	public List<Transaction> getAllTransaction(){
		return tRepository.findAll();
	}
	
	public Transaction findTransactionById(Long id) {
		return tRepository.findById(id).orElse(null);
	}
	
	public Transaction saveTransaction (Transaction transaction) {
		return tRepository.save(transaction);
	}
	
	public void deleteTrans (Long id) {
		tRepository.deleteById(id);
	}
	
	public List<TransactionEmail> getTransByUser() {
		return tRepository.findTransByUser();
	}
}
