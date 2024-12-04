package com.example.InternationalTransfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.InternationalTransfer.model.Masterdata;
import com.example.InternationalTransfer.service.MasterdataService;

@RestController
//@CrossOrigin("*")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/masterdata")
public class MasterdataController {
	@Autowired
	private MasterdataService mService;
	
	@GetMapping
	public List<Masterdata> getAllMasterdata(){
		return mService.getAllMasterdata();
	}
	
	@GetMapping("/{id}")
	public Masterdata getMasterById(@PathVariable Long id) {
		return mService.getMasterdataById(id);
	}
	
	@PostMapping
	public Masterdata creTransaction(@RequestBody Masterdata masterdata) {
		return mService.saveMasterdata(masterdata);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMaster(@PathVariable Long id) {
		mService.deleteMasterdata(id);
	}
	
}
