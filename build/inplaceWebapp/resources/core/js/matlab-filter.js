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
function initMatFilterPlugin() {
	$('#matFilterButton').on('click', function() {
		$('#launchMatlabFilterModal').off();
		$('#launchMatlabFilterModal .btn-info').off();
		$('#launchMatlabFilterModal .btn-db').off();
		$('#matfilterInput').off();
		//$('#inputDir1').val("");
	    $('#matfilterInput').on("input", function() {
	    	// Enable launch button only when all paths entered.
	        $('#launchMatlabFilterModal .btn-info').prop("disabled", $('#matfilterInput').val().trim() === "");
	        $('#launchMatlabFilterModal .btn-db').prop("disabled", $('#matfilterInput').val().trim() === "");
	    });
	    
	    $('#launchMatlabFilterModal').on('shown.bs.modal', function() {
	        $(this).find('#matfilterInput').focus();
	    });
	    
	    $('#matFiltersChoice').click(function() {
	    	$('#matGaussianSigmaX').val(1);
	    });
	    
	    $('#launchMatlabFilterModal .btn-info').on('click', function () {
	    	var matFilterInput = $('#matfilterInput').val().trim();
			var matFilterOutput = $('#matfilterOutput').val();
			var matFiltersChoice = $('#matFiltersChoice').val();
			if(matFiltersChoice === "Gaussian3D") {
				var matGaussian3DSigmaX = $('#matGaussianSigmaX').val();
				var matfilterImageName = $('#matfilterImageName').val().trim();
				launchMatGaussian3D(matFilterInput, matFilterOutput, matGaussian3DSigmaX, matGaussian3DSigmaX, matGaussian3DSigmaX, matfilterImageName);
			}
	    });
	    
		$('#launchMatlabFilterModal .btn-db').on('click', function () {
			var matFilterInput = $('#matfilterInput').val().trim();
			var matFilterOutput = $('#matfilterOutput').val().trim();
			var matFiltersChoice = $('#matFiltersChoice').val();
			if(matFiltersChoice === "Gaussian3D") {
				var matGaussian3DSigmaX = $('#matGaussianSigmaX').val();
				var matfilterImageName = $('#matfilterImageName').val().trim();
				launchMatGaussian3Ddb(matFilterInput, matFilterOutput, matGaussian3DSigmaX, matGaussian3DSigmaX, matGaussian3DSigmaX, matfilterImageName);
			}
	    });
		
		$('#launchMatlabFilterModal').modal('show');
	});
}

function launchMatGaussian3Ddb(matfilterInput, matfilterOutput, gaussianSigmaX, gaussianSigmaY, gaussianSigmaZ, imageName) {
	var dto = JSON.stringify({"filterInput": matfilterInput, "filterOutput": matfilterOutput, "gaussianSigmaX": gaussianSigmaX, "gaussianSigmaY": gaussianSigmaY, "gaussianSigmaZ": gaussianSigmaZ, "imageName": imageName});
	$.post({
		url: "matfilterGaussian3Ddb",
		contentType : "application/json",
		data: dto,
		cache: false,
		timeout: 2000})
		.done(function() {
			console.log("Matlab Filter (Gaussian3D) job launched.");
		})
		.fail(function() {
			console.log("Problem launching Matlab Filter (Gaussian3D) job.");
		});
}

function launchMatGaussian3D(matfilterInput, matfilterOutput, gaussianSigmaX, gaussianSigmaY, gaussianSigmaZ, imageName) {
	var dto = JSON.stringify({"filterInput": matfilterInput, "filterOutput": matfilterOutput, "gaussianSigmaX": gaussianSigmaX, "gaussianSigmaY": gaussianSigmaY, "gaussianSigmaZ": gaussianSigmaZ, "imageName": imageName});
	$.post({
		url: "matfilterGaussian3D",
		contentType : "application/json",
		data: dto,
		cache: false,
		timeout: 2000})
		.done(function() {
			console.log("Matlab Filter (Gaussian3D) job launched.");
		})
		.fail(function() {
			console.log("Problem launching Matlab Filter (Gaussian3D) job.");
		});
}