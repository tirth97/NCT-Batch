<!--
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
-->
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>NCTracer Batch</title>

<meta charset="UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>

<spring:url value="/resources/core/images/favicon.ico" var="favIcon" />
<link href="${favIcon}" rel="shortcut icon" />

<!-- c:url var="home" value="/" scope="request" /-->
<spring:url value="/" var="home" />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<spring:url value="/resources/core/css/styles.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />

</head>

<body onload="initRefreshLogEntries(); initWordCountPlugin(); initMatrixMultPlugin(); initFeatureExtractionPlugin(); initImageStitchingPlugin(); initImageJFilterPlugin(); initMatRegPlugin(); initMatFilterPlugin();">

<div class="container-fluid">
	<div class="row vertical-center">
     	<div class="col-sm-6">
			<h1>NCTracer Plug-In Development</h1>
     	</div>
		<div class="col-sm-6">
			<spring:url value="/resources/core/images/nct.png" var="nctLogo"/>
			<img src="${nctLogo}" alt="NCT" class="header-img"/>
     	</div>
   	</div>
</div>

<div class="container-fluid fill95">
	<div class="row fill100">
		<div id="canvasWrap" class="col-sm-12 fill100">
			<label for="listProcMessages">Process Messages</label>
			<div class="row no-gutters">
				<select multiple size="10" class="form-control" id="listProcMessages" disabled></select>
			</div>
			<div class="row no-gutters">
				<label for="wordCountButton">Word Count</label>
				<button class="btn btn-sm btn-default" id="wordCountButton">Setup Word Count</button>
			</div>
			<div class="row no-gutters">
				<label for="matrixMultButton">Matrix Multiplication&nbsp;</label>
				<button class="btn btn-sm btn-default" id="matrixMultButton">Setup Matrix Multiplication</button>
			</div>
			<div class="row no-gutters">
				<label for="featureExtractionButton">Feature Extraction&nbsp;</label>
				<button class="btn btn-sm btn-default" id="featureExtractionButton">Setup Feature Extraction</button>
			</div>
			<div class="row no-gutters">
				<label for="zoomLevelnButton">Zoom Level&nbsp;</label>
				<button class="btn btn-sm btn-default" id="zoomLevelButton">Setup Zoom Level</button>
			</div>
			<div class="row no-gutters">
				<label for="imageStitchingButton">Image Stitching&nbsp;</label>
				<button class="btn btn-sm btn-default" id="imageStitchingButton">Setup Image Stitching</button>
			</div>
			<div class="row no-gutters">
				<label for="imagejFiltersButton">ImageJ Filters&nbsp;</label>
				<button class="btn btn-sm btn-default" id="imagejFiltersButton">Setup ImageJ Filters</button>
			</div>
			<div class="row no-gutters">
				<label for="matRegButton">Matlab Registration&nbsp;</label>
				<button class="btn btn-sm btn-default" id="matRegButton">Setup Matlab Registration</button>
			</div>
			<div class="row no-gutters">
				<label for="matFilterButton">Matlab Filters&nbsp;</label>
				<button class="btn btn-sm btn-default" id="matFilterButton">Setup Matlab Filters</button>
			</div>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row vertical-center">
		<div class="col-sm-12">
			<spring:url value="/resources/core/images/neu2.png" var="neuLogo"/>
			<img src="${neuLogo}" alt="NEU" class="footer-img pull-right"/>
		</div>
	</div>
</div>

<!-- Word Count Launch Dialog -->
<div id="launchWordCountModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><span class='glyphicon glyphicon-info-sign text-success'></span>&nbsp;&nbsp;Word Count</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="inputDir">Input Dir</label>
                        <input type="text" class="form-control" id="inputDir" value="${pluginRoot}/word-count/input">
                    </div>
                    <div class="form-group">
                        <label for="outputDir">Output Dir</label>
                        <input type="text" class="form-control" id="outputDir" value="${pluginRoot}/word-count/output">
                    </div>
                 </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" data-dismiss="modal">Launch</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>

<!-- Matrix Multiplication Launch Dialog -->
<div id="launchMatrixMultModal" class="modal fade">
	<div class="modal-dialog">
        <div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><span class='glyphicon glyphicon-info-sign text-success'></span>&nbsp;Matrix Multiplication (A * B)</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<label for="inputDir1">Input Dir (Matrix A)</label>
						<input type="text" class="form-control" id="inputDir1" value="${pluginRoot}/matrix-mult/input1">
						<label for="inputDir2">Input Dir (Matrix B)</label>
						<input type="text" class="form-control" id="inputDir2" value="${pluginRoot}/matrix-mult/input2">
					</div>
					<div>
						<label for="intermResultDir">Intermediate Result Dir (When B=1, this is the final result.)</label>
						<input type="text" class="form-control" id="intermResultDir" value="${pluginRoot}/matrix-mult/intermOuput">
						<label for="matrixProductDir">Output Dir (Matrix Product)</label>
						<input type="text" class="form-control" id="matrixProductDir" value="${pluginRoot}/matrix-mult/output">
					</div>
					<br/>
					<div>
						<label>Matrix Sizes (Matrix A: N0 by N1, Matrix B: N1 by N2)</label>
						<div>
						<label for="matrixSize0">N0<input type="number" class="form-control" id="matrixSize0" style="width: 150px;"></label>
						<label for="matrixSize1">N1<input type="number" class="form-control" id="matrixSize1" style="width: 150px;"></label>
						<label for="matrixSize2">N2<input type="number" class="form-control" id="matrixSize2" style="width: 150px;"></label>
						</div>
					</div>
					<div>
						<label>How to partition (B0 by B1 by B2)</label>
						<div>
						<label for="B0">B0<input type="number" class="form-control" id="B0" value=1 style="width: 100px;"> </label>
						<label for="B1">B1<input type="number" class="form-control" id="B1" value=1 style="width: 100px;"> </label>
						<label for="B2">B2<input type="number" class="form-control" id="B2" value=1 style="width: 100px;"> </label>
						</div>
					</div>
					<div>
						<label for="matrixPropFile">Property file (set system parameters)</label>
						<input type="text" class="form-control" id="matrixPropFile" value="${pluginRoot}/matrix-mult/10t20t10.properties">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" data-dismiss="modal">Launch</button>
	           	<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<!-- Feature Extraction Launch Dialog -->
<div id="launchFeatureExtractionModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><span class='glyphicon glyphicon-info-sign text-success'></span>&nbsp;&nbsp;Feature Extraction</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<label for="inputDirFE">Input Dir</label>
						<input type="text" class="form-control" id="inputDirFE" value="${pluginRoot}/feature-extraction/input">
					</div>
					<div class="form-group">
						<label for="outputDirFE">Output Dir</label>
						<input type="text" class="form-control" id="outputDirFE" value="${pluginRoot}/feature-extraction/output">
					</div>
					<div class="form-group">
						<label for="featureFilterClassFE">Feature Filter Class</label>
						<input type="text" class="form-control" id="featureFilterClassFE" value="nctracer.features.filters.GaussianBlur3DWrapper">
					</div>
					<div class="form-group">
						<label for="featureNeighborhoodSizeFE">Feature Neighborhood Size</label>
						<input type="number" class="form-control" id="featureNeighborhoodSizeFE" value=3>
					</div>
					<div class="form-group">
						<label for="featureThresholdFE">Feature Threshold</label>
						<input type="text" class="form-control" id="featureThresholdFE" value="AUTO">
					</div>
					<div class="form-group">
						<label for="featureScalingFactorFE">Feature Scaling Factor</label>
						<input type="text" class="form-control" id="featureScalingFactorFE" value="AUTO">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" data-dismiss="modal">Launch</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>


<!-- Zoom Level Launch Dialog -->
<div id="launchZoomLevelModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><span class='glyphicon glyphicon-info-sign text-success'></span>&nbsp;&nbsp;Zoom Level</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<label for="inputDirZL">Input Directory</label>
						<input type="text" class="form-control" id="inputDirZL" value="${pluginRoot}/zoom-level/input">
					</div>
					<div class="form-group">
						<label for="outputDirZL">Output Directory</label>
						<input type="text" class="form-control" id="outputDirZL" value="${pluginRoot}/zoom-level/output">
					</div>
					<div class="form-group">
						<label for="OriginZL">Global Origin</label>
						<input type="text" class="form-control" id="OriginZL" value="1,1,1">
					</div>
					<div class="form-group">
						<label for="tileDimZL">Input Tile Dimention</label>
						<input type="text" class="form-control" id="tileDimZL" value="256,256,64">
					</div>
					<div class="form-group">
						<label for="intensityZL">Dummy Tile Pixel Intensity</label>
						<input type="text" class="form-control" id="intensityZL" value="111">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" data-dismiss="modal">Launch</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<!-- Image Stitching Launch Dialog -->
<div id="launchImageStitchingModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><span class='glyphicon glyphicon-info-sign text-success'></span>&nbsp;&nbsp;ImageStitching</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<label for="inputDirIS">Input Dir</label>
						<input type="text" class="form-control" id="inputDirIS" value="${pluginRoot}/image-stitching/input">
					</div>
					<div class="form-group">
						<label for="outputDirIS">Output Dir</label>
						<input type="text" class="form-control" id="outputDirIS" value="${pluginRoot}/image-stitching/output">
					</div>
					<div class="form-group">
						<label for="matchCalculatorClassIS">Match Calculator Class</label>
						<input type="text" class="form-control" id="matchCalculatorClassIS" value="neu.nctracer.dm.TranslationMatchCalculator">
					</div>
					<div class="form-group">
						<label for="offsetIS">Microscopic Offset</label>
						<input type="number" class="form-control" id="offsetIS" value=40>
					</div>
					<div class="form-group">
						<label for="gridDimensionIS">Grid Dimension</label>
						<input type="number" class="form-control" id="gridDimensionIS" value=2>
					</div>
					<div class="form-group">
						<label for="kIS">K value</label>
						<input type="number" class="form-control" id="kIS" value=2>
					</div>
					<div class="form-group">
						<label for="epsilonRangeIS">Epsilon Range</label>
						<input type="number" class="form-control" id="epsilonRangeIS" value=2>
					</div>
					<div class="form-group">
						<label for="nearestNeighborThresholdDistanceIS">Nearest Neighbor Threshold Distance</label>
						<input type="number" class="form-control" id="nearestNeighborThresholdDistanceIS" value=2>
					</div>
					<div class="form-group">
						<label for="nearestNeighborClassIS">Nearest Neighbor Class</label>
						<input type="text" class="form-control" id="nearestNeighborClassIS" value="neu.nctracer.dm.KNearestNeighbors">
					</div>
					<div class="form-group">
						<label for="binIS">Bin</label>
						<input type="text" class="form-control" id="binIS" value="true">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" data-dismiss="modal">Launch</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<!-- ImageJ Filters Launch Dialog -->
<div id="launchImageJFiltersModal" class="modal fade">
	<div class="modal-dialog">
        <div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><span class='glyphicon glyphicon-info-sign text-success'></span>&nbsp;ImageJ Filters</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<label for="ijfilterInput">Input Dir (JPEG images)</label>
						<input type="text" class="form-control" id="ijfilterInput" value="${pluginRoot}/image-filter/jpeg-subset">
					</div>
					<div class="form-group">
						<label for="ijfilterOutput">Output Dir (for filtered images)</label>
						<input type="text" class="form-control" id="ijfilterOutput" value="${pluginRoot}/image-filter/output">
					</div>
					<div class="filter-parameter">
						<fieldset>
						<legend>Choose a filter:</legend>
							<label for="ijGaussianBlur3D">
								<input type="radio" class="filter-parameter" id="ijGaussianBlur3D" name="ijfilter" value="ijGaussian" />  
								GaussianBlur3D&nbsp;
							</label>&nbsp;&nbsp;
							<label for="ijFFT">
								<input type="radio" class="filter-parameter" id="ijFFT" name="ijfilter" value="ijFFT" /> 
								FFT bandpass&nbsp;
							</label>&nbsp;&nbsp;
							<label for="ijThreshold">
								<input type="radio" class="filter-parameter" id="ijThreshold" name="ijfilter" value="ijThreshold" /> 
								Threshold adjuster&nbsp;
							</label>&nbsp;&nbsp;
						</fieldset>
					</div>
					<div id="divIjGaussianBlur3D" class="filter-parameter"  style="display:none">
  						<hr><p>Parameters for GaussianBlur3D:</p>
  						<label for="gaussianSigmaX">SigmaX<input type="number" class="filter-parameter" id="gaussianSigmaX" style="width: 100px;"></label>
  						<label for="gaussianSigmaY">SigmaY<input type="number" class="filter-parameter" id="gaussianSigmaY" style="width: 100px;"></label>
  						<label for="gaussianSigmaZ">SigmaZ<input type="number" class="filter-parameter" id="gaussianSigmaZ" style="width: 100px;"></label>
  					</div>
					<div id="divIjFFT" class="form-group"  style="display:none">
  						<hr><p>Parameters for FFT bandpass:</p>
  						<label for="fftLargeDia">Large Diameter<input type="number" class="filter-parameter" id="fftLargeDia" style="width: 100px;"></label>
  						<label for="fftSmallDia">Small Diameter<input type="number" class="filter-parameter" id="fftSmallDia" style="width: 100px;"></label>
  						<br/>
  						<label for="fftChoices">Choice Diameter</label>
  						<select class="filter-parameter" id="fftChoices">
  							<option value='none'>None</option>
  							<option value='horizontal'>Horizontal</option>
  							<option value='vertical'>Vertical</option>
  						</select>
  						<br/>
  						<label for="fftTolDia">Tolerance Diameter<input type="number" class="filter-parameter" id="fftTolDia" style="width: 100px;"></label>
  						&nbsp;
						<label for="fftScalingDia">
							<input type="checkbox" class="filter-parameter" id="fftScalingDia" name="fftParam" value="fftScalingDia"/>
							Scaling &nbsp; 
						</label>
						&nbsp;&nbsp; 
						<label for="fftSaturateDia">
							<input type="checkbox" class="filter-parameter" id="fftSaturateDia" name="fftParam" value="fftSaturateDia"/>
							Saturate &nbsp; 
						</label>
  					</div>
					<div id="divIjThreshold" class="form-group"  style="display:none">
  						<hr><p>Parameters for Threshold adjuster:</p>
  						<label for="thresholdMethod">Method</label>
  						<select class="filter-parameter" id="thresholdMethod">
  							<option value='Huang'>Huang</option>
  							<option value='Intermodes'>Intermodes</option>
  							<option value='IsoData'>IsoData</option>
  							<option value='Li'>Li</option>
  							<option value='Mean'>Mean</option>
  							<option value='MinError(I)'>MinError(I)</option>
  							<option value='MaxEntropy'>MaxEntropy</option>
  							<option value='Minimum'>Minimum</option>
  							<option value='Moments'>Moments</option>
  							<option value='Otsu'>Otsu</option>
  							<option value='Percentile'>Percentile</option>
  							<option value='RenyiEntropy'>RenyiEntropy</option>
  							<option value='Shanbhag'>Shanbhag</option>
  							<option value='Triangle'>Triangle</option>
  							<option value='Yen'>Yen</option>
  						</select>
  					</div>
					<div class="form-group">
  						<hr><p>Parameters for database</p>
						<!-- <label for="imageID">Image ID<input type="number" class="form-control" id="imageID"></label> -->
						<label for="imageName">Image Name<input type="text" class="form-control" id="imageName"></label>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-db" data-dismiss="modal">Launch(Write to DB)</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">Launch</button>
	           	<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<!-- Matlab Registration Launch Dialog -->
<div id="launchMatlabRegistrationModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><span class='glyphicon glyphicon-info-sign text-success'></span>&nbsp;&nbsp;Matlab Registration</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="matRegCSV">Input CSV File</label>
                        <input type="text" class="form-control" id="matRegCSV" value="${pluginRoot}/matlab-registration/example-new2-after-feature-extraction/LiMBP_Neocortical2_StackList.csv">
						<label for="matRegTrans">Transformation</label>
                        <select class="filter-parameter" id="matRegTrans">
  							<option value='Translation'>Translation</option>
  							<option value='Rigid'>Rigid</option>
  							<option value='Affine'>Affine</option>
  							<option value='NonRigid'>Non-Rigid</option>
  						</select>
  						<label for="matRegParallel">Sequential/Parallel</label>
                        <select class="filter-parameter" id="matRegParallel">
  							<option value='Sequential'>Sequential</option>
  							<option value='Parallel'>Parallel</option>
  						</select>
  						<label for="matRegType">Type of Registration</label>
                        <select class="filter-parameter" id="matRegType">
  							<option value='Space'>Space</option>
  							<option value='Timelapse'>Timelapse</option>
  						</select>
  						<label for="matRegMu">mu<input type="number" class="filter-parameter" id="matRegMu" style="width: 100px;"></label>
                    </div>
                 </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" data-dismiss="modal">Launch</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>

<!-- Matlab Filter Launch Dialog -->
<div id="launchMatlabFilterModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><span class='glyphicon glyphicon-info-sign text-success'></span>&nbsp;&nbsp;Matlab Filter</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
						<label for="matfilterInput">Input Dir (JPEG images)</label>
						<input type="text" class="form-control" id="matfilterInput" value="${pluginRoot}/image-filter/jpeg-subset">
					</div>
					<div class="form-group">
						<label for="matfilterOutput">Output Dir (for filtered images)</label>
						<input type="text" class="form-control" id="matfilterOutput" value="${pluginRoot}/image-filter/output">
					</div>
					<div class="filter-parameter">
						<label for="matFiltersChoice">Choose a filter:&nbsp;</label>
                        <select class="filter-parameter" id="matFiltersChoice">
  							<option value='Gaussian3D'>Gaussian3D</option>
  						</select>
					</div>
					<div id="divMatlabGaussian3D" class="filter-parameter"  style="display:block">
  						<hr><p>Parameters for MATLAB Gaussian3D:</p>
  						<label for="matGaussianSigmaX">SigmaX<input type="number" class="filter-parameter" id="matGaussianSigmaX" style="width: 100px;"></label>
  						<label for="matGaussianSigmaY">SigmaY<input type="number" class="filter-parameter" id="matGaussianSigmaY" style="width: 100px;"></label>
  						<label for="matGaussianSigmaZ">SigmaZ<input type="number" class="filter-parameter" id="matGaussianSigmaZ" style="width: 100px;"></label>
  					</div>
					<div class="form-group">
  						<hr><p>Parameters for database</p>
						<label for="matfilterImageName">Image Name</label>
						<input type="text" class="form-control" id="matfilterImageName" value="matlab-filtered">
					</div>
                 </form>
            </div>
            <div class="modal-footer">
				<button type="button" class="btn btn-db" data-dismiss="modal">Launch(Write to DB)</button>
                <button type="button" class="btn btn-info" data-dismiss="modal">Launch</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<spring:url value="/resources/core/js/index.js" var="indexJs" />
<script src="${indexJs}"></script>

<spring:url value="/resources/core/js/word-count.js" var="wordCountJs" />
<script src="${wordCountJs}"></script>

<spring:url value="/resources/core/js/matrix-mult.js" var="matrixMultJs" />
<script src="${matrixMultJs}"></script>

<spring:url value="/resources/core/js/feature-extraction.js" var="featureExtractionJs" />
<script src="${featureExtractionJs}"></script>

<spring:url value="/resources/core/js/zoom-level.js" var="zoomLevelJs" />
<script src="${zoomLevelJs}"></script>

<spring:url value="/resources/core/js/image-stitching.js" var="imageStitchingJs" />
<script src="${imageStitchingJs}"></script>

<spring:url value="/resources/core/js/imagej-filter.js" var="imagejFilterJs" />
<script src="${imagejFilterJs}"></script>

<spring:url value="/resources/core/js/matlab-registration.js" var="matRegJs" />
<script src="${matRegJs}"></script>

<spring:url value="/resources/core/js/matlab-filter.js" var="matFilterJs" />
<script src="${matFilterJs}"></script>

</body>
</html>