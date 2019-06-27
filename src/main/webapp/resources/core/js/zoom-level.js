function launchZoomLevel(inputDir, outputDir,origin,tileDim,intensity) {
    // Ajax call to launch feature extraction job.
    var dto = JSON.stringify({
        "inputDir": inputDir,
        "outputDir": outputDir,
        "origin" :  origin,
        "tileDim" : tileDim,
        "intensity" : intensity
    });

    $.post({
        url: "zoomLevel",
        contentType: "application/json",
        data: dto,
        cache: false,
        timeout: 2000
    })
        .done(function () {
            console.log("Zoom Level Launched.");
        })
        .fail(function () {
            console.log("Problem Launching zoom level job.");
        });
}

function initFeatureExtractionPlugin() {
    // Initializes the feature extraction plugin UI.
    $('#zoomLevelButton').on('click', function () {
        $('#launchZoomLevelModal').off();
        $('#launchZoomLevelModal .btn-info').off();
        $('#inputDirZL').off();
        $('#inputDirZL').on("input", function () {
            // Enable launch button only when boths paths entered.
            $('#launchZoomLevelModal .btn-info')
                .prop("disabled", $('#inputDirZL').val().trim() === "" ||
                    $('#outputDirZL').val().trim() === "");
        });
        $('#outputDirZL').off();
        $('#outputDirZL').on("input", function () {
            // Enable launch button only when boths paths entered.
            $('#launchZoomLevelModal .btn-info')
                .prop("disabled", $('#inputDirZL').val().trim() === "" ||
                    $('#outputDirZL').val().trim() === "");
        });
        $('#launchZoomLevelModal').on('shown.bs.modal', function () {
            $(this).find('#inputDirZL').focus();
        });

        $('#launchZoomLevelModal .btn-info').on('click', function () {
            var inputDir = $('#inputDirZL').val().trim();
            var outputDir = $('#outputDirZL').val().trim();
            var origin = $('#OriginZL').val().trim();
            var tileDim = $('#tileDimZL').val().trim();
            var intensity = $('#intensityZL').val().trim();
            launchZoomLevel(inputDir, outputDir, origin, tileDim, intensity);
        });

        $('#launchZoomLevelModal').modal('show');
    });
}