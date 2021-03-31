package com.schools.management.Model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SubjectGradeJson {

	@JsonProperty
	private Standards standard;
	
	@JsonProperty
	private Divisions division;
	
	@JsonProperty
	private Long percentage;
	
	@JsonProperty
	private String grade;
	
	@JsonProperty
	private Long teacherId;
	
	private Map<Subjects, Object> detailGrades = new HashMap<>();

	public SubjectGradeJson() {	}

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

	public Long getPercentage() {
		return percentage;
	}

	public void setPercentage(Long percentage) {
		this.percentage = percentage;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Map<Subjects, Object> getOptional() {
		return detailGrades;
	}

	public void setOptional(Map<Subjects, Object> optional) {
		this.detailGrades = optional;
	}
	
	@JsonAnySetter
	public void addOptional(Subjects name, Object value) {
		detailGrades.put(name, value);
	}
	@JsonAnyGetter
	public Object getOptional(Subjects name) {
		return detailGrades.get(name);
	}
	
}
