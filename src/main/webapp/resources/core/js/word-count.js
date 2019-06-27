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

function initWordCountPlugin() {
// Initializes the word count plugin UI.
	$('#wordCountButton').on('click', function() {
		$('#launchWordCountModal').off();
		$('#launchWordCountModal .btn-info').off();
		$('#inputDir').off();
	    $('#inputDir').on("input", function() {
	    	// Enable launch button only when boths paths entered.
	        $('#launchWordCountModal .btn-info').prop("disabled", $('#inputDir').val().trim() === "" || $('#outputDir').val().trim() === "");
	    });
		$('#outputDir').off();
	    $('#outputDir').on("input", function() {
	    	// Enable launch button only when boths paths entered.
	        $('#launchWordCountModal .btn-info').prop("disabled", $('#inputDir').val().trim() === "" || $('#outputDir').val().trim() === "");
	    });
	    $('#launchWordCountModal').on('shown.bs.modal', function() {
	        $(this).find('#inputDir').focus();
	    });
		$('#launchWordCountModal .btn-info').on('click', function () {
			var inputDir = $('#inputDir').val().trim();
			var outputDir = $('#outputDir').val().trim();
			launchWordCount(inputDir, outputDir);
	    });
		
		$('#launchWordCountModal').modal('show');
	});
}

function launchWordCount(inputDir, outputDir) {
	// Ajax call to launch word count job.
	var dto = JSON.stringify({"inputDir": inputDir, "outputDir": outputDir});
	$.post({
		url: "wordCount",
		contentType : "application/json",
		data: dto,
		cache: false,
		timeout: 2000})
		.done(function() {
			console.log("Word count job launched.");
		})
		.fail(function() {
			console.log("Problem launching word count job.");
		});
}
