package com.cubic.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.rest.vo.PatientData;
import com.cubic.rest.vo.PatientInfo;
import com.cubic.rest.vo.PatientInfoSearchResult;
import com.cubic.service.PatientDataService;
import com.cubic.service.PatientInfoService;

@Path("/patient")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

@Service
public class PatientInfoRest {

	@Autowired
	private PatientDataService ps;

	@Autowired
	private PatientInfoService pi;

	@GET
	@Path("/test")
	public String hello() {
		return "TESTingTEST";
	}

	@POST
	@Path("/create")
	public Response createPatientData(final PatientData patientData) {
		String id = ps.createPatientData(patientData);
		patientData.getPatientInfo().setId(id);
		ResponseBuilder rb = Response.ok().entity(patientData);
		return rb.build();
	}

	@PUT
	@Path("/modify")
	public Response modifyPatientInfo(final PatientInfo patientInfo) {
		pi.modifyPatientInfo(patientInfo);
		return Response.noContent().build();
	}

	@GET
	@Path("/{id}")
	public Response findPatientInfo(@PathParam("id") final String id) {
		PatientData result = ps.findPatientData(id);
		return Response.ok().entity(result).build();
	}

	@GET
	@Path("/search")
	public Response searchPatientInfo(@QueryParam("fName") final String firstName,
			@QueryParam("lName") final String lastName) {
		List<PatientInfo> searchResults = pi.searchPatient(firstName, lastName);
		return Response.ok().entity(new PatientInfoSearchResult(searchResults)).build();
	}
}
