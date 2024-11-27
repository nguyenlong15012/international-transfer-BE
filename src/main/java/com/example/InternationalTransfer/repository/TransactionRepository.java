package com.example.InternationalTransfer.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.InternationalTransfer.dto.TransactionEmail;
import com.example.InternationalTransfer.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	Transaction findByTransactionCode(String transactionCode);
	
//	@Query(value = "SELECT trx.transaction_code AS transactionCode, us.email AS email from transaction trx JOIN users us on trx.creator = us.name", nativeQuery = true)
	@Query("SELECT new com.example.InternationalTransfer.dto.TransactionEmail(trx.transactionCode, us.email) " +
		       "FROM Transaction trx " +
		       "JOIN User us ON trx.creator = us.name")
		List<TransactionEmail> findTransByUser();
	
	
	@Query(value = "select * from longnb.transaction where transaction_code like concat('%',:transCode,'%')", nativeQuery = true)
	List<Transaction> findTransByTransCode(@Param("transCode") String transCode);
	
	@Modifying
	@Transactional
	@Query(value = "Update longnb.transaction set cif = :cif, create_date = :createDate where amount = :amount ", nativeQuery = true)
	int UpdateCifAndCreateDateByAmount(String cif, Date createDate, Double amount);
}

//@Query(value = "select * from post where status = 1 and title like CONCAT('%',:title,'%');", nativeQuery = true)
//Iterable<Post> findAllByTitleContaining(@Param("title") String title);
//Iterable<Transaction> findTransByUser();