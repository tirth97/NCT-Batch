function launchAutoTrace(inputDir, outputDir, datasetId, userId, origin, dim, traceSetId, seedsMeshSize, seedsIntensityThr,
regionSizeThr, eliminateSmallTreesThr, eliminateTerminalBranchesThr, distanceThr, c) {
    // Ajax call to launch feature extraction job.
    var dto = JSON.stringify({
        "inputDir": inputDir ,
        "outputDir": outputDir,
        "datasetId": datasetId,
        "userId": userId,
        "origin": origin,
        "dim": dim,
        "traceSetId": traceSetId,
        "seedsMeshSize": seedsMeshSize,
        "seedsIntensityThr": seedsIntensityThr,
        "regionSizeThr": regionSizeThr,
        "eliminateSmallTreesThr": eliminateSmallTreesThr,
        "eliminateTerminalBranchesThr": eliminateTerminalBranchesThr,
        "distanceThr": distanceThr,
        "c": c
    });

    $.post({
        url: "autoTrace",
        contentType: "application/json",
        data: dto,
        cache: false,
        timeout: 2000
    })
        .done(function () {
            console.log("Auto Trace Launched.");
        })
        .fail(function () {
            console.log("Problem Launching Auto Trace job.");
        });
}

function initAutoTracePlugin() {
    // Initializes the feature extraction plugin UI.
    $('#autoTraceButton').on('click', function () {
        $('#launchAutoTraceModal').off();
        $('#launchAutoTraceModal .btn-info').off();
        $('#inputDirAT').off();
        $('#inputDirAT').on("input", function () {
            // Enable launch button only when boths paths entered.
            $('#launchAutoTraceModal .btn-info')
                .prop("disabled", $('#inputDirAT').val().trim() === "" ||
                    $('#outputDirAT').val().trim() === "");
        });
        $('#outputDirAT').off();
        $('#outputDirAT').on("input", function () {
            // Enable launch button only when boths paths entered.
            $('#launchAutoTraceModal .btn-info')
                .prop("disabled", $('#inputDirAT').val().trim() === "" ||
                    $('#outputDirZL').val().trim() === "");
        });
        $('#launchAutoTraceModal').on('shown.bs.modal', function () {
            $(this).find('#inputDirAT').focus();
        });

        $('#launchAutoTraceModal .btn-info').on('click', function () {
            var inputDir = $('#inputDirAT').val().trim();
            var outputDir = $('#outputDirAT').val().trim();
            var datasetId = $('#datasetIdAT').val().trim();
            var userId = $('#userIdAT').val().trim();
            var origin = $('#originAT').val().trim();
            var dim = $('#dimAT').val().trim();
            var traceSetId = $('#traceSetIdAT').val().trim();
            var seedsMeshSize = $('#seedsIntensityThrAT').val().trim();
            var seedsIntensityThr = $('#seedsIntensityThrAT').val().trim();
            var regionSizeThr = $('#regionSizeThrAT').val().trim();
            var eliminateSmallTreesThr = $('#eliminateSmallTreesThr').val().trim();
            var eliminateTerminalBranchesThr = $('#eliminateTerminalBranchesThrAT').val().trim();
            var distanceThr = $('#distanceThrAT').val().trim();
            var c = $('#cAT').val().trim();

            launchAutoTrace(inputDir, outputDir, datasetId, userId, origin, dim, traceSetId, seedsMeshSize, seedsIntensityThr,
                regionSizeThr, eliminateSmallTreesThr, eliminateTerminalBranchesThr, distanceThr, c);
        });

        $('#launchAutoTraceModal').modal('show');
    });
}