package com.schools.management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.schools.management.Model.Grades;
import com.schools.management.Model.SubjectGradeJson;
import com.schools.management.Repository.GradesRepository;

@Service
public class GradesService {

	@Autowired
	private GradesRepository gradesRepository;
	
	public Grades getGrades(Long id) {
		Grades grades = gradesRepository.findById(id).orElse(null);
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			TypeReference<List<SubjectGradeJson>> typeReference = new TypeReference<List<SubjectGradeJson>>(){};
			List<SubjectGradeJson> data = objectMapper.readValue(grades.getGradeJson(), typeReference);
			grades.setSubjectGradeJson(data);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return grades;
	}
	
}
