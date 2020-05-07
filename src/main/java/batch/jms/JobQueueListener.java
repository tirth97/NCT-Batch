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
package batch.jms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import batch.service.MRExecutorService;
import batch.service.dto.DataTransferObject;
import batch.util.JMSMessage;
import batch.util.JMSMessage.statusValues;
import batch.service.dto.DtoMapper;

/**
 * Service to listen for job queue messages, execute requested jobs, and return
 * results on result queue.
 * 
 * @author Joseph Sackett
 * @author wilson.v@husky.neu.edu
 */
public class JobQueueListener implements MessageListener {
	/** Logger. */
	private static final Logger logger = LogManager.getLogger(JobQueueListener.class);
	/** Job execution service. */
	@Autowired
	private MRExecutorService mrExecutorService;
	/** JMS Connection. */
	private Connection connection;
	/** JMS Queue. */
	private Queue queue;

	public JobQueueListener() {
		try {
			final InitialContext context = new InitialContext();
			final ConnectionFactory connectionFactory = (ConnectionFactory) context
					.lookup("java:comp/env/jms/ConnectionFactory");
			connection = connectionFactory.createConnection();
			queue = (Queue) context.lookup("jms/queue/Result");
		} catch (final Exception e) {
			logger.error("Init error.", e);
		}
	}

	@Override
	public void onMessage(final Message message) {
		try {
			final TextMessage textMessageIn = (TextMessage) message;
			logger.debug("Message: " + textMessageIn.getText());
			String request = textMessageIn.getText();
			ObjectMapper obj = new ObjectMapper();
			DataTransferObject dto = obj.readValue(request, DataTransferObject.class);
			String jobName = dto.getJob();
			// default result
			JMSMessage result = new JMSMessage(dto.getToken(), "No job configured for: " + jobName, statusValues.UNKNOWN);

			final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			final TextMessage textMessageOut = session.createTextMessage();

			dto = DtoMapper.getInstance().getSubClassObject(request);
			if(dto != null){
				if(dto.getJob().equals("kill-job")){
					result = mrExecutorService.killHadoopJob(dto.getToken());
				} else{
					result = mrExecutorService.execHadoopJob(dto);
				}
				
			}

			// result.setToken(dto.getToken());
			textMessageOut.setText(obj.writeValueAsString(result));
			final MessageProducer queueSender = session.createProducer(queue);
			queueSender.send(textMessageOut);

		} catch (final JMSException | IOException e) {
			logger.error("JMS error.", e);
		}
	}
}
