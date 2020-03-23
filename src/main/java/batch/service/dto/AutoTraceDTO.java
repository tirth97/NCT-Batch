package batch.service.dto;

public class AutoTraceDTO extends DataTransferObject{
    private final String inputDir;
    private final String outputDir;
    private final String datasetId;
    private final String userId;
    private final String origin;
    private final String dim;
    private final String traceSetId;
    private final String seedsMeshSize;
    private final String seedsIntensityThr;
    private final String regionSizeThr;
    private final String eliminateSmallTreesThr;
    private final String eliminateTerminalBranchesThr;
    private final String distanceThr;
    private final String c;

    public AutoTraceDTO(){
        super("auto-trace", "/auto-trace/auto-trace.jar", "at.AutoTrace");
        this.inputDir = null;
        this.outputDir = null;
        this.datasetId = null;
        this.userId = null;
        this.origin = null;
        this.dim = null;
        this.traceSetId = null;
        this.seedsMeshSize = null;
        this.seedsIntensityThr = null;
        this.regionSizeThr = null;
        this.eliminateSmallTreesThr = null;
        this.eliminateTerminalBranchesThr = null;
        this.distanceThr = null;
        this.c = null;
    }

    public AutoTraceDTO(final String inputDir, final String outputDir, final String datasetId, final String userId,
                        final String origin, final String dim, final String traceSetId,
                        final String seedsMeshSize, final String seedsIntensityThr, final String regionSizeThr,
                        final String eliminateSmallTreesThr, final String eliminateTerminalBranchesThr,
                        final String distanceThr, final String c) {
        super("auto-trace",
                "/auto-trace/auto-trace-all.jar",
                "at.AutoTrace");
        this.inputDir = inputDir;
        this.outputDir = outputDir;
        this.datasetId = datasetId;
        this.userId = userId;
        this.origin = origin;
        this.dim = dim;
        this.traceSetId = traceSetId;
        this.seedsMeshSize = seedsMeshSize;
        this.seedsIntensityThr = seedsIntensityThr;
        this.regionSizeThr = regionSizeThr;
        this.eliminateSmallTreesThr = eliminateSmallTreesThr;
        this.eliminateTerminalBranchesThr = eliminateTerminalBranchesThr;
        this.distanceThr = distanceThr;
        this.c = c;
    }

    public String getInputDir() {
        return inputDir;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public String getDatasetId() {
        return datasetId;
    }

    public String getUserId() {
        return userId;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDim() {
        return dim;
    }

    public String getTraceSetId() {
        return traceSetId;
    }

    public String getSeedsMeshSize() {
        return seedsMeshSize;
    }

    public String getSeedsIntensityThr() {
        return seedsIntensityThr;
    }

    public String getRegionSizeThr() {
        return regionSizeThr;
    }

    public String getEliminateSmallTreesThr() {
        return eliminateSmallTreesThr;
    }

    public String getEliminateTerminalBranchesThr() {
        return eliminateTerminalBranchesThr;
    }

    public String getDistanceThr() {
        return distanceThr;
    }

    public String getC() {
        return c;
    }

    @Override
    public String toString() {
        return "AutoTraceDTO{" +
                "inputDir='" + inputDir + '\'' +
                ", outputDir='" + outputDir + '\'' +
                ", datasetId='" + datasetId + '\'' +
                ", userId='" + userId + '\'' +
                ", origin='" + origin + '\'' +
                ", dim='" + dim + '\'' +
                ", traceSetId='" + traceSetId + '\'' +
                ", seedsMeshSize='" + seedsMeshSize + '\'' +
                ", seedsIntensityThr='" + seedsIntensityThr + '\'' +
                ", regionSizeThr='" + regionSizeThr + '\'' +
                ", eliminateSmallTreesThr='" + eliminateSmallTreesThr + '\'' +
                ", eliminateTerminalBranchesThr='" + eliminateTerminalBranchesThr + '\'' +
                ", distanceThr='" + distanceThr + '\'' +
                ", c='" + c + '\'' +
                '}';
    }

    @Override
    public String[] getCommandParameters() {
        return new String[] { this.getInputDir(), this.getOutputDir(), this.getDatasetId(), this.getUserId(),
                this.getOrigin(), this.getDim(), this.getTraceSetId(),
                this.getSeedsMeshSize(), this.getSeedsIntensityThr(), this.getRegionSizeThr(), this.getEliminateSmallTreesThr(),
                this.getEliminateTerminalBranchesThr(), this.getDistanceThr(), this.getC()
        };
    }
}
