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

import org.apache.htrace.fasterxml.jackson.databind.ObjectMapper;
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

import batch.service.MRExecutorService;
import batch.service.dto.DataTransferObject;
import batch.service.dto.FeatureExtractMatchDTO;
import batch.service.dto.FeatureExtractionDTO;
import batch.service.dto.FromHdfsDTO;
import batch.service.dto.ImageJFFTDTO;
import batch.service.dto.ImageJGaussianDTO;
import batch.service.dto.ImageJThresholdDTO;
import batch.service.dto.ImageStitchingDTO;
import batch.service.dto.MatlabGaussianDTO;
import batch.service.dto.MatrixMultDTO;
import batch.service.dto.RetileDTO;
import batch.service.dto.ToHdfsDTO;
import batch.service.dto.WordCountDTO;
import batch.service.dto.ZoomLevelDTO;
import batch.util.JMSMessage;
import batch.util.JMSMessage.statusValues;

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
			String[] parameters;
			String request = textMessageIn.getText();
			ObjectMapper obj = new ObjectMapper();
			DataTransferObject dto = obj.readValue(request, DataTransferObject.class);
			String jobName = dto.getJob();
			// default result
			JMSMessage result = new JMSMessage(dto.getToken(), "No job configured for: " + jobName, statusValues.UNKNOWN); 

			if (jobName.equalsIgnoreCase("word-count")) {

				WordCountDTO wc = obj.readValue(request, WordCountDTO.class);
				parameters = new String[] { wc.getInputDir(), wc.getOutputDir() };

				result = mrExecutorService.exeWordCount(parameters);

			} else if (jobName.equalsIgnoreCase("matrix-mult")) {

				MatrixMultDTO mm = obj.readValue(request, MatrixMultDTO.class);
				parameters = new String[] { mm.getInputDir1(), mm.getInputDir2(), mm.getIntermResultDir(),
						mm.getOutputDir(), mm.getPropFile() };

				result = mrExecutorService.exeMatrixMult(parameters);

			} else if (jobName.equalsIgnoreCase("feature-extraction")) {

				FeatureExtractionDTO fe = obj.readValue(request, FeatureExtractionDTO.class);
				parameters = new String[] { fe.getInputDir(), fe.getOutputDir(), fe.getFeatureFilterClass(),
						fe.getFeatureNeighborhoodSize(), fe.getFeatureThreshold(), fe.getFeatureScalingFactor() };

				result = mrExecutorService.exeFeatureExtraction(parameters);

			} else if (jobName.equalsIgnoreCase("zoom-level")) {

				ZoomLevelDTO zl = obj.readValue(request, ZoomLevelDTO.class);
				parameters = new String[] { zl.getInputDir(), zl.getOutputDir(), zl.getOrigin(), zl.getTileDim(),
						zl.getIntensity() };

				result = mrExecutorService.exeZoomLevel(parameters);

			} else if (jobName.equalsIgnoreCase("to-hdfs")) {
				
				FromHdfsDTO toHdfs = obj.readValue(request, FromHdfsDTO.class);
				parameters = new String[] {"toHdfs",toHdfs.getFrom(),toHdfs.getTo()};
				result = mrExecutorService.exeToHdfs(parameters);

			} //TODO
			else if (jobName.equalsIgnoreCase("from-hdfs")) {
				ToHdfsDTO toHdfs = obj.readValue(request, ToHdfsDTO.class);
				parameters = new String[] {"fromHdfs",toHdfs.getFrom(),toHdfs.getTo()};
				result = mrExecutorService.exeToHdfs(parameters);

			} else if (jobName.equalsIgnoreCase("retiling")){

				RetileDTO retileDTO = obj.readValue(request, RetileDTO.class);
				parameters = new String[] { retileDTO.getInputDir(), retileDTO.getOutputDir(),
								retileDTO.getOrigin(), retileDTO.getTileDim(),
								retileDTO.getIntensity() };

				result = mrExecutorService.exeRetile(parameters);
			} else if (jobName.equalsIgnoreCase("image-stitching")) {

				ImageStitchingDTO is = obj.readValue(request, ImageStitchingDTO.class);
				parameters = new String[] { is.getInputDir(), is.getOutputDir(), is.getMatchCalculatorClass(),
						is.getOffset(), is.getGridDimension(), is.getK(), is.getEpsilonRange(),
						is.getNearestNeighborThresholdDistance(), is.getNearestNeighborClass(), is.getBin() };

				result = mrExecutorService.exeImageStitching(parameters);

			} else if (jobName.equalsIgnoreCase("imagej-gaussian")) {

				ImageJGaussianDTO ig = obj.readValue(request, ImageJGaussianDTO.class);
				parameters = new String[] { ig.getInputDir(), ig.getOutputDir(), ig.getSigmaX(), ig.getSigmaY(),
						ig.getSigmaZ() };

				result = mrExecutorService.exeImagejGaussian(parameters);

			} else if (jobName.equalsIgnoreCase("imagej-fft")) {

				ImageJFFTDTO iff = obj.readValue(request, ImageJFFTDTO.class);
				parameters = new String[] { iff.getInputDir(), iff.getOutputDir(), iff.getLargeDia(), iff.getSmallDia(),
						iff.getChoices(), iff.getTolDia(), iff.getScalingDia(), iff.getSaturateDia(), };

				result = mrExecutorService.exeImagejFFT(parameters);

			} else if (jobName.equalsIgnoreCase("imagej-threshold")) {

			} else if (jobName.equalsIgnoreCase("imagej-gaussian-db")) {

				ImageJGaussianDTO igdb = obj.readValue(request, ImageJGaussianDTO.class);
				parameters = new String[] { igdb.getInputDir(), igdb.getOutputDir(), igdb.getSigmaX(), igdb.getSigmaY(),
						igdb.getSigmaZ(), igdb.getImageID(), igdb.getImageName() };

				result = mrExecutorService.exeImagejGaussianDB(parameters);

			} else if (jobName.equalsIgnoreCase("imagej-fft-db")) {

				ImageJFFTDTO ijdb = obj.readValue(request, ImageJFFTDTO.class);
				parameters = new String[] { ijdb.getInputDir(), ijdb.getOutputDir(), ijdb.getLargeDia(),
						ijdb.getSmallDia(), ijdb.getChoices(), ijdb.getTolDia(), ijdb.getScalingDia(),
						ijdb.getSaturateDia(), ijdb.getImageID(), ijdb.getImageName() };

				result = mrExecutorService.exeImagejFFTDB(parameters);

			} else if (jobName.equalsIgnoreCase("imagej-threshold-db")) {

				ImageJThresholdDTO itdb = obj.readValue(request, ImageJThresholdDTO.class);
				parameters = new String[] { itdb.getInputDir(), itdb.getOutputDir(), itdb.getThresholdMethod(),
						itdb.getImageID(), itdb.getImageName() };

				result = mrExecutorService.exeImagejThresholdDB(parameters);

			} else if (jobName.equalsIgnoreCase("matlab-gaussian-db")) {

				MatlabGaussianDTO mgdb = obj.readValue(request, MatlabGaussianDTO.class);
				parameters = new String[] { mgdb.getInputDir(), mgdb.getOutputDir(), mgdb.getSigmaX(), mgdb.getSigmaY(),
						mgdb.getSigmaZ(), mgdb.getImageName() };

				result = mrExecutorService.exeMatlabGaussianDB(parameters);

			} else if (jobName.equalsIgnoreCase("matlab-gaussian")) {

				MatlabGaussianDTO mg = obj.readValue(request, MatlabGaussianDTO.class);
				parameters = new String[] { mg.getInputDir(), mg.getOutputDir(), mg.getSigmaX(), mg.getSigmaY(),
						mg.getSigmaZ(), mg.getImageName() };

				result = mrExecutorService.exeMatlabGaussian(parameters);

			} else if (jobName.equalsIgnoreCase("feature-extract-match")) {

				FeatureExtractMatchDTO fem = obj.readValue(request, FeatureExtractMatchDTO.class);
				parameters = new String[] { fem.getInputDir(), fem.getOutputDir() };
				result = mrExecutorService.exeFeatureExtractMatch(parameters);
			}

			final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			final TextMessage textMessageOut = session.createTextMessage();
			result.setToken(dto.getToken());
			textMessageOut.setText(obj.writeValueAsString(result));
			final MessageProducer queueSender = session.createProducer(queue);
			queueSender.send(textMessageOut);

		} catch (final JMSException | IOException e) {
			logger.error("JMS error.", e);
		}
	}
}
