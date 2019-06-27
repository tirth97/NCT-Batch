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

function initRefreshLogEntries() {
// Set timer to refresh log entries.
	readBatchLogEntries();
}

function readBatchLogEntries() {
	// Ajax call to read batch log entries.
	$.post({
		url: "readBatchLogEntries",
		contentType : "application/json",
		cache: false,
		timeout: 2000})
		.done(function(logEntries) {
			$('#listProcMessages').children().remove();
			logEntries.forEach(function(entry) {
				$('#listProcMessages').append($('<option/>').html(entry.replace(/ /g, '&nbsp;')));
	        });
		})
		.always(function() {
			setTimeout(readBatchLogEntries, 2000);
		})
		.fail(function() {
			console.log("readBatchLogEntries failed.");
		});
}
