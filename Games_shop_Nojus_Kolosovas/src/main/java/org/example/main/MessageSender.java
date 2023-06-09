package org.example.main;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageSender{

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    private static String queueName = "MESSAGE_QUEUE";

    public static void main (String[] args) throws JMSException {

        System.out.println("url = " + url);

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();


        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);


        Destination destination = session.createQueue(queueName);

        MessageProducer producer = session.createProducer(destination);
        TextMessage message = session.createTextMessage("C:");

        producer.send(message);

        System.out.println("Message: " + message.getText() + " sent Successfuly");
        connection.close();
    }
}