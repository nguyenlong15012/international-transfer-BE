package com.example.InternationalTransfer.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "TransTest", schema = "longnb")
public class TransTest {
	@Id
	@Column(name = "transactionCode", unique = true)
	//@JsonProperty("transactionId")
	private String transactionCode;
	
	@Column()
	private String sender;
	
	@Column()
	private String receiver;
	
	@Column(name = "cif")
	private String cif;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "currency")
	private String currency;
	
	@Column()
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fromDate;
	
	@Column()
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate toDate;
	
	@Column()
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate createDate;

	@Column()
	private LocalDate holiday;

	@Override
	public String toString() {
		return "TransTest [transactionCode=" + transactionCode + ", sender=" + sender + ", receiver=" + receiver
				+ ", cif=" + cif + ", amount=" + amount + ", currency=" + currency + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", createDate=" + createDate + ", holiday=" + holiday + "]";
	}

	public TransTest(String transactionCode, String sender, String receiver, String cif, Double amount, String currency,
			LocalDate fromDate, LocalDate toDate, LocalDate createDate, LocalDate holiday) {
		super();
		this.transactionCode = transactionCode;
		this.sender = sender;
		this.receiver = receiver;
		this.cif = cif;
		this.amount = amount;
		this.currency = currency;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.createDate = createDate;
		this.holiday = holiday;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getCif() {
		return cif;
	}
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getHoliday() {
		return holiday;
	}

	public void setHoliday(LocalDate holiday) {
		this.holiday = holiday;
	}
}
