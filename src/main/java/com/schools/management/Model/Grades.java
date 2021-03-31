package com.schools.management.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "grades")
public class Grades {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@MapsId
    @JoinColumn(name = "student_id")
    private Student studentId;
	
	@Column(name = "grade_json", columnDefinition = "json")
	private String gradeJson;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP )
	@Column(name = "created_at", columnDefinition = "timestamp default current_timestamp")
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

	@Transient
	private List<SubjectGradeJson> subjectGradeJson ;
	
	public Grades() {}

	public Grades(Long id, Student studentId, String gradeJson, Date createdAt, Date updatedAt,
			List<SubjectGradeJson> subjectGradeJson) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.gradeJson = gradeJson;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.subjectGradeJson = subjectGradeJson;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}

	public String getGradeJson() {
		return gradeJson;
	}

	public void setGradeJson(String gradeJson) {
		this.gradeJson = gradeJson;
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

	public List<SubjectGradeJson> getSubjectGradeJson() {
		return subjectGradeJson;
	}

	public void setSubjectGradeJson(List<SubjectGradeJson> subjectGradeJson) {
		this.subjectGradeJson = subjectGradeJson;
	}

	@Override
	public String toString() {
		return "Grades [id=" + id + ", studentId=" + studentId + ", gradeJson=" + gradeJson + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", subjectGradeJson=" + subjectGradeJson + "]";
	}
	
	
	
}
