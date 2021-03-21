package com.schools.management.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student")
public class Student {

	@OneToOne
	@MapsId
    @JoinColumn(name = "user_id")
    private User userid;
	
	@Column(name = "admissionDate", nullable = false)
	private String admissionDate;
	
	@ManyToOne
	@JsonIgnore
	@PrimaryKeyJoinColumn
	private Guardian guardian;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP )
	@Column(name = "created_at", columnDefinition = "timestamp default current_timestamp")
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

	public Student() {}
	
	public Student(User userid, String admissionDate, Guardian guardian, Date createdAt, Date updatedAt) {
		super();
		this.userid = userid;
		this.admissionDate = admissionDate;
		this.guardian = guardian;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}

	public Guardian getGuardian() {
		return guardian;
	}

	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Student [userid=" + userid + ", admissionDate=" + admissionDate + ", guardian=" + guardian
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
