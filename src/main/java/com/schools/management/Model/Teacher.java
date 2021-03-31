package com.schools.management.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@MapsId
    @JoinColumn(name = "user_id")
    private User userid;
	
	@Column(name = "assignedStandard")
	private Standards assignedStandard;
	
	@Column(name = "assignedDivision")
	private Divisions assignedDivision;
	
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
	
	@OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
	@JsonIgnore
	@PrimaryKeyJoinColumn
	private List<SubjectTeacherAllocation> subjectsAllocated;

	public Teacher() {}

	public Teacher(Long id, User userid, Standards assignedStandard, Divisions assignedDivision, String qualifications,
			Date createdAt, Date updatedAt, List<SubjectTeacherAllocation> subjectsAllocated) {
		super();
		this.id = id;
		this.userid = userid;
		this.assignedStandard = assignedStandard;
		this.assignedDivision = assignedDivision;
		this.qualifications = qualifications;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.subjectsAllocated = subjectsAllocated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<SubjectTeacherAllocation> getSubjectsAllocated() {
		return subjectsAllocated;
	}

	public void setSubjectsAllocated(List<SubjectTeacherAllocation> subjectsAllocated) {
		this.subjectsAllocated = subjectsAllocated;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", userid=" + userid + ", assignedStandard=" + assignedStandard
				+ ", assignedDivision=" + assignedDivision + ", qualifications=" + qualifications + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", subjectsAllocated=" + subjectsAllocated + "]";
	}
	
	
	
	
	
}
