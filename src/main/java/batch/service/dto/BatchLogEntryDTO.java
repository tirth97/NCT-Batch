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
package batch.service.dto;

import java.util.Date;

/**
 * Defines and contains word count job parameters.
 * @author Joseph Sackett
 */
public class BatchLogEntryDTO {
	/** Entry id. */
	private final int id;
	/** Job name. */
	private final String job;
	/** Entry description. */
	private final String description;
	/** Entry timestamp. */
	private final Date timestamp;

	public BatchLogEntryDTO(final int id, final String job, final String description, final Date timestamp) {
		this.id = id;
		this.job = job;
		this.description = description;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public String getJob() {
		return job;
	}

	public String getDescription() {
		return description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	/** Render as fixed-width field formatted string. */
	public String toFormattedString(final int jobWidth, final int descWidth) {
		String output = "";
		output += String.format("%-" + jobWidth + "s" + "%-" + descWidth + "s", job, description);
		output += timestamp.toString();
		return output;
	}

	@Override
	public String toString() {
		return "BatchLogEntryDTO [id=" + id + ", job=" + job + ", description=" + description + ", timestamp=" + timestamp + "]";
	}
}
