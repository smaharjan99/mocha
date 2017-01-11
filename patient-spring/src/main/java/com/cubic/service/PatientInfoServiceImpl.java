package com.cubic.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cubic.entity.PatientAddressEntity;
import com.cubic.entity.PatientAllergyEntity;
import com.cubic.entity.PatientInfoEntity;
import com.cubic.repo.PatientInfoRepo;
import com.cubic.rest.vo.PatientAddress;
import com.cubic.rest.vo.PatientAllergy;
import com.cubic.rest.vo.PatientInfo;
import com.cubic.rest.vo.Status;

@Service
@Transactional
public class PatientInfoServiceImpl implements PatientInfoService {

	@Autowired
	private PatientInfoRepo repo;

	@Autowired
	private PatientInfoMapper mapper;

	@Autowired
	private PatientAddressService addr;

	@Autowired
	private PatientAllergyService allg;

	DateFormat dateType = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();

	public String createPatientInfo(final PatientInfo patientInfo) {
		PatientInfoEntity entity = mapper.mapToPatientInfoEntity(new PatientInfoEntity(), patientInfo);
		entity.setId(UUID.randomUUID().toString());
		Long patientId = repo.getPatienId();
		entity.setPatientId(patientId);

		if (patientInfo.getActivate() == Status.ACTIVE) {
			entity.setActivatedDate(dateType.format(date));
		} else {
			entity.setDeactivatedDate(dateType.format(date));
		}
		entity.setCreatedDate(dateType.format(date));

		List<PatientAddress> address = patientInfo.getPatientAddress();
		List<PatientAddressEntity> addressList = addr.createPatientAddress(address);
		for (PatientAddressEntity add : addressList) {
			entity.getAddressList().add(add);
			add.setPatientAddressId(entity);
		}

		List<PatientAllergy> allergy = patientInfo.getPatientAllergy();
		List<PatientAllergyEntity> allergyList = allg.createPatientAllergy(allergy);
		for (PatientAllergyEntity all : allergyList) {
			entity.getAllergyList().add(all);
			all.setPatientAllergyId(entity);
		}
		entity = repo.save(entity);
		return entity.getId();
	}

	public PatientInfo findPatientInfo(final String id) {
		PatientInfoEntity entity = repo.findOne(new String(id));
		return mapper.mapToPatientInfo(entity);
	}

	public void modifyPatientInfo(PatientInfo patientInfo) {
		PatientInfoEntity entity = repo.findOne(new String(patientInfo.getId()));
		entity = mapper.mapToPatientInfoEntity(entity, patientInfo);
		if (patientInfo.getActivate() == Status.ACTIVE) {
			entity.setActivatedDate(dateType.format(date));
		} else {
			entity.setDeactivatedDate(dateType.format(date));
		}
		entity.setUpdatedDate(dateType.format(date));
		entity = repo.save(entity);
	}

	public List<PatientInfo> searchPatientInfo(String firstName, String lastName) {
		firstName = StringUtils.isEmpty(firstName) ? "%" : firstName.trim() + "%";
		lastName = StringUtils.isEmpty(lastName) ? "%" : lastName.trim() + "%";
		List<PatientInfoEntity> results = repo.searchPatientInfo(firstName, lastName);
		return mapper.mapToPatientInfoList(results);
	}

}
