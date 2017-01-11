package com.cubic.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.rest.vo.PatientAddress;
import com.cubic.service.PatientAddressService;

@Path("/patient/address")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

@Service
public class PatientAddressRest {

	@Autowired
	private PatientAddressService pi;

	@PUT
	@Path("/modify")
	public Response modifyPatientAddress(final PatientAddress patientAddress) {
		pi.modifyPatientAddress(patientAddress);
		return Response.noContent().build();
	}

}
