package com.schools.management.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "staff")
public class Staff {

	@OneToOne
	@MapsId
    @JoinColumn(name = "user_id")
    private User userid;
	
	@Column(name = "department", nullable = false)
	private String department;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP )
	@Column(name = "created_at", columnDefinition = "timestamp default current_timestamp")
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

	public Staff() {}
	
	public Staff(User userid, String department, Date createdAt, Date updatedAt) {
		super();
		this.userid = userid;
		this.department = department;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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
		return "Staff [userid=" + userid + ", department=" + department + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
	
	
	
	
}
