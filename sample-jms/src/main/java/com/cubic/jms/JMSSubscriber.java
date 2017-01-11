package com.cubic.jms;

import java.util.Properties;

import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.sun.messaging.jmq.jmsserver.core.Session;

public class JMSSubscriber {

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
			TopicSubscriber ts = session.createSubscriber(topic);
			while (true) {
				Message msg = ts.receive(10000);
				System.out.println("SUBS 1- ");
				System.out.println((msg != null) ? ((TextMessage) msg).getText() : "No Message");
				System.out.println();

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
