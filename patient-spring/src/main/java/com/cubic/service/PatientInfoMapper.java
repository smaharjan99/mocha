package com.cubic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cubic.entity.PatientInfoEntity;
import com.cubic.rest.vo.PatientInfo;

@Component
public class PatientInfoMapper {

	public PatientInfo mapToPatientInfo(final PatientInfoEntity entity) {
		PatientInfo result = new PatientInfo();
		result.setFirstName(entity.getFirstName());
		result.setLastName(entity.getLastName());
		result.setDob(entity.getDob());
		result.setContact(entity.getContact());
		result.setGender(entity.getGender());
		result.setSsn(entity.getSsn());
		result.setPatientId(entity.getPatientId());
		result.setPrefContact(entity.getPrefContact());
		return result;
	}

	public PatientInfoEntity mapToPatientInfoEntity(final PatientInfoEntity entity, final PatientInfo patientInfo) {

		entity.setFirstName(patientInfo.getFirstName());
		entity.setLastName(patientInfo.getLastName());
		entity.setDob(patientInfo.getDob());
		entity.setContact(patientInfo.getContact());
		entity.setGender(patientInfo.getGender());
		entity.setSsn(patientInfo.getSsn());
		entity.setPatientId(patientInfo.getPatientId());
		entity.setPrefContact(patientInfo.getPrefContact());
		return entity;
	}

	public List<PatientInfo> mapToPatientInfoList(final List<PatientInfoEntity> entities) {
		List<PatientInfo> results = new ArrayList<PatientInfo>();
		if (entities != null && !entities.isEmpty()) {
			for (PatientInfoEntity entity : entities) {
				results.add(mapToPatientInfo(entity));
			}
		}
		return results;

	}
}
