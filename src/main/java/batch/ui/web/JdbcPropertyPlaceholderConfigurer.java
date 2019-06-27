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
package batch.ui.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * Specialized property configurer to create tmp directory for DB, if requested.
 * @author Joseph Sackett
 */
public class JdbcPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	/** Logger. */
	private static final Logger logger = LogManager.getLogger(JdbcPropertyPlaceholderConfigurer.class);

	/** Custom processing function to create tmp file, if requested, and delegate to overridden processProperties method. */
	@Override
	protected void processProperties(final ConfigurableListableBeanFactory beanFactoryToProcess, final Properties props) throws BeansException {
		int ix;
		final String dbUrl = props.getProperty("jdbc.url");
		// Is this a file DB Url due to be created in a tmp directory?
		if ((ix = dbUrl.indexOf("tmp???/")) >= 0) {
			final String temp = dbUrl.substring(ix + 7);
			final int iy = temp.indexOf('/');
			final String root = temp.substring(0, iy);
    		try {
    			// Create tmp directory for DB file.
				final File tempDir = Files.createTempDirectory(root).toFile();
				tempDir.deleteOnExit();
				final String path = tempDir + temp.substring(iy);
				// Set jdbc path to tmp dir.
				props.setProperty("jdbc.url", dbUrl.substring(0, ix - 1) + path);
			} catch (final IOException e) {
				logger.error("", e);
			}
		}

		super.processProperties(beanFactoryToProcess, props);
	}
}
