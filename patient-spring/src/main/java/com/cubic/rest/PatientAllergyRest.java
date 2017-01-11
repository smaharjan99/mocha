package com.cubic.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.rest.vo.PatientAllergy;
import com.cubic.service.PatientAllergyService;

@Path("/patient/allergies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

@Service
public class PatientAllergyRest {
	@Autowired
	private PatientAllergyService pi;

	@PUT
	@Path("/modify")
	public Response modifyPatientAllergy(final PatientAllergy patientAllergy) {
		pi.modifyPatientAllergy(patientAllergy);
		return Response.noContent().build();
	}

}
