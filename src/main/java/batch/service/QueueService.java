/*
	Copyright 2017 Northeastern University

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	  http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package batch.service;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

import org.apache.htrace.fasterxml.jackson.core.JsonProcessingException;
import org.apache.htrace.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import batch.service.dto.*;


/**
 * Service to queue jobs for asynchronous execution.
 * 
 * @author Joseph Sackett
 * @author wilson.v@husky.neu.edu
 */
@Service("queueService")
public class QueueService {
	/** Logger. */
	private static final Logger logger = LogManager.getLogger(QueueService.class);
	/** JMS Connection. */
	private Connection connection;
	/** JMS Queue. */
	private Queue queue;

	public QueueService() {
		try {
			final InitialContext context = new InitialContext();
			final ConnectionFactory connectionFactory = (ConnectionFactory) context
					.lookup("java:comp/env/jms/ConnectionFactory");
			logger.debug("Connection Factory " + connectionFactory);
			connection = connectionFactory.createConnection();
			logger.debug("After creating connection: " + connection);
			queue = (Queue) context.lookup("jms/queue/Job");
			logger.debug("After looking up the queue: " + queue);
		} catch (final Exception e) {
			logger.error("Init error.", e);
		}
	}

	public void sendMessage(final DataTransferObject dto){
		logger.debug(dto);
		try {
			final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			final TextMessage textMessage = session.createTextMessage();

			ObjectMapper obj = new ObjectMapper();
			textMessage.setText(obj.writeValueAsString(dto));

			final MessageProducer queueSender = session.createProducer(queue);
			queueSender.send(textMessage);
		} catch (final JMSException | JsonProcessingException e) {
			logger.error("Message send error.", e);
		}
	}
}