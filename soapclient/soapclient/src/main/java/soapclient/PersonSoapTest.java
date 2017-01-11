package soapclient;

import java.net.MalformedURLException;
import java.net.URL;

import com.training.soap.service.ObjectFactory;
import com.training.soap.service.PersonService;
import com.training.soap.service.PersonServicePortType;
import com.training.soap.service.PersonServiceRequestType;
import com.training.soap.service.PersonServiceResponseType;
import com.training.soap.service.PersonType;

public class PersonSoapTest {
	public static void main(String[] args) throws MalformedURLException {
		PersonService service = new PersonService(new URL("http://localhost:9191/person-soap/PersonService?wsdl"));
		PersonServicePortType portType = service.getPersonServicePort();
		PersonServiceRequestType request = new ObjectFactory().createPersonServiceRequestType();
		request.setSearchString("test");
		PersonServiceResponseType response = portType.searchPerson(request);

		for (PersonType personType : response.getPersonType()) {
			System.out.println(personType.getFirstName() + " " + personType.getLastName() + " " + personType.getAge());
		}
	}

}
