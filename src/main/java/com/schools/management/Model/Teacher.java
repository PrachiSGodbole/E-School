package com.schools.management.Model;

import java.util.Date;
import java.util.List;

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
@Table(name = "teacher")
public class Teacher {

	@OneToOne
	@MapsId
    @JoinColumn(name = "user_id")
    private User userid;
	
	@Column(name = "assignedStandard")
	private Standards assignedStandard;
	
	@Column(name = "assignedDivision")
	private Divisions assignedDivision;
	
	@Column(name = "subjects")
	private List<Subjects> subjects;
	
	@Column(name = "qualifications", nullable = false)
	private String qualifications;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP )
	@Column(name = "created_at", columnDefinition = "timestamp default current_timestamp")
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

	public Teacher() {}
	
	public Teacher(User userid, Standards assignedStandard, Divisions assignedDivision, List<Subjects> subjects,
			String qualifications, Date createdAt, Date updatedAt) {
		super();
		this.userid = userid;
		this.assignedStandard = assignedStandard;
		this.assignedDivision = assignedDivision;
		this.subjects = subjects;
		this.qualifications = qualifications;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public Standards getAssignedStandard() {
		return assignedStandard;
	}

	public void setAssignedStandard(Standards assignedStandard) {
		this.assignedStandard = assignedStandard;
	}

	public Divisions getAssignedDivision() {
		return assignedDivision;
	}

	public void setAssignedDivision(Divisions assignedDivision) {
		this.assignedDivision = assignedDivision;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
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
		return "Teacher [userid=" + userid + ", assignedStandard=" + assignedStandard + ", assignedDivision="
				+ assignedDivision + ", subjects=" + subjects + ", qualifications=" + qualifications + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
	
}
