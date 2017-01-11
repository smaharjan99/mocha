package com.cubic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.entity.PatientAddressEntity;
import com.cubic.repo.PatientAddressRepo;
import com.cubic.rest.vo.PatientAddress;

@Service
@Transactional
public class PatientAddressServiceImpl implements PatientAddressService {

	@Autowired
	private PatientAddressRepo repo;

	@Autowired
	private PatientAddressMapper mapper;

	@Override
	public List<PatientAddressEntity> createPatientAddress(List<PatientAddress> patientAddress) {
		List<PatientAddressEntity> address = new ArrayList<PatientAddressEntity>();
		for (PatientAddress addr : patientAddress) {
			PatientAddressEntity entity = mapper.mapToPatientAddressEntity(new PatientAddressEntity(), addr);
			entity.setAddressId(UUID.randomUUID().toString());
			address.add(entity);
		}
		return address;
	}

	@Override
	public void modifyPatientAddress(PatientAddress patientAddress) {
		PatientAddressEntity entity = repo.findOne(new String(patientAddress.getAddressId()));
		entity = mapper.mapToPatientAddressEntity(entity, patientAddress);
		entity = repo.save(entity);
	}

	@Override
	public List<PatientAddress> findPatientAddress(List<PatientAddressEntity> patientAddress) {
		List<PatientAddress> addressList = new ArrayList<PatientAddress>();
		for (PatientAddressEntity addr : patientAddress) {
			addressList.add(mapper.mapToPatientAddress(addr));
		}
		return addressList;
	}

}
