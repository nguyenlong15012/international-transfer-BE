package com.example.InternationalTransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InternationalTransfer.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	Transaction findByTransactionCode(String transactionCode);
}
