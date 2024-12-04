package com.example.InternationalTransfer.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Masterdata", schema = "longnb")
public class Masterdata {
	
	@Column(name = "group_code", length = 50, nullable = false)
	private String groupCode;
	
	@Id
	@Column(name = "code", length = 50, nullable = false)
	private String code;
	
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	@Column(name = "status", length = 255)
	private Boolean status;
	
	@Column(name = "creator", length = 255)
	private String creator;
	
	@Column(name = "created_at")
	private Date created_at;

	@Override
	public String toString() {
		return "Masterdata [groupCode=" + groupCode + ", code=" + code + ", name=" + name + ", status=" + status
				+ ", creator=" + creator + ", created_at=" + created_at + "]";
	}
	
	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
}
