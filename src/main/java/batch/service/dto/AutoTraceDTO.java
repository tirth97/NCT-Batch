package batch.service.dto;

public class AutoTraceDTO extends DataTransferObject{
    private final String inputDir;
    private final String outputDir;
    private final String datasetId;
    private final String userId;
    private final String origin;
    private final String dim;
    private final String numTiles;
    private final String traceSetId;
    private final String seedsMeshSize;
    private final String seedsIntensityThr;
    private final String regionSizeThr;
    private final String eliminateSmallTreesThr;
    private final String eliminateTerminalBranchesThr;
    private final String rTypical;
    private final String optimizeBps;
    private final String optimizeTps;
    private final String pointsPerUm;
    private final String maxIterations;
    private final String alphaR;
    private final String bettaR;
    private final String adjustPpm;
    private final String distanceThr;
    private final String c;
    private final String pairsPerReducer;

    public AutoTraceDTO(){
        super("auto-trace", "/auto-trace/auto-trace.jar", "at.AutoTrace");
        this.inputDir = null;
        this.outputDir = null;
        this.datasetId = null;
        this.userId = null;
        this.origin = null;
        this.dim = null;
        this.numTiles = null;
        this.traceSetId = null;
        this.seedsMeshSize = null;
        this.seedsIntensityThr = null;
        this.regionSizeThr = null;
        this.eliminateSmallTreesThr = null;
        this.eliminateTerminalBranchesThr = null;
        this.rTypical = null;
        this.optimizeBps = null;
        this.optimizeTps = null;
        this.pointsPerUm = null;
        this.maxIterations = null;
        this.alphaR = null;
        this.bettaR = null;
        this.adjustPpm = null;
        this.distanceThr = null;
        this.c = null;
        this.pairsPerReducer = null;
    }

    public AutoTraceDTO(final String inputDir, final String outputDir, final String datasetId, final String userId,
                        final String origin, final String dim, final String numTiles, final String traceSetId,
                        final String seedsMeshSize, final String seedsIntensityThr, final String regionSizeThr,
                        final String eliminateSmallTreesThr, final String eliminateTerminalBranchesThr,
                        final String rTypical, final String optimizeBps, final String optimizeTps, final String pointsPerUm,
                        final String maxIterations, final String alphaR, final String bettaR, final String adjustPpm,
                        final String distanceThr, final String c, final String pairsPerReducer) {
        super("auto-trace",
                "/auto-trace/auto-trace-all.jar",
                "at.AutoTrace");
        this.inputDir = inputDir;
        this.outputDir = outputDir;
        this.datasetId = datasetId;
        this.userId = userId;
        this.origin = origin;
        this.dim = dim;
        this.numTiles = numTiles;
        this.traceSetId = traceSetId;
        this.seedsMeshSize = seedsMeshSize;
        this.seedsIntensityThr = seedsIntensityThr;
        this.regionSizeThr = regionSizeThr;
        this.eliminateSmallTreesThr = eliminateSmallTreesThr;
        this.eliminateTerminalBranchesThr = eliminateTerminalBranchesThr;
        this.rTypical = rTypical;
        this.optimizeBps = optimizeBps;
        this.optimizeTps = optimizeTps;
        this.pointsPerUm = pointsPerUm;
        this.maxIterations = maxIterations;
        this.alphaR = alphaR;
        this.bettaR = bettaR;
        this.adjustPpm = adjustPpm;
        this.distanceThr = distanceThr;
        this.c = c;
        this.pairsPerReducer = pairsPerReducer;
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

    public String getNumTiles() {
        return numTiles;
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

    public String getrTypical() {
        return rTypical;
    }

    public String getOptimizeBps() {
        return optimizeBps;
    }

    public String getOptimizeTps() {
        return optimizeTps;
    }

    public String getPointsPerUm() {
        return pointsPerUm;
    }

    public String getMaxIterations() {
        return maxIterations;
    }

    public String getAlphaR() {
        return alphaR;
    }

    public String getBettaR() {
        return bettaR;
    }

    public String getAdjustPpm() {
        return adjustPpm;
    }

    public String getDistanceThr() {
        return distanceThr;
    }

    public String getC() {
        return c;
    }

    public String getPairsPerReducer() { return pairsPerReducer; }

    @Override
    public String toString() {
        return "AutoTraceDTO{" +
                "inputDir='" + inputDir + '\'' +
                ", outputDir='" + outputDir + '\'' +
                ", datasetId='" + datasetId + '\'' +
                ", userId='" + userId + '\'' +
                ", origin='" + origin + '\'' +
                ", dim='" + dim + '\'' +
                ", numTiles='" + numTiles + '\'' +
                ", traceSetId='" + traceSetId + '\'' +
                ", seedsMeshSize='" + seedsMeshSize + '\'' +
                ", seedsIntensityThr='" + seedsIntensityThr + '\'' +
                ", regionSizeThr='" + regionSizeThr + '\'' +
                ", eliminateSmallTreesThr='" + eliminateSmallTreesThr + '\'' +
                ", eliminateTerminalBranchesThr='" + eliminateTerminalBranchesThr + '\'' +
                ", rTypical='" + rTypical + '\'' +
                ", optimizeBps='" + optimizeBps + '\'' +
                ", optimizeTps='" + optimizeTps + '\'' +
                ", pointsPerUm='" + pointsPerUm + '\'' +
                ", maxIterations='" + maxIterations + '\'' +
                ", alphaR='" + alphaR + '\'' +
                ", bettaR='" + bettaR + '\'' +
                ", adjustPpm='" + adjustPpm + '\'' +
                ", distanceThr='" + distanceThr + '\'' +
                ", c='" + c + '\'' +
                ", pairsPerReducer='" + pairsPerReducer + '\'' +
                '}';
    }

    @Override
    public String[] getCommandParameters() {
        return new String[] { this.getInputDir(), this.getOutputDir(), this.getDatasetId(), this.getUserId(),
                this.getOrigin(), this.getDim(), this.getNumTiles(), this.getTraceSetId(),
                this.getSeedsMeshSize(), this.getSeedsIntensityThr(), this.getRegionSizeThr(), this.getEliminateSmallTreesThr(),
                this.getEliminateTerminalBranchesThr(), this.getrTypical(), this.getOptimizeBps(), this.getOptimizeTps(),
                this.getPointsPerUm(), this.getMaxIterations(), this.getAlphaR(), this.getBettaR(), this.getAdjustPpm(),
                this.getDistanceThr(), this.getC(), this.getPairsPerReducer()
        };
    }
}
