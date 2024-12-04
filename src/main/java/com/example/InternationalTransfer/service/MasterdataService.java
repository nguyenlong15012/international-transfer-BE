package com.example.InternationalTransfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.example.InternationalTransfer.model.Masterdata;
import com.example.InternationalTransfer.repository.MasterdataRepository;

@Service
public class MasterdataService {
	@Autowired
	private MasterdataRepository dataRepository;
	
	public List<Masterdata> getAllMasterdata(){
		return dataRepository.findAll();
	}
	
	public Masterdata getMasterdataById(Long id) {
		return dataRepository.findById(id).orElse(null);
	}
	
	public Masterdata saveMasterdata(Masterdata masterdata) {
		return dataRepository.save(masterdata);
	}
	
	public void deleteMasterdata (Long id) {
		dataRepository.deleteById(id);
	}
}
