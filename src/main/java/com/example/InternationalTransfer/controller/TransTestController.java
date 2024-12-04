package com.example.InternationalTransfer.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InternationalTransfer.model.TransTest;
import com.example.InternationalTransfer.service.TransTestService;

@CrossOrigin("*")
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "Content-Type")
//@CrossOrigin(origins = "*", allowedHeaders = "Content-Type")
@RestController
@RequestMapping("/transTest")
public class TransTestController {
	@Autowired
	private TransTestService trService;
	
	@GetMapping
	public Iterable<TransTest> getAll() {
		return trService.findAllTrans();
	}
	
	@PostMapping
    public TransTest createTrans(@RequestBody TransTest transTest) {
		Logger logger = LoggerFactory.getLogger(TransTestController.class);
		
		logger.info("Longnb save: " + transTest);
		logger.info("Currency: {}", transTest.getCurrency());
        return trService.saveTrans(transTest);
    }
	
	@PostMapping("/search")
	public ResponseEntity<List<TransTest>> SearchTrans(@RequestBody TransTest transTest){
		
		Logger logger = LoggerFactory.getLogger(TransTestController.class);
		
		logger.info("Longnb" + transTest);
		
		LocalDate fromDate = transTest.getFromDate();
		LocalDate toDate = transTest.getToDate();

	    
	    logger.info("fromDate = " + fromDate + " toDate = " + toDate);
		List<TransTest> result = trService.searchTrans(
				transTest.getTransactionCode(),
				transTest.getSender(),
				transTest.getReceiver(),
				transTest.getCif(),
				fromDate,
				toDate);
		if(result.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(result);
	}

}
