package com.example.InternationalTransfer.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.InternationalTransfer.dto.TransactionEmail;
import com.example.InternationalTransfer.model.Transaction;
import com.example.InternationalTransfer.service.TransactionService;
import org.springframework.http.ResponseEntity;

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
	
	@GetMapping("/trans-user")
	public List<TransactionEmail> getTransCode(){
		return tService.getTransByUser();
	}
	
	@GetMapping("/trans-by-code/{transCode}")
	public ResponseEntity<List<Transaction>> getTransByCode(@PathVariable String transCode){
		
	        List<Transaction> transactions = tService.getTransactionsByCode(transCode);
	        
	        if(transactions.isEmpty()) {
	        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        
	        return new ResponseEntity<>(transactions, HttpStatus.OK);
	    
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> updateTransaction(
			@RequestParam(value = "cif", required = false) String cif,
			@RequestParam(value = "createDate", required = false) String createDateStr,
			@RequestParam(value = "amount", required = false) Double amount
			){
		
		if (cif == null || createDateStr == null || amount == null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body("Missing required parameter(s): cif, createDate, amount.");
	    }
		
		Date createDate = null;
	    if (createDateStr != null && !createDateStr.isEmpty()) {
	        try {
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            createDate = new java.sql.Date(dateFormat.parse(createDateStr).getTime());
	        } catch (ParseException e) {
	            return ResponseEntity.badRequest().body("Invalid date format. Expected yyyy-MM-dd.");
	        }
	    }
		System.out.println("Received cif: " + cif);
	    System.out.println("Received createdDate: " + createDate);
	    System.out.println("Received amount: " + amount);
	    
		int updateRow = tService.UpdateTransaction(cif, createDate, amount);
		if(updateRow > 0) {
			return ResponseEntity.ok("update success " + updateRow + " transaction(s).");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No transactions found with the given amount.");
		}
	}
}

