package com.schools.management.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ext_queries")
public class ExternalQueries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "message", nullable = false)
	private String message;
	
	@Column(name = "isActive", columnDefinition = "boolean default true", nullable = false)
	private Boolean isActive;

	public ExternalQueries() {	}

	public ExternalQueries(Long id, String name, String email, String message, Boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.message = message;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "ExternalQueries [id=" + id + ", name=" + name + ", email=" + email + ", message=" + message
				+ ", isActive=" + isActive + "]";
	}
	
	
}
