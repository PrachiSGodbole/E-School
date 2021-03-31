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
import javax.persistence.ManyToOne;
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
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@OneToOne
//	@MapsId
//    @JoinColumn(name = "user_id")
//    private User userid;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "admissionDate", nullable = false)
	private String admissionDate;
	
	@Column(name = "standard", nullable = false)
	private Standards standard;
	
	@Column(name = "division", nullable = false)
	private Divisions division;
	
	@OneToOne(mappedBy = "studentId", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Grades grades;

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
	
	@OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL)
	@JsonIgnore
	@PrimaryKeyJoinColumn
	private List<Achievements> achievements;

	public Student() {}

	public Student(Long id, String name, String admissionDate, Standards standard, Divisions division, Grades grades,
			Guardian guardian, Date createdAt, Date updatedAt, List<Achievements> achievements) {
		super();
		this.id = id;
		this.name = name;
		this.admissionDate = admissionDate;
		this.standard = standard;
		this.division = division;
		this.grades = grades;
		this.guardian = guardian;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.achievements = achievements;
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

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
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

	public Grades getGrades() {
		return grades;
	}

	public void setGrades(Grades grades) {
		this.grades = grades;
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

	public List<Achievements> getAchievements() {
		return achievements;
	}

	public void setAchievements(List<Achievements> achievements) {
		this.achievements = achievements;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", admissionDate=" + admissionDate + ", standard=" + standard
				+ ", division=" + division + ", grades=" + grades + ", guardian=" + guardian + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", achievements=" + achievements + "]";
	}

	
	
	
}
