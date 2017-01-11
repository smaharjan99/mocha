package com.cubic.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cubic.entity.PatientAddressEntity;
import com.cubic.entity.PatientAllergyEntity;
import com.cubic.entity.PatientInfoEntity;
import com.cubic.repo.PatientInfoRepo;
import com.cubic.rest.vo.PatientAddress;
import com.cubic.rest.vo.PatientAllergy;
import com.cubic.rest.vo.PatientData;
import com.cubic.rest.vo.PatientInfo;

@Service
@Transactional
public class PatientInfoServiceImpl implements PatientInfoService {

	@Autowired
	private PatientInfoRepo repo;

	@Autowired
	private PatientInfoMapper mapper;

	@Override
	public PatientInfoEntity createPatientInfo(PatientInfo patientInfo) {
		PatientInfoEntity entity = mapper.mapToPatientInfoEntity(new PatientInfoEntity(), patientInfo);
		entity.setId(UUID.randomUUID().toString());

		// Long patientId = repo.getPatienId();
		// entity.setPatientId(patientId);
		return entity;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public PatientInfoEntity findPatientInfo(PatientData patientData, String id) {
		PatientInfoEntity entity = repo.findOne(id);
		PatientInfo info = mapper.mapToPatientInfo(entity);
		patientData.setPatientInfo(info);
		return entity;
	}

	@Override
	public void modifyPatientInfo(PatientInfo patientInfo) {
		PatientInfoEntity entity = repo.findOne(new String(patientInfo.getId()));
		entity = mapper.mapToPatientInfoEntity(entity, patientInfo);
		entity = repo.save(entity);
	}

	@Override
	public List<PatientInfo> searchPatient(String firstName, String lastName) {
		firstName = StringUtils.isEmpty(firstName) ? "%" : firstName.trim() + "%";
		lastName = StringUtils.isEmpty(lastName) ? "%" : lastName.trim() + "%";
		List<PatientInfoEntity> results = repo.searchPatient(firstName, lastName);
		return mapper.mapToPatientInfoList(results);
	}

}
