function launchImageStitching(inputDir, outputDir, matchCalculatorClass, offset, gridDimension, k, epsilonRange,
                              nearestNeighborThresholdDistance, nearestNeighborClass, bin) {
    // Ajax call to launch image stitching job.
    var dto = JSON.stringify({
        "inputDir": inputDir,
        "outputDir": outputDir,
        "matchCalculatorClass": matchCalculatorClass,
        "offset": offset,
        "gridDimension": gridDimension,
        "k": k,
        "epsilonRange": epsilonRange,
        "nearestNeighborThresholdDistance": nearestNeighborThresholdDistance,
        "nearestNeighborClass": nearestNeighborClass,
        "bin": bin
    });

    $.post({
        url: "imageStitching",
        contentType: "application/json",
        data: dto,
        cache: false,
        timeout: 2000})
        .done(function(){
            console.log("Image Stitching Launched.");
        })
        .fail(function () {
            console.log("Problem launching image stitching job.");
        });
}


function initImageStitchingPlugin() {
// Initializes the feature extraction plugin UI.
    $('#imageStitchingButton').on('click', function () {
        $('#launchImageStitchingModal').off();
        $('#launchImageStitchingModal .btn-info').off();
        $('#inputDirIS').off();
        $('#inputDirIS').on("input", function () {
            // Enable launch button only when boths paths entered.
            $('#launchImageStitchingModal .btn-info')
                .prop("disabled", $('#inputDirIS').val().trim() === "" ||
                    $('#outputDirIS').val().trim() === "");
        });
        $('#outputDirIS').off();
        $('#outputDirIS').on("input", function () {
            // Enable launch button only when boths paths entered.
            $('#launchImageStitchingModal .btn-info')
                .prop("disabled", $('#inputDirIS').val().trim() === "" ||
                    $('#outputDirIS').val().trim() === "");
        });
        $('#launchImageStitchingModal').on('shown.bs.modal', function () {
            $(this).find('#inputDirIS').focus();
        });
        $('#launchImageStitchingModal .btn-info').on('click', function () {
            var inputDir = $('#inputDirIS').val().trim();
            var outputDir = $('#outputDirIS').val().trim();
            var matchCalculatorClass = $('#matchCalculatorClassIS').val().trim();
            var offset = $('#offsetIS').val().trim();
            var gridDimension = $('#gridDimensionIS').val().trim();
            var k = $('#kIS').val().trim();
            var epsilonRange = $('#epsilonRangeIS').val().trim();
            var nearestNeighborThresholdDistance = $('#nearestNeighborThresholdDistanceIS').val().trim();
            var nearestNeighborClass = $('#nearestNeighborClassIS').val().trim();
            var bin = $('#binIS').val().trim();
            launchImageStitching(inputDir, outputDir, matchCalculatorClass, offset, gridDimension, k, epsilonRange,
                nearestNeighborThresholdDistance, nearestNeighborClass, bin)
        });

        $('#launchImageStitchingModal').modal('show');
    });
}