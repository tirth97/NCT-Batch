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

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.support.WebApplicationContextUtils;

import batch.service.BatchService;

/**
 * Web application startup logic.
 * @author Joseph Sackett
 */
@WebListener
public class AppContextListener implements ServletContextListener {
	/** Logger. */
	private static final Logger logger = LogManager.getLogger(AppContextListener.class);

	/** Provides batch-related services. */
	@Autowired
	private BatchService batchService;

	/** Configuration flag indicates whether to init DB. */
    @Value("${init.db}")
    private Boolean initDB;

    /** Initialize servlet context. */
	@Override
	public void contextInitialized(final ServletContextEvent event) {
		// Must explicitly initialize Spring.
	    WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext()).getAutowireCapableBeanFactory().autowireBean(this);

		if (!initDB) {
			// Do not create tables.
			return;
		}

		try {
			batchService.createBatchSchema();
    		logger.info("Batch tables created.");
		} catch (final Exception e) {
			logger.error("", e);
		}
	}

	/** Shutdown container. */
	@Override
	public void contextDestroyed(final ServletContextEvent event) {
		// empty.
	}
}