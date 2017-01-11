package com.cubic.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.entity.PatientAllergyEntity;
import com.cubic.repo.PatientAllergyRepo;
import com.cubic.rest.vo.PatientAllergy;
import com.cubic.rest.vo.Status;

@Service
@Transactional
public class PatientAllergyServiceImpl implements PatientAllergyService {

	@Autowired
	private PatientAllergyRepo repo;

	@Autowired
	private PatientAllergyMapper mapper;

	DateFormat dateType = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();

	public List<PatientAllergyEntity> createPatientAllergy(List<PatientAllergy> patientAllergy) {
		List<PatientAllergyEntity> allergyList = new ArrayList<PatientAllergyEntity>();
		for (PatientAllergy algr : patientAllergy) {
			PatientAllergyEntity entity = mapper.mapToPatientAllergyEntity(new PatientAllergyEntity(), algr);
			entity.setAllergyId(UUID.randomUUID().toString());

			if (algr.getActivate() == Status.ACTIVE) {
				entity.setActivatedDate(dateType.format(date));
			} else {
				entity.setDeactivatedDate(dateType.format(date));
			}
			allergyList.add(entity);
		}
		return allergyList;
	}

	public void modifyPatientAllergy(PatientAllergy patientAllergy) {
		PatientAllergyEntity entity = repo.findOne(new String(patientAllergy.getAllergyId()));
		entity = mapper.mapToPatientAllergyEntity(entity, patientAllergy);

		if (patientAllergy.getActivate() == Status.ACTIVE) {
			entity.setActivatedDate(dateType.format(date));
		} else {
			entity.setDeactivatedDate(dateType.format(date));
		}
		entity = repo.save(entity);
	}

	public List<PatientAllergy> findPatientAllergy(List<PatientAllergyEntity> patientAllergy) {
		List<PatientAllergy> allergyList = new ArrayList<PatientAllergy>();
		for (PatientAllergyEntity algr : patientAllergy) {
			allergyList.add(mapper.mapToPatientAllergy(algr));
		}
		return allergyList;
	}

}
