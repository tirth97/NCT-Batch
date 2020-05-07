package batch.service;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import batch.service.util.ProcessExecutor;
import batch.service.util.ProcessExecutor.StdOutErrDTO;
import batch.util.JMSMessage;
import batch.util.JMSMessage.statusValues;
import batch.service.dto.DataTransferObject;

/**
 * Service to execute Hadoop MR jobs.
 * 
 * @author Joseph Sackett
 * @author wilson.v@husky.neu.edu
 */
@Service("mrExecutorService")
public class MRExecutorService {
	/** Logger. */
	private static final Logger logger = LogManager.getLogger(MRExecutorService.class);

	/** Hadoop installation root. */
	@Value("${hadoop.root}")
	private String hadoopRoot;

	/** Plugin context root. */
	@Value("${plugin.root}")
	private String pluginRoot;

	@Value("${jdbc.url}")
	private String jdbcURL;

	/**
	 * Execute a Hadoop Job
	 */
	public JMSMessage execHadoopJob(DataTransferObject dto) {

		String jarName = pluginRoot + dto.getJar();
		String mainClassName = dto.getClassName();
		String[] args;

		if (mainClassName == null) {
			args = packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, dto.getToken(), dto.getCommandParameters());
		} else {
			args = packVarArgs(hadoopRoot + "/bin/hadoop", "jar", jarName, mainClassName, dto.getToken(),
					dto.getCommandParameters());

			// todo, delete
			logger.info(dto.getCommandParameters().length);
			for (String arg : dto.getCommandParameters()) {
				logger.info(arg);
			}
			logger.info(args.length);

		}

		ProcessBuilder processBuilder = new ProcessBuilder(args);
		ProcessExecutor processExecutor = new ProcessExecutor(processBuilder);

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
			return new JMSMessage(dto.getToken(), dto.getJob() + " Job Failed.", statusValues.ERROR);
		}
		return new JMSMessage(dto.getToken(), dto.getJob() + " Job Completed.", statusValues.SUCCESS);
	}

	/**
	 * Kill a RUNNING hadoop job
	 * 
	 * @param token
	 * @return JMSmessage status of the kill execution
	 * @throws IOException
	 * 
	 */
	public JMSMessage killHadoopJob(String token) throws IOException {

		String [] command = new String [] {"/bin/bash","-c","yarn application -list  -appTags='"+token+"' | awk 'NR > 2 { print $1}' | xargs -I {} yarn application -kill {}"};
		String tmp = "";
		for(String t : command){
			tmp += t + " ";
		}
		logger.info("====== COMMAND EXECUTED : "+tmp);
		ProcessBuilder processBuilder = new ProcessBuilder(command);
		processBuilder.start();
		return new JMSMessage(token,"Job Killed.",statusValues.SUCCESS);
	}

	
	/** Helper method to organize driver application's command line arguments for process execution. */
	private static String[] packVarArgs(final String arg0, final String arg1, final String arg2, final String arg3, final String tag, final String[] varArgs) {
		final int numStaticPack = 6;
		final String[] argsOut = new String[varArgs.length + numStaticPack];
		argsOut[0] = arg0;
		argsOut[1] = arg1;
		argsOut[2] = arg2;
		// Adding tag to easily recognize jobs started on this "tag" pipeline
		argsOut[3] = "-D";
		argsOut[4] = "mapreduce.job.tags="+tag;
		argsOut[5] = arg3;
		for (int ix = numStaticPack ; ix < varArgs.length + numStaticPack ; ix++) {
			argsOut[ix] = varArgs[ix - numStaticPack];
		}
		return argsOut;
	}
	
	/** Helper method to organize driver application's command line arguments without the mainClass specified. */
	private static String[] packVarArgs (final String hadoopHome, final String jar, final String jarName, final String tag, final String[] varArgs) {
		final int numPreArgs = 5;
		final String[] argsOut = new String[varArgs.length + numPreArgs];
		argsOut[0] = hadoopHome;
		argsOut[1] = jar;
		argsOut[2] = jarName;
		// Adding tag to easily recognize jobs started on this "tag" pipeline
		argsOut[3] = "-D";
		argsOut[4] = "mapreduce.job.tags="+tag;
		for (int ix = numPreArgs; ix < varArgs.length + numPreArgs; ix++) {
			argsOut[ix] = varArgs[ix - numPreArgs];
		}
		return argsOut;
	}
}