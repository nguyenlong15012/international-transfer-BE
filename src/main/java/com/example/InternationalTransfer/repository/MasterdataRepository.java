package com.example.InternationalTransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import com.example.InternationalTransfer.model.Masterdata;

@Repository
public interface MasterdataRepository extends JpaRepository<Masterdata, Long>{
	
}
