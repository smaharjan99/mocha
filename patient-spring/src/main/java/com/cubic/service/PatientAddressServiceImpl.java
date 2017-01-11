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

import com.cubic.entity.PatientAddressEntity;
import com.cubic.repo.PatientAddressRepo;
import com.cubic.rest.vo.PatientAddress;
import com.cubic.rest.vo.Status;

@Service
@Transactional
public class PatientAddressServiceImpl implements PatientAddressService {

	@Autowired
	private PatientAddressRepo repo;

	@Autowired
	private PatientAddressMapper mapper;

	DateFormat dateType = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();

	public List<PatientAddressEntity> createPatientAddress(List<PatientAddress> patientAddress) {
		List<PatientAddressEntity> addressList = new ArrayList<PatientAddressEntity>();
		for (PatientAddress addr : patientAddress) {
			PatientAddressEntity entity = mapper.mapToPatientAddressEntity(new PatientAddressEntity(), addr);
			entity.setAddressId(UUID.randomUUID().toString());

			if (addr.getActivate() == Status.ACTIVE) {
				entity.setActivatedDate(dateType.format(date));
			} else {
				entity.setDeactivatedDate(dateType.format(date));
			}
			addressList.add(entity);
		}
		return addressList;
	}

	public void modifyPatientAddress(PatientAddress patientAddress) {
		PatientAddressEntity entity = repo.findOne(new String(patientAddress.getAddressId()));
		entity = mapper.mapToPatientAddressEntity(entity, patientAddress);
		if (patientAddress.getActivate() == Status.ACTIVE) {
			entity.setActivatedDate(dateType.format(date));
		} else {
			entity.setDeactivatedDate(dateType.format(date));
		}
		entity = repo.save(entity);
	}

	public List<PatientAddress> findPatientAddress(List<PatientAddressEntity> patientAddress) {
		List<PatientAddress> addressList = new ArrayList<PatientAddress>();
		for (PatientAddressEntity addr : patientAddress) {
			addressList.add(mapper.mapToPatientAddress(addr));
		}
		return addressList;
	}

}
