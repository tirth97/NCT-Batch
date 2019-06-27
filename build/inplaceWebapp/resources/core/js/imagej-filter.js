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

function initImageJFilterPlugin() {
	$('#imagejFiltersButton').on('click', function() {
		$('#launchImageJFiltersModal').off();
		$('#launchImageJFiltersModal .btn-info').off();
		$('#launchImageJFiltersModal .btn-db').off();
		$('#ijfilterInput').off();
		//$('#inputDir1').val("");
	    $('#ijfilterInput').on("input", function() {
	    	// Enable launch button only when all paths entered.
	        $('#launchImageJFiltersModal .btn-info').prop("disabled", $('#ijfilterInput').val().trim() === "" || $('#ijfilterOutput').val().trim() === "" 
	        	|| ($('#ijGaussianBlur3D').checked() === false && $('#ijFFT').checked() === false && $('#ijThreshold').checked() === false ) );
	    });
	    
	    $('#launchImageJFiltersModal').on('shown.bs.modal', function() {
	        $(this).find('#ijfilterInput').focus();
	    });
	    
	    $('#ijGaussianBlur3D').click(function() {
	    	displayFilterParameters();
	    });
	    
	    $('#ijFFT').click(function() {
	    	displayFilterParameters();
	    });
	    
	    $('#ijThreshold').click(function() {
	    	displayFilterParameters();
	    });
	    
		$('#launchImageJFiltersModal .btn-info').on('click', function () {
			var ijfilterInput = $('#ijfilterInput').val().trim();
			var ijfilterOutput = $('#ijfilterOutput').val().trim();
			if($('#ijGaussianBlur3D').is(':checked')) {
				var gaussianSigmaX = $('#gaussianSigmaX').val();
				var gaussianSigmaY = $('#gaussianSigmaY').val();
				var gaussianSigmaZ = $('#gaussianSigmaZ').val();
				launchImageJGaussianFilter(ijfilterInput, ijfilterOutput, gaussianSigmaX, gaussianSigmaY, gaussianSigmaZ);
			}
			else if($('#ijFFT').is(':checked')) {
				var fftLargeDia = $('#fftLargeDia').val();
				var fftSmallDia = $('#fftSmallDia').val();
				var fftChoices = $('#fftChoices').val();
				var fftTolDia = $('#fftTolDia').val();
				var fftScalingDia = false;
				var fftSaturateDia = false;
				if($('#fftScalingDia').is(':checked')) {
					fftScalingDia = true;
				}
				if($('#fftSaturateDia').is(':checked')) {
					fftSaturateDia = true;
				}
				lauchImageJFFT(ijfilterInput, ijfilterOutput, fftLargeDia, fftSmallDia, fftChoices, fftTolDia, fftScalingDia, fftSaturateDia);
			}
			else if ($('#ijThreshold').is(':checked')) {
				
			}
	    });
		
		$('#launchImageJFiltersModal .btn-db').on('click', function () {
			var ijfilterInput = $('#ijfilterInput').val().trim();
			var ijfilterOutput = $('#ijfilterOutput').val().trim();
			var imageName = $('#imageName').val().trim();
			if($('#ijGaussianBlur3D').is(':checked')) {
				var gaussianSigmaX = $('#gaussianSigmaX').val();
				var gaussianSigmaY = $('#gaussianSigmaY').val();
				var gaussianSigmaZ = $('#gaussianSigmaZ').val();
				launchImageJGaussianFilterDB(ijfilterInput, ijfilterOutput, gaussianSigmaX, gaussianSigmaY, gaussianSigmaZ, imageName);
			}
			else if($('#ijFFT').is(':checked')) {
				var fftLargeDia = $('#fftLargeDia').val();
				var fftSmallDia = $('#fftSmallDia').val();
				var fftChoices = $('#fftChoices').val();
				var fftTolDia = $('#fftTolDia').val();
				var fftScalingDia = false;
				var fftSaturateDia = false;
				if($('#fftScalingDia').is(':checked')) {
					fftScalingDia = true;
				}
				if($('#fftSaturateDia').is(':checked')) {
					fftSaturateDia = true;
				}
				lauchImageJFFTDB(ijfilterInput, ijfilterOutput, fftLargeDia, fftSmallDia, fftChoices, fftTolDia, fftScalingDia, fftSaturateDia, imageName);
			}
			else if ($('#ijThreshold').is(':checked')) {
				var thresholdMethod = $('#thresholdMethod').val();
				lauchImageJThresholdDB(ijfilterInput, ijfilterOutput, thresholdMethod, imageName);
			}
	    });
		
		$('#launchImageJFiltersModal').modal('show');
	});
}

function displayFilterParameters(){
	if($('#ijGaussianBlur3D').is(':checked')) {
		$('#divIjFFT').css('display', 'none');
		$('#divIjThreshold').css('display', 'none');
		$('#divIjGaussianBlur3D').css('display', 'block');
	} 
	else if($('#ijFFT').is(':checked')) {
		$('#divIjThreshold').css('display', 'none');
		$('#divIjGaussianBlur3D').css('display', 'none');
		$('#divIjFFT').css('display', 'block');
	} 
	else if($('#ijThreshold').is(':checked')) {
		$('#divIjFFT').css('display', 'none');
		$('#divIjGaussianBlur3D').css('display', 'none');
		$('#divIjThreshold').css('display', 'block');
	}
}

function launchImageJGaussianFilter(ijfilterInput, ijfilterOutput, gaussianSigmaX, gaussianSigmaY, gaussianSigmaZ) {
	var dto = JSON.stringify({"ijfilterInput": ijfilterInput, "ijfilterOutput": ijfilterOutput, "gaussianSigmaX": gaussianSigmaX, "gaussianSigmaY": gaussianSigmaY, "gaussianSigmaZ": gaussianSigmaZ});
	$.post({
		url: "imagejGaussian",
		contentType : "application/json",
		data: dto,
		cache: false,
		timeout: 2000})
		.done(function() {
			console.log("ImageJ Gaussian Filter job launched.");
		})
		.fail(function() {
			console.log("Problem launching ImageJ Gaussian Filter job.");
		});
}

function lauchImageJFFT(ijfilterInput, ijfilterOutput, fftLargeDia, fftSmallDia, fftChoices, fftTolDia, fftScalingDia, fftSaturateDia) {
	var dto = JSON.stringify({"ijfilterInput": ijfilterInput, "ijfilterOutput": ijfilterOutput, "fftLargeDia": fftLargeDia, "fftSmallDia": fftSmallDia, "fftChoices": fftChoices, "fftTolDia": fftTolDia, "fftScalingDia": fftScalingDia, "fftSaturateDia": fftSaturateDia});
	$.post({
		url: "imagejFFT",
		contentType : "application/json",
		data: dto,
		cache: false,
		timeout: 2000})
		.done(function() {
			console.log("ImageJ FFT job launched.");
		})
		.fail(function() {
			console.log("Problem launching ImageJ FFT job.");
		});
}

function launchImageJGaussianFilterDB(ijfilterInput, ijfilterOutput, gaussianSigmaX, gaussianSigmaY, gaussianSigmaZ, imageName) {
	var dto = JSON.stringify({"ijfilterInput": ijfilterInput, "ijfilterOutput": ijfilterOutput, "gaussianSigmaX": gaussianSigmaX, "gaussianSigmaY": gaussianSigmaY, "gaussianSigmaZ": gaussianSigmaZ, "imageName": imageName});
	$.post({
		url: "imagejGaussianDB",
		contentType : "application/json",
		data: dto,
		cache: false,
		timeout: 2000})
		.done(function() {
			console.log("ImageJ Gaussian Filter job launched.");
		})
		.fail(function() {
			console.log("Problem launching ImageJ Gaussian Filter job.");
		});
}

function lauchImageJFFTDB(ijfilterInput, ijfilterOutput, fftLargeDia, fftSmallDia, fftChoices, fftTolDia, fftScalingDia, fftSaturateDia, imageName) {
	var dto = JSON.stringify({"ijfilterInput": ijfilterInput, "ijfilterOutput": ijfilterOutput, "fftLargeDia": fftLargeDia, "fftSmallDia": fftSmallDia, "fftChoices": fftChoices, "fftTolDia": fftTolDia, "fftScalingDia": fftScalingDia, "fftSaturateDia": fftSaturateDia, "imageName": imageName});
	$.post({
		url: "imagejFFTDB",
		contentType : "application/json",
		data: dto,
		cache: false,
		timeout: 2000})
		.done(function() {
			console.log("ImageJ FFT job launched.");
		})
		.fail(function() {
			console.log("Problem launching ImageJ FFT job.");
		});
}

function lauchImageJThresholdDB(ijfilterInput, ijfilterOutput, thresholdMethod, imageName) {
	var dto = JSON.stringify({"ijfilterInput": ijfilterInput, "ijfilterOutput": ijfilterOutput, "thresholdMethod": thresholdMethod, "imageName": imageName});
	$.post({
		url: "imagejThresholdDB",
		contentType : "application/json",
		data: dto,
		cache: false,
		timeout: 2000})
		.done(function() {
			console.log("ImageJ Threshold job launched.");
		})
		.fail(function() {
			console.log("Problem launching ImageJ Threshold job.");
		});
}
