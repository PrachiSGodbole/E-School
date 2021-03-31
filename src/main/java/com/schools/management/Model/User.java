package com.schools.management.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "phoneNumber", nullable = false)
	private String phoneNumber;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "userRoles", nullable = false)
	private UserRoles userRoles; 
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP )
	@Column(name = "created_at", columnDefinition = "timestamp default current_timestamp")
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "isEnabled", columnDefinition = "boolean default true", nullable = false)
	private Boolean isEnabled;
	
	@OneToOne(mappedBy = "userid", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Guardian guardian;
	
	@OneToOne(mappedBy = "userid", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Teacher teacher;
	
	@OneToOne(mappedBy = "userid", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Staff staff;
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	@JsonIgnore
	@PrimaryKeyJoinColumn
	private List<Achievements> achievements;

	public User() {
	}

	public User(Long id, String name, String email, String phoneNumber, String address, String password,
			UserRoles userRoles, Date createdAt, Date updatedAt, Boolean isEnabled, Guardian guardian, Teacher teacher,
			Staff staff, List<Achievements> achievements) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.password = password;
		this.userRoles = userRoles;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isEnabled = isEnabled;
		this.guardian = guardian;
		this.teacher = teacher;
		this.staff = staff;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRoles getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(UserRoles userRoles) {
		this.userRoles = userRoles;
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

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Guardian getGuardian() {
		return guardian;
	}

	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<Achievements> getAchievements() {
		return achievements;
	}

	public void setAchievements(List<Achievements> achievements) {
		this.achievements = achievements;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address="
				+ address + ", password=" + password + ", userRoles=" + userRoles + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", isEnabled=" + isEnabled + ", guardian=" + guardian + ", teacher="
				+ teacher + ", staff=" + staff + ", achievements=" + achievements + "]";
	}

	
	
}