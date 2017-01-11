package com.cubic.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(mappedName = "jms/MyQueue", activationConfig = {
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class PatientMDB implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof ObjectMessage) {
				ObjectMessage objMsg = (ObjectMessage) message;
				PatientInfo info = (PatientInfo) objMsg.getObject();
				System.out.println("Inside PatientMDB: " + info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
