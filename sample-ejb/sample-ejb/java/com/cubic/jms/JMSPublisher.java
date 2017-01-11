package com.cubic.jms;

import java.util.Properties;

import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;

public class JMSPublisher {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		InitialContext ctx = new InitialContext(props);

		TopicConnectionFactory qcFactory = (TopicConnectionFactory) ctx.lookup("jms/TCF");
		TopicConnection qc = null;

		try {
			qc = qcFactory.createTopicConnection();
			qc.start();
			System.out.println("GOot Conncetion");
			TopicSession session = qc.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			Topic topic = (Topic) ctx.lookup("jms/MyTopic");
			TopicPublisher pub = session.createPublisher(topic);
			TextMessage message = session.createTextMessage();
			message.setText("Coming from TOPIC");
			pub.publish(message);
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
