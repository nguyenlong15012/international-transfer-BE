package com.example.InternationalTransfer.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.InternationalTransfer.model.TransTest;

@Repository
public interface TransTestRespository extends JpaRepository<TransTest, Long> {
	
	@Query("SELECT t FROM TransTest t " +
		       "WHERE (:transactionCode IS NULL OR LOWER(t.transactionCode) LIKE LOWER(CONCAT('%', :transactionCode, '%'))) " +
		       "AND (:sender IS NULL OR LOWER(t.sender) LIKE LOWER(CONCAT('%', :sender, '%'))) " +
		       "AND (:receiver IS NULL OR LOWER(t.receiver) LIKE LOWER(CONCAT('%', :receiver, '%'))) " +
		       "AND (:cif IS NULL OR LOWER(t.cif) LIKE LOWER(CONCAT('%', :cif, '%'))) " +
		       "AND ( " +
		       "     (:fromDate IS NULL OR t.createDate >= :fromDate) " +
		       "     AND (:toDate IS NULL OR t.createDate <= :toDate) " +
		       ")")
		List<TransTest> searchTransTest(
		    @Param("transactionCode") String transactionCode,
		    @Param("sender") String sender,
		    @Param("receiver") String receiver,
		    @Param("cif") String cif,
		    @Param("fromDate") LocalDate fromDate,
		    @Param("toDate") LocalDate toDate);

	
//	@Query("SELECT t FROM TransTest t " +
//		       "WHERE (:transactionCode IS NULL OR LOWER(t.transactionCode) LIKE LOWER(CONCAT('%', :transactionCode, '%'))) " +
//		       "AND (:sender IS NULL OR LOWER(t.sender) LIKE LOWER(CONCAT('%', :sender, '%'))) " +
//		       "AND (:receiver IS NULL OR LOWER(t.receiver) LIKE LOWER(CONCAT('%', :receiver, '%'))) " +
//		       "AND (:cif IS NULL OR LOWER(t.cif) LIKE LOWER(CONCAT('%', :cif, '%'))) " +
//		       "AND (" +
//		       "     (:fromDate IS NULL AND :toDate IS NULL) " +
//		       "     OR (:fromDate IS NOT NULL AND t.createDate >= :fromDate) " +
//		       "     OR (:toDate IS NOT NULL AND t.createDate <= :toDate) " +
//		       "     OR (t.createDate BETWEEN :fromDate AND :toDate)" +
//		       ")")
//		List<TransTest> searchTransTest(
//		    @Param("transactionCode") String transactionCode,
//		    @Param("sender") String sender,
//		    @Param("receiver") String receiver,
//		    @Param("cif") String cif,
//		    @Param("fromDate") Date fromDate,
//		    @Param("toDate") Date toDate);
}

