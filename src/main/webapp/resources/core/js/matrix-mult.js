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

function initMatrixMultPlugin() {
// Initializes the word count plugin UI.
	$('#matrixMultButton').on('click', function() {
		$('#launchMatrixMultModal').off();
		$('#launchMatrixMultModal .btn-info').off();
		$('#inputDir1').off();
		//$('#inputDir1').val("");
	    $('#inputDir1').on("input", function() {
	    	// Enable launch button only when all paths entered.
	        $('#launchMatrixMultModal .btn-info').prop("disabled", $('#inputDir1').val().trim() === "" || $('#inputDir2').val().trim() === "" || $('#intermResultDir').val().trim() === "" || $('#matrixProductDir').val().trim() === "" || $('#matrixSize0').val().length() === 0 || $('#matrixSize1').val().trim() === "" || $('#matrixSize2').val().trim() === "" || $('#B0').val().trim() === "" || $('#B1').val().trim() === "" || $('#B2').val().trim() === "" || $('#matrixPropFile').val().trim() === "");
	    });
		$('#inputDir2').off();
	    $('#inputDir2').on("input", function() {
	    	// Enable launch button only when all paths entered.
	        $('#launchMatrixMultModal .btn-info').prop("disabled", $('#inputDir1').val().trim() === "" || $('#inputDir2').val().trim() === "" || $('#intermResultDir').val().trim() === "" || $('#matrixProductDir').val().trim() === "" || $('#matrixSize0').val().length() === 0 || $('#matrixSize1').val().trim() === "" || $('#matrixSize2').val().trim() === "" || $('#B0').val().trim() === "" || $('#B1').val().trim() === "" || $('#B2').val().trim() === "" || $('#matrixPropFile').val().trim() === "");
	    });
		$('#intermResultDir').off();
	    $('#intermResultDir').on("input", function() {
	    	// Enable launch button only when all paths entered.
	    	$('#launchMatrixMultModal .btn-info').prop("disabled", $('#inputDir1').val().trim() === "" || $('#inputDir2').val().trim() === "" || $('#intermResultDir').val().trim() === "" || $('#matrixProductDir').val().trim() === "" || $('#matrixSize0').val().length() === 0 || $('#matrixSize1').val().trim() === "" || $('#matrixSize2').val().trim() === "" || $('#B0').val().trim() === "" || $('#B1').val().trim() === "" || $('#B2').val().trim() === "" || $('#matrixPropFile').val().trim() === "");
	    });
		$('#matrixProductDir').off();
	    $('#matrixProductDir').on("input", function() {
	    	// Enable launch button only when all paths entered.
	    	$('#launchMatrixMultModal .btn-info').prop("disabled", $('#inputDir1').val().trim() === "" || $('#inputDir2').val().trim() === "" || $('#intermResultDir').val().trim() === "" || $('#matrixProductDir').val().trim() === "" || $('#matrixSize0').val().length() === 0 || $('#matrixSize1').val().trim() === "" || $('#matrixSize2').val().trim() === "" || $('#B0').val().trim() === "" || $('#B1').val().trim() === "" || $('#B2').val().trim() === "" || $('#matrixPropFile').val().trim() === "");
	    });
		$('#matrixPropFile').off();
	    $('#matrixPropFile').on("input", function() {
	    	// Enable launch button only when all paths entered.
	    	$('#launchMatrixMultModal .btn-info').prop("disabled", $('#inputDir1').val().trim() === "" || $('#inputDir2').val().trim() === "" || $('#intermResultDir').val().trim() === "" || $('#matrixProductDir').val().trim() === "" || $('#matrixSize0').val().length() === 0 || $('#matrixSize1').val().trim() === "" || $('#matrixSize2').val().trim() === "" || $('#B0').val().trim() === "" || $('#B1').val().trim() === "" || $('#B2').val().trim() === "" || $('#matrixPropFile').val().trim() === "");
	    });
	    $('#launchMatrixMultModal').on('shown.bs.modal', function() {
	        $(this).find('#inputDir1').focus();
	    });
		$('#launchMatrixMultModal .btn-info').on('click', function () {
			var inputDir1 = $('#inputDir1').val().trim();
			var inputDir2 = $('#inputDir2').val().trim();
			var intermResultDir = $('#intermResultDir').val().trim();
			var matrixProductDir = $('#matrixProductDir').val().trim();
			var N0 = $('#matrixSize0').val();
			var N1 = $('#matrixSize1').val();
			var N2 = $('#matrixSize2').val();
			var B0 = $('#B0').val().trim();
			var B1 = $('#B1').val().trim();
			var B2 = $('#B2').val().trim();
			var matrixPropFile = $('#matrixPropFile').val().trim();
			launchMatrixMult(inputDir1, inputDir2, intermResultDir, matrixProductDir, N0, N1, N2, B0, B1, B2, matrixPropFile);
	    });
		
	    //$('#launchMatrixMultModal .btn-info').prop("disabled", true);
		$('#launchMatrixMultModal').modal('show');
	});
}

function launchMatrixMult(inputDir1, inputDir2, intermResultDir, matrixProductDir, N0, N1, N2, B0, B1, B2, matrixPropFile) {
	// Ajax call to launch word count job.
	var dto = JSON.stringify({"inputDir1": inputDir1, "inputDir2": inputDir2, "intermResultDir": intermResultDir, "outputDir": matrixProductDir, "propFile": matrixPropFile, "N0": N0, "N1": N1, "N2": N2, "B0": B0, "B1": B1, "B2": B2});
	$.post({
		url: "matrixMult",
//		data : {"traceId": traceId},
		contentType : "application/json",
		data: dto,
		cache: false,
		timeout: 2000})
		.done(function() {
			console.log("Matrix multiplication job launched.");
		})
		.fail(function() {
			console.log("Problem launching matrix multiplication job.");
		});
}
