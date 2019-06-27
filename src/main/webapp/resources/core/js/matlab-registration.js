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
function initMatRegPlugin() {
	$('#matRegButton').on('click', function() {
		$('#launchMatlabRegistrationModal').off();
		$('#launchMatlabRegistrationModal .btn-info').off();
		$('#matRegCSV').off();
		//$('#inputDir1').val("");
	    $('#matRegCSV').on("input", function() {
	    	// Enable launch button only when all paths entered.
	        $('#launchMatlabRegistrationModal .btn-info').prop("disabled", $('#matRegCSV').val().trim() === "");
	    });
	    
	    $('#launchMatlabRegistrationModal').on('shown.bs.modal', function() {
	        $(this).find('#matRegCSV').focus();
	    });
	    
		$('#launchMatlabRegistrationModal .btn-info').on('click', function () {
			var matRegCSV = $('#matRegCSV').val().trim();
			var matRegTrans = $('#matRegTrans').val();
			var matRegParallel = $('#matRegParallel').val();
			var matRegType = $('#matRegType').val();
			var matRegMu = $('#matRegMu').val();
			launchMatReg(matRegCSV, matRegTrans, matRegParallel, matRegType, matRegMu);
	    });
		
		$('#launchMatlabRegistrationModal').modal('show');
	});
}

function launchMatReg(matRegCSV, matRegTrans, matRegParallel, matRegType, matRegMu) {
	var dto = JSON.stringify({"matRegCSV": matRegCSV, "matRegTrans": matRegTrans, "matRegParallel": matRegParallel, "matRegType": matRegType, "matRegMu": matRegMu});
	$.post({
		url: "matRegCSV",
		contentType : "application/json",
		data: dto,
		cache: false,
		timeout: 2000})
		.done(function() {
			console.log("Matlab Registration job launched.");
		})
		.fail(function() {
			console.log("Problem launching Matlab Registration job.");
		});
}