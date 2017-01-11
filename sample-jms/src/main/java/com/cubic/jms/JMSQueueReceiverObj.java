package com.cubic.jms;

import java.util.Properties;

import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.cubic.ejb.PatientInfo;

public class JMSQueueReceiverObj {

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
			Queue queue = (Queue) ctx.lookup("jms/MyQueue");
			QueueReceiver receiver = session.createReceiver(queue);
			Message msg = receiver.receive(10000);
			if (msg instanceof ObjectMessage) {
				ObjectMessage objmsg = (ObjectMessage) msg;
				PatientInfo info = (PatientInfo) objmsg.getObject();
				System.out.println("Listener 1 - " + info);

			}

			qc.stop();
			session.close();
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
