package com.cubic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.entity.PatientAddressEntity;
import com.cubic.entity.PatientAllergyEntity;
import com.cubic.entity.PatientInfoEntity;
import com.cubic.repo.PatientInfoRepo;
import com.cubic.rest.vo.PatientAddress;
import com.cubic.rest.vo.PatientAllergy;
import com.cubic.rest.vo.PatientData;
import com.cubic.rest.vo.PatientInfo;
import com.cubic.service.PatientInfoService;
import com.cubic.service.PatientAddressService;
import com.cubic.service.PatientAllergyService;
import com.cubic.service.PatientDataService;

@Service
@Transactional
public class PatientDataServiceImpl implements PatientDataService {

	@Autowired
	private PatientInfoRepo repo;

	@Autowired
	private PatientInfoService info;

	@Autowired
	private PatientAddressService addr;

	@Autowired
	private PatientAllergyService allg;

	public String createPatientData(PatientData patientData) {
		PatientInfo patientInfo = patientData.getPatientInfo();
		PatientInfoEntity patientEntity = info.createPatientInfo(patientInfo);

		List<PatientAddress> patientAddress = patientData.getPatientAddress();
		List<PatientAddressEntity> address = addr.createPatientAddress(patientAddress);
		for (PatientAddressEntity add : address) {
			patientEntity.getAddressList().add(add);
			add.setPatientAddressId(patientEntity);
		}

		List<PatientAllergy> patientAllergy = patientData.getPatientAllergy();
		List<PatientAllergyEntity> allergy = allg.createPatientAllergy(patientAllergy);
		for (PatientAllergyEntity all : allergy) {
			patientEntity.getAllergyList().add(all);
			all.setPatientAllergyId(patientEntity);
		}

		patientEntity = repo.save(patientEntity);
		return patientEntity.getId();
	}

	@Override
	public void modifyPatientData(PatientData patientData) {
		// TODO Auto-generated method stub

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public PatientData findPatientData(String id) {
		PatientData patientData = new PatientData();

		PatientInfoEntity entity = info.findPatientInfo(patientData, id);

		List<PatientAddress> patientAddress = addr.findPatientAddress(entity.getAddressList());
		patientData.setPatientAddress(patientAddress);

		List<PatientAllergy> patientAllergy = allg.findPatientAllergy(entity.getAllergyList());
		patientData.setPatientAllergy(patientAllergy);

		return patientData;
	}

}
