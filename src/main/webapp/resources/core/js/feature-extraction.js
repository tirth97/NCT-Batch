function launchFeatureExtraction(inputDir, outputDir, featureFilterClass,
                                 featureNeighborhoodSize, featureThreshold, featureScalingFactor) {
    // Ajax call to launch feature extraction job.
    var dto = JSON.stringify({
        "inputDir": inputDir,
        "outputDir": outputDir,
        "featureFilterClass": featureFilterClass,
        "featureNeighborhoodSize": featureNeighborhoodSize,
        "featureThreshold": featureThreshold,
        "featureScalingFactor": featureScalingFactor
    });

    $.post({
        url: "featureExtraction",
        contentType: "application/json",gradle
        data: dto,
        cache: false,
        timeout: 2000})
        .done(function(){
            console.log("Feature Extraction Launched.");
        })
        .fail(function () {
            console.log("Problem Launching feature extraction job.");
        });
}

function initFeatureExtractionPlugin() {
// Initializes the feature extraction plugin UI.
    $('#featureExtractionButton').on('click', function () {
        $('#launchFeatureExtractionModal').off();
        $('#launchFeatureExtractionModal .btn-info').off();
        $('#inputDirFE').off();
        $('#inputDirFE').on("input", function () {
            // Enable launch button only when boths paths entered.
            $('#launchFeatureExtractionModal .btn-info')
                .prop("disabled", $('#inputDirFE').val().trim() === "" ||
                    $('#outputDirFE').val().trim() === "");
        });
        $('#outputDirFE').off();
        $('#outputDirFE').on("input", function () {
            // Enable launch button only when boths paths entered.
            $('#launchFeatureExtractionModal .btn-info')
                .prop("disabled", $('#inputDirFE').val().trim() === "" ||
                    $('#outputDirFE').val().trim() === "");
        });
        $('#launchFeatureExtractionModal').on('shown.bs.modal', function () {
            $(this).find('#inputDirFE').focus();
        });
        $('#launchFeatureExtractionModal .btn-info').on('click', function () {
            var inputDir = $('#inputDirFE').val().trim();
            var outputDir = $('#outputDirFE').val().trim();
            var featureFilterClass = $('#featureFilterClassFE').val().trim();
            var featureNeighborhoodSize = $('#featureNeighborhoodSizeFE').val().trim();
            var featureThreshold = $('#featureThresholdFE').val().trim();
            var featureScalingFactor = $('#featureScalingFactorFE').val().trim();
            launchFeatureExtraction(inputDir, outputDir, featureFilterClass, featureNeighborhoodSize,
                featureThreshold, featureScalingFactor);
        });

        $('#launchFeatureExtractionModal').modal('show');
    });
}