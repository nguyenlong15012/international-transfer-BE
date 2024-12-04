package com.example.InternationalTransfer.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.InternationalTransfer.model.TransTest;
import com.example.InternationalTransfer.repository.TransTestRespository;

@Service
public class TransTestService {
	@Autowired
	private TransTestRespository testRespository;
	
	//Iterable là cha của List, Set, Queue, Stream
	public Iterable<TransTest> findAllTrans(){
		return testRespository.findAll();
	}
	
	//Optional thay vì trả null, sẽ trả về Optional có giá trị hoặc rỗng (nếu không có giá trị)
	public Optional<TransTest> findTransById(Long id){
		return testRespository.findById(id);
	}
	
	public TransTest saveTrans(TransTest transTest) {
		return testRespository.save(transTest);
	}
	
	public void deleteTransById(Long id) {
		testRespository.deleteById(id);
	}
	
	public List<TransTest> searchTrans(String transactionCode, String sender, String receiver, String cif, LocalDate fromDate, LocalDate toDate) {
//	    if (transTest.getFromDate() == null && transTest.getToDate() == null) {
//	        return testRespository.findAll(); // Trả về tất cả nếu không có khoảng ngày
//	    }
	    return testRespository.searchTransTest(transactionCode, sender, receiver, cif, fromDate, toDate);
	}
}
