package com.cubic.soap.person;

import java.math.BigInteger;

import javax.jws.WebService;

import com.training.soap.service.PersonServicePortType;
import com.training.soap.service.PersonServiceRequestType;
import com.training.soap.service.PersonServiceResponseType;
import com.training.soap.service.PersonType;

@WebService(serviceName = "PersonService", targetNamespace = "http://com.cubic.net/personservice/1.0", portName = "PersonServicePort", endpointInterface = "com.training.soap.service.PersonServicePortType", wsdlLocation = "WEB-INF/wsdl/PersonService.wsdl")
public class PersonSoapWSImpl implements PersonServicePortType {

	public PersonServiceResponseType searchPerson(PersonServiceRequestType arg0) {
		PersonServiceResponseType response = new PersonServiceResponseType();
		response.getPersonType().add(createPersonType("Sam", "Jackson", 99));
		response.getPersonType().add(createPersonType("Jim", "Carrey", 12));
		response.getPersonType().add(createPersonType("Hoyt", "Doyt", 34));
		response.getPersonType().add(createPersonType("Gumbo", "Dumbo", 45));

		return response;
	}

	private PersonType createPersonType(final String fName, final String lName, long age) {
		PersonType result = new PersonType();
		result.setFirstName(fName);
		result.setLastName(lName);
		result.setAge(BigInteger.valueOf(age));
		return result;
	}

}
