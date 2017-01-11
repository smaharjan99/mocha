package com.cubic.jms;

import java.util.Properties;

import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.cubic.ejb.PatientInfo;

public class JMSQueueObjSender {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		InitialContext ctx = new InitialContext(props);

		QueueConnectionFactory qcFactory = (QueueConnectionFactory) ctx.lookup("jms/QCF");
		QueueConnection qc = null;
		QueueSession session = null;
		QueueSender sender;
		try {
			qc = qcFactory.createQueueConnection();
			qc.start();
			System.out.println("GOot Conncetion");
			session = qc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			PatientInfo info = new PatientInfo();
			ObjectMessage message = session.createObjectMessage();
			message.setObject(new PatientInfo("John", "Kennedy"));

			Queue queue = (Queue) ctx.lookup("jms/MyQueue");
			sender = session.createSender(queue);

			sender.send(message);
			System.out.println("MESSAGE SENT");
			qc.stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (qc != null) {
				qc.close();
			}
		}

	}

}
