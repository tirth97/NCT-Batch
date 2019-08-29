package batch.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mortbay.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;

import batch.dao.BatchDAO;
import batch.service.util.ProcessExecutor;
import batch.service.util.ProcessExecutor.StdOutErrDTO;
import batch.util.JMSMessage;
import batch.util.JMSMessage.statusValues;

/**
 * Service to execute Hadoop MR jobs.
 * @author Joseph Sackett
 * @author wilson.v@husky.neu.edu
 */
@Service("mrExecutorService")
public class MRExecutorService {
	/** Logger. */
	private static final Logger logger = LogManager.getLogger(MRExecutorService.class);
	/** Batch logging service. */
	@Autowired
	private BatchService batchService;
	@Autowired
	private BatchDAO batchDAO;
	/** Hadoop installation root. */
    @Value("${hadoop.root}")
    private String hadoopRoot;
	/** Plugin context root. */
    @Value("${plugin.root}")
    private String pluginRoot;
    @Value("${jdbc.url}")
    private String jdbcURL;

	/** Execute word count MR job, returning result string. */
    public JMSMessage exeWordCount(final String[] varArgs) {
    	final String jarName = pluginRoot + "/word-count/wc-mr.jar";
    	final String mainClassName = "wc.WordCount";

    	//batchService.createBatchLogEntry("Word Count", "Started");
    	deleteLocalDirectory(varArgs[1]);	// second parm is output dir.
		final ProcessBuilder processBuilder = new ProcessBuilder(packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, mainClassName, varArgs));
		final ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);
		try {
			final StdOutErrDTO output = processExecutor.execute();
			if (output.getStderr() != null && !output.getStderr().isEmpty()) {
				logger.info("\n" + output.getStderr());
			}
			if (output.getStdout() != null && !output.getStdout().isEmpty()) {
				logger.info("\n" + output.getStdout());
			}
		} catch (final Exception e) {
			logger.error("Process failed.", e);
	    	//batchService.createBatchLogEntry("Word Count", "Failure");
			return new JMSMessage(null, "Word Count Job Failed.",statusValues.ERROR);
		}
    	//batchService.createBatchLogEntry("Word Count", "Success");
		return new JMSMessage(null, "Word Count Job Completed.", statusValues.SUCCESS);
    }

    /** Execute matrix multiplication MR job, returning a message. */
    public JMSMessage exeMatrixMult(final String[] varArgs) {
    	final String jarName = pluginRoot + "/matrix-mult/seq-pair-mm-recordlimited.jar";
    	// final String mainClassName = "matrixmultiplication.dense.recordlimited.DemoPairMatrixProduct";

    	batchService.createBatchLogEntry("Matrix Multiplication", "Started");
    	//logger.info("\n hadoopRoot=" + hadoopRoot);

    	// TODO: return an error if the output directories already existed
    	deleteLocalDirectory(varArgs[2]);
    	deleteLocalDirectory(varArgs[3]);
    	// TODO: add hadoop system arguments like java heap, memory, etc
    	final ProcessBuilder processBuilder = new ProcessBuilder(
    			packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, new String[]{varArgs[4]}));
    	final ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);
    	try {
    		final StdOutErrDTO output = processExecutor.execute();
    		if (output.getStderr() != null && !output.getStderr().isEmpty()) {
    			logger.info("\n" + output.getStderr());
    		}
    		if (output.getStdout() != null && !output.getStdout().isEmpty()) {
    			logger.info("\n" + output.getStdout());
    		}
    	} catch (final Exception e) {
    		logger.error("Process failed.", e);
        	batchService.createBatchLogEntry("Matrix Multiplication", "Failure");
    		return new JMSMessage(null, "Matrix Multiplication Job Failed.", statusValues.ERROR);
    	}
    	batchService.createBatchLogEntry("Matrix Multiplication", "Success");
    	return new JMSMessage(null, "Matrix Multiplication Job Completed.", statusValues.SUCCESS);
    }

	/** Execute feature extraction MR job, returning result string. */
	public JMSMessage exeFeatureExtraction(final String[] varArgs) {
		final String jarName = pluginRoot + "/feature-extraction/feature-extraction-mr.jar";
		final String mainClassName = "nctracer.Driver";

		batchService.createBatchLogEntry("Feature Extraction", "Started");
		deleteLocalDirectory(varArgs[1]);	// second parm is output dir.
		final ProcessBuilder processBuilder = new ProcessBuilder(packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, mainClassName, varArgs));
		final ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);
		try {
			final StdOutErrDTO output = processExecutor.execute();
			if (output.getStderr() != null && !output.getStderr().isEmpty()) {
				logger.info("\n" + output.getStderr());
			}
			if (output.getStdout() != null && !output.getStdout().isEmpty()) {
				logger.info("\n" + output.getStdout());
			}
		} catch (final Exception e) {
			logger.error("Process failed.", e);
			batchService.createBatchLogEntry("Feature Extraction", "Failure");
			return new JMSMessage(null, "Feature Extraction Job Failed.", statusValues.ERROR);
		}
		batchService.createBatchLogEntry("Feature Extraction", "Success");
		return new JMSMessage(null,"Feature Extraction Job Completed.",statusValues.SUCCESS);
	}

	/** Execute image stitching MR job, returning result string. */
	public JMSMessage exeImageStitching(final String[] varArgs) {
		final String jarName = pluginRoot + "/image-stitching/image-stitching-mr.jar";
		final String mainClassName = "neu.nctracer.driver.Driver";

		batchService.createBatchLogEntry("Image Stitching", "Started");
		deleteLocalDirectory(varArgs[1]);	// second parm is output dir.
		final ProcessBuilder processBuilder = new ProcessBuilder(packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, mainClassName, varArgs));
		final ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);
		try {
			final StdOutErrDTO output = processExecutor.execute();
			if (output.getStderr() != null && !output.getStderr().isEmpty()) {
				logger.info("\n" + output.getStderr());
			}
			if (output.getStdout() != null && !output.getStdout().isEmpty()) {
				logger.info("\n" + output.getStdout());
			}
		} catch (final Exception e) {
			logger.error("Process failed.", e);
			batchService.createBatchLogEntry("Image Stitching", "Failure");
			return new JMSMessage(null, "Image Stitching Job Failed.", statusValues.ERROR);
		}
		batchService.createBatchLogEntry("Image Stitching", "Success");
		return new JMSMessage(null, "Image Stitching Job Completed.", statusValues.SUCCESS);
	}

    /** Execute ImageJ Gaussian MR job, returning a message. */
    public JMSMessage exeImagejGaussian(final String[] varArgs) {
    	final String jarName = pluginRoot + "/image-filter/WholeImageFilterImageJ.jar";
    	final String mainClassName = "hadoop.wholefile.WholeImageFilterImageJ";

    	batchService.createBatchLogEntry("ImageJ Gaussian Filter", "Started");

    	// TODO: check out why the mainClass cannot be included when submitting a hadoop job in command line
    	final ProcessBuilder processBuilder = new ProcessBuilder(packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, varArgs));
    	final ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);
    	try {
    		final StdOutErrDTO output = processExecutor.execute();
    		if (output.getStderr() != null && !output.getStderr().isEmpty()) {
    			logger.info("\n" + output.getStderr());
    		}
    		if (output.getStdout() != null && !output.getStdout().isEmpty()) {
    			logger.info("\n" + output.getStdout());
    		}
    	} catch (final Exception e) {
    		logger.error("Process failed.", e);
        	batchService.createBatchLogEntry("ImageJ Gaussian Filter", "Failure");
    		return new JMSMessage(null, "ImageJ Gaussian Filtering Job Failed.", statusValues.ERROR);
    	}
    	batchService.createBatchLogEntry("ImageJ Gaussian Filter", "Success");
    	return new JMSMessage(null, "ImageJ Gaussian Filtering Job Completed.", statusValues.SUCCESS);
    }
    
    /** Execute ImageJ FFT MR job, returning a message. */
    public JMSMessage exeImagejFFT(final String[] varArgs) {
    	final String jarName = pluginRoot + "/image-filter/??.jar"; // TODO: complete the jar name
    	final String mainClassName = "hadoop.??";

    	batchService.createBatchLogEntry("ImageJ FFT", "Started");

    	final ProcessBuilder processBuilder = new ProcessBuilder(packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, varArgs));
    	final ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);
    	try {
    		final StdOutErrDTO output = processExecutor.execute();
    		if (output.getStderr() != null && !output.getStderr().isEmpty()) {
    			logger.info("\n" + output.getStderr());
    		}
    		if (output.getStdout() != null && !output.getStdout().isEmpty()) {
    			logger.info("\n" + output.getStdout());
    		}
    	} catch (final Exception e) {
    		logger.error("Process failed.", e);
        	batchService.createBatchLogEntry("ImageJ FFT Bandpass", "Failure");
    		return new JMSMessage(null, "ImageJ FFT Job Failed.", statusValues.ERROR);
    	}
    	batchService.createBatchLogEntry("ImageJ FFT Bandpass", "Success");
    	return new JMSMessage(null, "ImageJ FFT Job Completed.", statusValues.SUCCESS);
    }

    /** Execute ImageJ Gaussian (write to DB) MR job, returning a message. */
    public JMSMessage exeImagejGaussianDB(final String[] varArgs) {
    	// insert an entry into the image table, returning the auto-generated image_id
    	String imageName = varArgs[varArgs.length - 1];
        final int imageId = batchDAO.insertImage(imageName);
        
        // set arguments for the Hadoop mapreduce job
    	final String jarName = pluginRoot + "/image-filter/WholeImageIJgaussianWriteDB.jar";
    	final String mainClassName = "hadoop.wholefile.WholeImageIJgaussianWriteDB";
    	String[] dbArgs = new String[varArgs.length + 1];
    	System.arraycopy(varArgs, 0, dbArgs, 0, varArgs.length - 2);
    	dbArgs[dbArgs.length - 3] = jdbcURL;
    	dbArgs[dbArgs.length - 2] = String.valueOf(imageId);
    	dbArgs[dbArgs.length - 1] = imageName;

    	batchService.createBatchLogEntry("ImageJ Gaussian Filter (Write DB)", "Started");

    	// TODO: check out why the mainClass cannot be included when submitting a hadoop job in command line
    	final ProcessBuilder processBuilder = new ProcessBuilder(packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, dbArgs));
    	final ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);
    	try {
    		final StdOutErrDTO output = processExecutor.execute();
    		if (output.getStderr() != null && !output.getStderr().isEmpty()) {
    			logger.info("\n" + output.getStderr());
    		}
    		if (output.getStdout() != null && !output.getStdout().isEmpty()) {
    			logger.info("\n" + output.getStdout());
    		}
    	} catch (final Exception e) {
    		logger.error("Process failed.", e);
        	batchService.createBatchLogEntry("ImageJ Gaussian Filter (Write DB)", "Failure");
    		return new JMSMessage(null, "ImageJ Gaussian Filtering Job (Write DB) Failed.", statusValues.ERROR);
    	}
    	batchService.createBatchLogEntry("ImageJ Gaussian Filter (Write DB)", "Success");
    	return new JMSMessage(null, "ImageJ Gaussian Filtering Job (Write DB) Completed.", statusValues.SUCCESS);
    }
    
    /** Execute ImageJ FFT MR job, returning a message. */
    public JMSMessage exeImagejFFTDB(final String[] varArgs) {
    	// insert an entry into the image table, returning the auto-generated image_id
    	String imageName = varArgs[varArgs.length - 1];
        final int imageId = batchDAO.insertImage(imageName);
        
        // set arguments for the Hadoop mapreduce job
    	final String jarName = pluginRoot + "/image-filter/WholeImageIJFFTWriteDB.jar"; // TODO: complete the jar name
    	final String mainClassName = "hadoop.wholefile.WholeImageIJFFTDB";
    	String[] dbArgs = new String[varArgs.length + 1];
    	System.arraycopy(varArgs, 0, dbArgs, 0, varArgs.length);
    	dbArgs[dbArgs.length - 3] = String.valueOf(imageId);
    	dbArgs[dbArgs.length - 1] = jdbcURL;

    	batchService.createBatchLogEntry("ImageJ FFT (Write DB)", "Started");

    	final ProcessBuilder processBuilder = new ProcessBuilder(packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, dbArgs));
    	final ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);
    	try {
    		final StdOutErrDTO output = processExecutor.execute();
    		if (output.getStderr() != null && !output.getStderr().isEmpty()) {
    			logger.info("\n" + output.getStderr());
    		}
    		if (output.getStdout() != null && !output.getStdout().isEmpty()) {
    			logger.info("\n" + output.getStdout());
    		}
    	} catch (final Exception e) {
    		logger.error("Process failed.", e);
        	batchService.createBatchLogEntry("ImageJ FFT (Write DB)", "Failure");
    		return new JMSMessage(null, "ImageJ FFT (Write DB) Job Failed.", statusValues.ERROR);
    	}
    	batchService.createBatchLogEntry("ImageJ FFT Bandpass (Write DB)", "Success");
    	return new JMSMessage(null, "ImageJ FFT (Write DB) Job Completed.", statusValues.SUCCESS);
    }

    /** Execute ImageJ Threshold MR job, returning a message. */
    public JMSMessage exeImagejThresholdDB(final String[] varArgs) {
    	// insert an entry into the image table, returning the auto-generated image_id
    	String imageName = varArgs[varArgs.length - 1];
        final int imageId = batchDAO.insertImage(imageName);
        
        // set arguments for the Hadoop mapreduce job
    	final String jarName = pluginRoot + "/image-filter/WholeImageIJThresholdWriteDB.jar"; // TODO: complete the jar name
    	final String mainClassName = "hadoop.wholefile.WholeImageIJThresholdDB";
    	String[] dbArgs = new String[varArgs.length + 1];
    	System.arraycopy(varArgs, 0, dbArgs, 0, varArgs.length);
    	dbArgs[dbArgs.length - 3] = String.valueOf(imageId);
    	dbArgs[dbArgs.length - 1] = jdbcURL;

    	//batchService.createBatchLogEntry("ImageJ Threshold (Write DB)", "Started");

    	final ProcessBuilder processBuilder = new ProcessBuilder(packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, dbArgs));
    	final ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);
    	try {
    		final StdOutErrDTO output = processExecutor.execute();
    		if (output.getStderr() != null && !output.getStderr().isEmpty()) {
    			logger.info("\n" + output.getStderr());
    		}
    		if (output.getStdout() != null && !output.getStdout().isEmpty()) {
    			logger.info("\n" + output.getStdout());
    		}
    	} catch (final Exception e) {
    		logger.error("Process failed.", e);
        	//batchService.createBatchLogEntry("ImageJ Threshold (Write DB)", "Failure");
    		return new JMSMessage(null,"ImageJ Threshold (Write DB) Job Failed.",statusValues.ERROR);
    	}
    	//batchService.createBatchLogEntry("ImageJ Threshold (Write DB)", "Success");
    	return new JMSMessage(null, "ImageJ Threshold (Write DB) Job Completed.", statusValues.SUCCESS);
    }

    /** Execute ImageJ Gaussian (write to DB) MR job, returning a message. */
    public JMSMessage exeMatlabGaussianDB(final String[] varArgs) {
    	// insert an entry into the image table, returning the auto-generated image_id
    	String imageName = varArgs[varArgs.length - 1];
        final int imageId = batchDAO.insertImage(imageName);
        
        // set arguments for the Hadoop mapreduce job
    	final String jarName = pluginRoot + "/image-filter/WholeImageMatlabGaussianDB.jar";
    	final String mainClassName = "hadoop.wholefile.WholeImageMatlabGaussianWriteDB";
    	String[] dbArgs = new String[varArgs.length + 2];
    	System.arraycopy(varArgs, 0, dbArgs, 0, varArgs.length - 1);
    	dbArgs[dbArgs.length - 3] = jdbcURL;
    	dbArgs[dbArgs.length - 2] = String.valueOf(imageId);
    	dbArgs[dbArgs.length - 1] = imageName;

    	//batchService.createBatchLogEntry("Matlab Gaussian Filter (Write DB)", "Started");
    	logger.info("\n exeMatlabGaussianDB: number of args is " + dbArgs.length);
    	logger.info("\n args: " + Arrays.toString(dbArgs));
    	final ProcessBuilder processBuilder = new ProcessBuilder(packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, dbArgs));
    	final ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);
    	try {
    		final StdOutErrDTO output = processExecutor.execute();
    		if (output.getStderr() != null && !output.getStderr().isEmpty()) {
    			logger.info("\n" + output.getStderr());
    		}
    		if (output.getStdout() != null && !output.getStdout().isEmpty()) {
    			logger.info("\n" + output.getStdout());
    		}
    	} catch (final Exception e) {
    		logger.error("Process failed.", e);
        	//batchService.createBatchLogEntry("Matlab Gaussian Filter (Write DB)", "Failure");
    		return new JMSMessage(null, "Matlab Gaussian Filtering Job (Write DB) Failed.", statusValues.ERROR);
    	}
    	//batchService.createBatchLogEntry("Matlab Gaussian Filter (Write DB)", "Success");
    	return new JMSMessage(null, "Matlab Gaussian Filtering Job (Write DB) Completed.", statusValues.SUCCESS);
    }
    
    /** Execute ImageJ Gaussian (write to File) MR job, returning a message. */
    public JMSMessage exeMatlabGaussian(final String[] varArgs) {
        // set arguments for the Hadoop mapreduce job
    	final String jarName = pluginRoot + "/image-filter/WholeImageMatlabGaussian.jar";
    	final String mainClassName = "hadoop.wholefile.WholeImageMatlabGaussian";
    	
    	logger.info("\n exeMatlabGaussian: number of args is " + varArgs.length);
    	logger.info("\n args: " + Arrays.toString(varArgs));
    	final ProcessBuilder processBuilder = new ProcessBuilder(packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, varArgs));
    	final ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);
    	try {
    		final StdOutErrDTO output = processExecutor.execute();
    		if (output.getStderr() != null && !output.getStderr().isEmpty()) {
    			logger.info("\n" + output.getStderr());
    		}
    		if (output.getStdout() != null && !output.getStdout().isEmpty()) {
    			logger.info("\n" + output.getStdout());
    		}
    	} catch (final Exception e) {
    		logger.error("Process failed.", e);
    		return new JMSMessage(null, "Matlab Gaussian Filtering Job Failed.", statusValues.ERROR);
    	}
    	return new JMSMessage(null, "Matlab Gaussian Filtering Job Completed.", statusValues.SUCCESS);
    }
    
//	/** Delete HDFS directory. */
//	private void deleteHdfsDirectory(final String dirName) throws Exception {
//		final ProcessBuilder processBuilder = new ProcessBuilder(localHadoopPrefix + "/bin/hdfs", "dfs", "-rm", "-r", "-f", dirName);
//		final ProcessExeService processExecutor = new ProcessExeService(processBuilder);
//		processExecutor.execute();
//	}

	/** Delete local directory (by name). */
	private static boolean deleteLocalDirectory(final String dirName) {
		final File directory = new File(dirName);
		return deleteLocalDirectory(directory);
	}

	/** Recursively delete local directory. */
	private static boolean deleteLocalDirectory(final File directory) {
		if (!directory.exists() || !directory.isDirectory()) {
			return false;
		}
        final File[] files = directory.listFiles();
        if (files != null){
            for (final File file : files) {
                if(file.isDirectory()) {
                	deleteLocalDirectory(file);
                }
                else {
                	file.delete();
                }
            }
        }
	    return directory.delete();
	}

	private static final int numStaticPack = 4;
	/** Helper method to organize driver application's command line arguments for process execution. */
	private static String[] packVarArgs(final String arg0, final String arg1, final String arg2, final String arg3, final String[] varArgs) {
		final String[] argsOut = new String[varArgs.length + numStaticPack];
		argsOut[0] = arg0;
		argsOut[1] = arg1;
		argsOut[2] = arg2;
		argsOut[3] = arg3;
		for (int ix = numStaticPack ; ix < varArgs.length + numStaticPack ; ix++) {
			argsOut[ix] = varArgs[ix - numStaticPack];
		}
		return argsOut;
	}
	
	/** Helper method to organize driver application's command line arguments without the mainClass specified. */
	private static String[] packVarArgs (final String hadoopHome, final String jar, final String jarName, final String[] varArgs) {
		final int numPreArgs = 3;
		final String[] argsOut = new String[varArgs.length + numPreArgs];
		argsOut[0] = hadoopHome;
		argsOut[1] = jar;
		argsOut[2] = jarName;
		for (int ix = numPreArgs; ix < varArgs.length + numPreArgs; ix++) {
			argsOut[ix] = varArgs[ix - numPreArgs];
		}
		return argsOut;
	}

	/** Execute feature extraction and matching MR job, returning seeds points matching.*/
	public JMSMessage exeFeatureExtractMatch(final String[] varArgs) {
		final String jarName = pluginRoot + "/feature-extract-match/fem-mr-all.jar";
		final String mainClassName = "fem.FeatureExtractMatch";

		//batchService.createBatchLogEntry("Word Count", "Started");
		deleteLocalDirectory(varArgs[1]);	// second parm is output dir.
		final ProcessBuilder processBuilder = new ProcessBuilder(packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, mainClassName, varArgs));
		final ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);
		try {
			final StdOutErrDTO output = processExecutor.execute();
			if (output.getStderr() != null && !output.getStderr().isEmpty()) {
				logger.info("\n" + output.getStderr());
			}
			if (output.getStdout() != null && !output.getStdout().isEmpty()) {
				logger.info("\n" + output.getStdout());
			}
		} catch (final Exception e) {
			logger.error("Process failed.", e);
			//batchService.createBatchLogEntry("Feature Extraction and Matching", "Failure");
			return new JMSMessage(null, "Feature Extraction and Matching Job Failed.", statusValues.ERROR);
		}
		//batchService.createBatchLogEntry("Feature Extraction and Matching", "Success");
		return new JMSMessage(null, "Feature Extraction and Matching Job Completed.", statusValues.SUCCESS);
	}

	public JMSMessage exeRetile(final String[] varArgs) {
		//todo: delete history
		final String jarName = pluginRoot + "/retiling/Retiling-all.jar";
		final String mainClassName = "retiling.RetilingMR";


		final ProcessBuilder processBuilder = new ProcessBuilder(packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, mainClassName, varArgs));
		final ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);
		try {
			final StdOutErrDTO output = processExecutor.execute();
			if (output.getStderr() != null && !output.getStderr().isEmpty()) {
				logger.info("\n" + output.getStderr());
			}
			if (output.getStdout() != null && !output.getStdout().isEmpty()) {
				logger.info("\n" + output.getStdout());
			}
		} catch (final Exception e) {
			logger.error("Process failed.", e);
			return new JMSMessage(null,"Retiling Job Failed.",statusValues.ERROR);
		}
		return new JMSMessage(null, "Retiling Job Completed.", statusValues.SUCCESS);
	}

	/** Execute Zoom Level and matching MR job, returning seeds points matching.
	 * @param varArgs : arguments to be passed to zoom-level MR job
	 * varArgs contents : 
	 * [input directory,
	 * output directory,
	 * Global Origin, 
	 * Input Tile Dimentions,
	 * Dummy Tile Pixel Intensity]
	 */
	public JMSMessage exeZoomLevel(final String[] varArgs) {
				
		final String jarName = pluginRoot + "/zoom-level/zoom-level-gradle-all.jar";
		final String mainClassName = "zl.App";


		final ProcessBuilder processBuilder = new ProcessBuilder(packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, mainClassName, varArgs));
		final ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);
		try {
			final StdOutErrDTO output = processExecutor.execute();
			if (output.getStderr() != null && !output.getStderr().isEmpty()) {
				logger.info("\n" + output.getStderr());
			}
			if (output.getStdout() != null && !output.getStdout().isEmpty()) {
				logger.info("\n" + output.getStdout());
			}
		} catch (final Exception e) {
			logger.error("Process failed.", e);
			return new JMSMessage(null, "Zoom Level Job Failed.", statusValues.ERROR);
		}
		return new JMSMessage(null, "Zoom Level Job Completed.", statusValues.SUCCESS);
	}

	/**
	 * Execute dist-ftp MapReduce job to copy to HDFS
	 * @param varArgs
	 */
	public JMSMessage exeToHdfs(final String [] varArgs) {
		final String jarName = pluginRoot + "/dist-ftp/dist-ftp-all.jar";

		final ProcessBuilder processBuilder = new ProcessBuilder(packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, varArgs));
		final ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);
		try {
			final StdOutErrDTO output = processExecutor.execute();
			if (output.getStderr() != null && !output.getStderr().isEmpty()) {
				logger.info("\n" + output.getStderr());
			}
			if (output.getStdout() != null && !output.getStdout().isEmpty()) {
				logger.info("\n" + output.getStdout());
			}
		} catch (final Exception e) {
			logger.error("Process failed.", e);
			return new JMSMessage(null, "To Hdfs Job Failed.", statusValues.ERROR);
		}
		Log.info("Job Complete");
		return new JMSMessage(null, "To Hdfs Job Completed.", statusValues.SUCCESS);
	}


	/**
	 * Execute dist-ftp MapReduce job to copy from HDFS
	 * @param varArgs
	 */
	public JMSMessage exeFromHdfs(final String [] varArgs) {
		final String jarName = pluginRoot + "/dist-ftp/dist-ftp-all.jar";

		final ProcessBuilder processBuilder = new ProcessBuilder(packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, varArgs));
		final ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);
		try {
			final StdOutErrDTO output = processExecutor.execute();
			if (output.getStderr() != null && !output.getStderr().isEmpty()) {
				logger.info("\n" + output.getStderr());
			}
			if (output.getStdout() != null && !output.getStdout().isEmpty()) {
				logger.info("\n" + output.getStdout());
			}
		} catch (final Exception e) {
			logger.error("Process failed.", e);
			return new JMSMessage(null, "From Hdfs Job Failed.", statusValues.ERROR);
		}
		Log.info("Job Complete");
		return new JMSMessage(null, "From Hdfs Job Completed.", statusValues.SUCCESS);
	}

}
