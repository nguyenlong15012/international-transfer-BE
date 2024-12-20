package com.example.InternationalTransfer.model;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "transaction", schema = "longnb") // Schema và tên bảng
public class Transaction {

    @Id
    @Column(name = "transactionCode", unique = true) // Tên cột khớp với database
    private String transactionCode;
    
    @Column(name = "xml", columnDefinition = "Text") 
    private String xml;

    @Column(name = "create_date", columnDefinition = "date")
    private Date createDate;
    
    @Column(name = "creator")
    private String creator;

    @Column(name = "cif", nullable = false)
    private String cif;

    @Column(name = "bytes", columnDefinition = "text")
    private String bytes;

    @Column(name = "process_id", length = 255)
    private String processId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "currency", length = 255)
    private String currency;

    @Column(name = "acc_status", length = 255)
    private String accStatus;

    @Column(name = "debt_status", length = 255)
    private String debtStatus;

    @Column(name = "debt_date", columnDefinition = "date")
    private Date debtDate;



	@Override
	public String toString() {
		return "Transaction [transactionCode=" + transactionCode + ", xml=" + xml + ", createDate=" + createDate
				+ ", creator=" + creator + ", cif=" + cif + ", bytes=" + bytes + ", processId=" + processId
				+ ", amount=" + amount + ", currency=" + currency + ", accStatus=" + accStatus + ", debtStatus="
				+ debtStatus + ", debtDate=" + debtDate + "]";
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	
	
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getBytes() {
		return bytes;
	}

	public void setBytes(String bytes) {
		this.bytes = bytes;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
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

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public String getDebtStatus() {
		return debtStatus;
	}

	public void setDebtStatus(String debtStatus) {
		this.debtStatus = debtStatus;
	}

	public Date getDebtDate() {
		return debtDate;
	}

	public void setDebtDate(Date debtDate) {
		this.debtDate = debtDate;
	}
	
	
}
	
	
	

    
