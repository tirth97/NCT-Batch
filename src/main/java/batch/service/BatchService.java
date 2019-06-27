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

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import batch.dao.BatchDAO;
import batch.service.dto.BatchLogEntryDTO;

/**
 * Service to manage batch services.
 * @author Joseph Sackett
 */
@Service("batchService")
public class BatchService {
	/** Logger. */
	private static final Logger logger = LogManager.getLogger(BatchService.class);

	/** Batch database functions. */
	@Autowired
	private BatchDAO batchDAO;

	/** Creates a new new batch log entry, returns Id. */
	public int createBatchLogEntry(final String job, final String description) {
	    return batchDAO.createBatchLogEntry(job, description);
	}

	/** Read all batch log entries. */
	public List<String> readBatchLogEntries() {
		final List<String> output = new LinkedList<>();
		final List<BatchLogEntryDTO> entries = batchDAO.readBatchLogEntries();
		for (final BatchLogEntryDTO entry : entries) {
			output.add(entry.toFormattedString(30, 15));
		}
		return output;
	}

	/** Create batch log DB schema. */
    public void createBatchSchema() {
    	batchDAO.createBatchSchema();
    }
}
