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
package batch.service.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Executes a process and asynchronously logs process' stdout and stderr.
 * @author Joseph Sackett
 */
public class ProcessExecutor {
	/** Logger. */
	private static final Logger logger = LogManager.getLogger(ProcessExecutor.class);
	/** Process to execute. */
	private final ProcessBuilder processBuilder;

	/**
	 * Constructor.
	 * @param processBuilder Process to execute.
	 */
	public ProcessExecutor(final ProcessBuilder processBuilder) {
		this.processBuilder = processBuilder;
	}

	/** Execute the process and asynchronously outputs process' stdout and stderr. */
	public StdOutErrDTO execute() throws Exception {
		Process process;
		process = processBuilder.start();
		final ReaderThread stdoutReader = new ReaderThread(process.getInputStream());
		final ReaderThread stderrReader = new ReaderThread(process.getErrorStream());
		new Thread(stdoutReader).start();
		new Thread(stderrReader).start();
		process.waitFor();
		if (process.exitValue() > 0) {
			logger.error(processBuilder + ": process error.");
			throw new RuntimeException("Error executing process: " + processBuilder.toString());
		}
		return new StdOutErrDTO(stdoutReader.getLines(), stderrReader.getLines());
	}

	/**
	 * Runnable to asynchronously read input stream and concatenate results.
	 */
	private static class ReaderThread implements Runnable {
		/** Input stream reader. */
		private final BufferedReader reader;
		/** String concatenating input lines. */
		private String lines = "";

		public ReaderThread(final InputStream inStream) {
			this.reader = new BufferedReader(new InputStreamReader(inStream));
		}

		/** Thread loops until stream closes, echoing input to output. */
		@Override
		public void run() {
			try {
				String line;
				while ((line = reader.readLine()) != null) {
					lines += line;
					lines += '\n';
				}
				reader.close();
			} catch (final IOException e) {
				logger.error("Execution error.", e);
			}
		}

		public String getLines() {
			return lines;
		}
	}

	/**
	 * Return tuple containing stdout & stdin.
	 */
	public static class StdOutErrDTO {
		/** Stdout. */
		private final String stdout;
		/** Stderr. */
		private final String stderr;

		public StdOutErrDTO(final String stdout, final String stderr) {
			super();
			this.stdout = stdout;
			this.stderr = stderr;
		}

		public String getStdout() {
			return stdout;
		}

		public String getStderr() {
			return stderr;
		}
	}

}