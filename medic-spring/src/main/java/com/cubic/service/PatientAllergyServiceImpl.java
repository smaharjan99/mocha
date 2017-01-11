package com.cubic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.entity.PatientAllergyEntity;
import com.cubic.repo.PatientAllergyRepo;
import com.cubic.rest.vo.PatientAllergy;

@Service
@Transactional
public class PatientAllergyServiceImpl implements PatientAllergyService {

	@Autowired
	private PatientAllergyRepo repo;

	@Autowired
	private PatientAllergyMapper mapper;

	@Override
	public List<PatientAllergyEntity> createPatientAllergy(List<PatientAllergy> patientAllergy) {
		List<PatientAllergyEntity> allergy = new ArrayList<PatientAllergyEntity>();
		for (PatientAllergy algr : patientAllergy) {
			PatientAllergyEntity entity = mapper.mapToPatientAllergyEntity(new PatientAllergyEntity(), algr);
			entity.setAllergyId(UUID.randomUUID().toString());
			allergy.add(entity);
		}
		return allergy;
	}

	@Override
	public void modifyPatientAllergy(PatientAllergy patientAllergy) {
		PatientAllergyEntity entity = repo.findOne(new String(patientAllergy.getAllergyId()));
		entity = mapper.mapToPatientAllergyEntity(entity, patientAllergy);
		entity = repo.save(entity);
	}

	@Override
	public List<PatientAllergy> findPatientAllergy(List<PatientAllergyEntity> patientAllergy) {
		List<PatientAllergy> allergyList = new ArrayList<PatientAllergy>();
		for (PatientAllergyEntity algr : patientAllergy) {
			allergyList.add(mapper.mapToPatientAllergy(algr));
		}
		return allergyList;
	}

}
