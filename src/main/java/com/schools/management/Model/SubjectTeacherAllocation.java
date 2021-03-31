package com.schools.management.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subject_teacher")
public class SubjectTeacherAllocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "standard", nullable = false)
	private Standards standard;
	
	@Column(name = "division",nullable = false)
	private Divisions division;
	
	@Column(name = "subject",nullable = false)
	private Subjects subject;
	
	@Column(name = "isElective", columnDefinition = "boolean default false", nullable = false)
	private Boolean isElective;
	
	@ManyToOne
	@JsonIgnore
	@PrimaryKeyJoinColumn
	private Teacher teacher;

	public SubjectTeacherAllocation() {	}

	public SubjectTeacherAllocation(Long id, Standards standard, Divisions division, Subjects subject,
			Boolean isElective, Teacher teacher) {
		super();
		this.id = id;
		this.standard = standard;
		this.division = division;
		this.subject = subject;
		this.isElective = isElective;
		this.teacher = teacher;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Standards getStandard() {
		return standard;
	}

	public void setStandard(Standards standard) {
		this.standard = standard;
	}

	public Divisions getDivision() {
		return division;
	}

	public void setDivision(Divisions division) {
		this.division = division;
	}

	public Subjects getSubject() {
		return subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}

	public Boolean getIsElective() {
		return isElective;
	}

	public void setIsElective(Boolean isElective) {
		this.isElective = isElective;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "SubjectTeacherAllocation [id=" + id + ", standard=" + standard + ", division=" + division + ", subject="
				+ subject + ", isElective=" + isElective + ", teacher=" + teacher + "]";
	}
	
	
	
}
