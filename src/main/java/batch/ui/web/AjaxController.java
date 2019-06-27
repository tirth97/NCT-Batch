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
package batch.ui.web;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import batch.service.QueueService;
import batch.service.dto.ImageStitchingDTO;
import batch.service.dto.MatlabGaussianDTO;
import batch.service.dto.FeatureExtractionDTO;
import batch.service.dto.ImageJFFTDTO;
import batch.service.dto.ImageJGaussianDTO;
import batch.service.dto.ImageJThresholdDTO;
import batch.service.dto.MatrixMultDTO;
import batch.service.dto.WordCountDTO;
import batch.service.dto.ZoomLevelDTO;

/**
 * Spring MVC main controller for batch web application's Ajax calls.
 * @author Joseph Sackett
 * @author wilson.v@husky.neu.edu
 */
@RestController
public class AjaxController {
	/** Logger. */
	private static final Logger logger = LogManager.getLogger(AjaxController.class);

	/** Queues jobs for execution. */
	@Autowired
	private QueueService queueService;
	/** Manages batch job log. */
	//@Autowired
	//private BatchService batchService;

	/** Service to read batch log entries. */
	@RequestMapping(value = "/readBatchLogEntries", method = RequestMethod.POST)
	public ResponseEntity<List<String>> readBatchLogEntries(final HttpSession session) {
		//final List<String> logEntries = batchService.readBatchLogEntries();
		final List<String> logEntries = new LinkedList<>();
	    return ResponseEntity.ok()
	    		.body(logEntries);
	}

	/** Service to run word count batch job. */
	@RequestMapping(value = "/wordCount", method = RequestMethod.POST)
	public void wordCount(@RequestBody final WordCountDTO wcDTO, final HttpSession session) {
		logger.debug("/wordCount request from [Session Id: " + session.getId() + ']');
		logger.debug(wcDTO);
		queueService.sendMessage(wcDTO);
		logger.debug("/wordCount request from [Session Id: " + session.getId() + "] complete.");
	}

	/** Service to run matrix multiplication batch job. */
	@RequestMapping(value = "/matrixMult", method = RequestMethod.POST)
	public void matrixMult(@RequestBody final MatrixMultDTO mmDTO, final HttpSession session) {
		logger.debug("/matrixMult request from [Session Id: " + session.getId() + ']');
		logger.debug(mmDTO);
		queueService.sendMessage(mmDTO);
		logger.debug("/matrixMult request from [Session Id: " + session.getId() + "] complete.");
	}

	/** Service to run feature extraction batch job. */
	@RequestMapping(value = "/featureExtraction", method = RequestMethod.POST)
	public void featureExtraction(@RequestBody final FeatureExtractionDTO feDTO, final HttpSession session) {
		logger.debug("/featureExtraction request from [Session Id: " + session.getId() + ']');
		logger.debug(feDTO);
		queueService.sendMessage(feDTO);
		logger.debug("/featureExtraction request from [Session Id: " + session.getId() + "] complete.");
	}

	/** Service to run feature extraction batch job. */
	@RequestMapping(value = "/zoomLevel", method = RequestMethod.POST)
	public void zoomLevel(@RequestBody final ZoomLevelDTO DTO, final HttpSession session) {
		logger.debug("/zoomLevel request from [Session Id: " + session.getId() + ']');
		DTO.setToken("test");
		DTO.setjob("zoom-level");
		logger.debug(DTO);
		queueService.sendMessage(DTO);
		logger.debug("/zoomLevel request from [Session Id: " + session.getId() + "] complete.");
	}

	/** Service to run feature extraction batch job. */
	@RequestMapping(value = "/imageStitching", method = RequestMethod.POST)
	public void imageStitching(@RequestBody final ImageStitchingDTO isDTO, final HttpSession session) {
		logger.debug("/imageStitching request from [Session Id: " + session.getId() + ']');
		logger.debug(isDTO);
		queueService.sendMessage(isDTO);
		logger.debug("/imageStitching request from [Session Id: " + session.getId() + "] complete.");
	}
	
	/** Service to run imagej gaussian filter batch job. */
	@RequestMapping(value = "/imagejGaussian", method = RequestMethod.POST)
	public void imagejGaussian(@RequestBody final ImageJGaussianDTO gaussianDTO, final HttpSession session) {
		logger.debug("/imagejGaussian request from [Session Id: " + session.getId() + ']');
		logger.debug(gaussianDTO);
		queueService.sendMessage(gaussianDTO);
		logger.debug("/imagejGaussian request from [Session Id: " + session.getId() + "] complete.");
	}

	/** Service to run imagej FFT bandpass filter batch job. */
	@RequestMapping(value = "/imagejFFT", method = RequestMethod.POST)
	public void imagejFFT(@RequestBody final ImageJFFTDTO fftDTO, final HttpSession session) {
		logger.debug("/imagejFFT request from [Session Id: " + session.getId() + ']');
		logger.debug(fftDTO);
		queueService.sendMessage(fftDTO);
		logger.debug("/imagejFFT request from [Session Id: " + session.getId() + "] complete.");
	}
	
	/** Service to run imagej gaussian filter batch job. */
	@RequestMapping(value = "/imagejGaussianDB", method = RequestMethod.POST)
	public void imagejGaussianDB(@RequestBody final ImageJGaussianDTO gaussianDTO, final HttpSession session) {
		logger.debug("/imagejGaussianDB request from [Session Id: " + session.getId() + ']');
		logger.debug(gaussianDTO);
		queueService.sendMessage(gaussianDTO);
		logger.debug("/imagejGaussianDB request from [Session Id: " + session.getId() + "] complete.");
	}

	/** Service to run imagej FFT bandpass filter batch job. */
	@RequestMapping(value = "/imagejFFTDB", method = RequestMethod.POST)
	public void imagejFFTDB(@RequestBody final ImageJFFTDTO fftDTO, final HttpSession session) {
		logger.debug("/imagejFFTDB request from [Session Id: " + session.getId() + ']');
		logger.debug(fftDTO);
		queueService.sendMessage(fftDTO);
		logger.debug("/imagejFFTDB request from [Session Id: " + session.getId() + "] complete.");
	}

	@RequestMapping(value = "/imagejThresholdDB", method = RequestMethod.POST)
	public void imagejThresholdDB(@RequestBody final ImageJThresholdDTO thDTO, final HttpSession session) {
		logger.debug("/imagejThresholdDB request from [Session Id: " + session.getId() + ']');
		logger.debug(thDTO);
		queueService.sendMessage(thDTO);
		logger.debug("/imagejThresholdDB request from [Session Id: " + session.getId() + "] complete.");
	}

	/** Service to run matlab gaussian filter batch (write to DB) job. */
	@RequestMapping(value = "/matfilterGaussian3Ddb", method = RequestMethod.POST)
	public void matlabGaussianDB(@RequestBody final MatlabGaussianDTO gaussianDTO, final HttpSession session) {
		logger.debug("/matlabGaussianDB request from [Session Id: " + session.getId() + ']');
		logger.debug(gaussianDTO);
		queueService.sendMessage(gaussianDTO);
		logger.debug("/matlabGaussianDB request from [Session Id: " + session.getId() + "] complete.");
	}

	/** Service to run matlab gaussian filter batch job. */
	@RequestMapping(value = "/matfilterGaussian3D", method = RequestMethod.POST)
	public void matlabGaussian(@RequestBody final MatlabGaussianDTO gaussianDTO, final HttpSession session) {
		logger.debug("/matlabGaussian request from [Session Id: " + session.getId() + ']');
		logger.debug(gaussianDTO);
		queueService.sendMessage(gaussianDTO);
		logger.debug("/matlabGaussian request from [Session Id: " + session.getId() + "] complete.");
	}
}