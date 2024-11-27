package com.example.InternationalTransfer.dto;

public class TransactionEmail {
	public char charAt(int index) {
		return email.charAt(index);
	}
	private String transCode;
	private String email;
	@Override
	public String toString() {
		return "TransactionEmail [transCode=" + transCode + ", email=" + email + "]";
	}
	
	
	public TransactionEmail(String transCode, String email) {
		this.transCode = transCode;
		this.email = email;
	}


	public String getTransCode() {
		return transCode;
	}
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
