package com.cubic.jms;

import java.util.Properties;

import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.sun.messaging.jmq.jmsserver.core.Session;

public class JMSQueueReceiver {

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
			while (true) {
				Message msg = receiver.receive(10000);
				if (msg instanceof TextMessage) {
					TextMessage txtmsg = (TextMessage) msg;
					System.out.println("Listener 1 - " + txtmsg.getText());

				}
			}

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
