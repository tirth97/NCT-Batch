package batchserver;

import org.apache.activemq.broker.BrokerService;

public class BrokerStarter {

	protected static String cmd_url = "tcp://activemq:61616";

	public static void initCmdBroker() throws Exception {
		final BrokerService broker = new BrokerService();
		// configure the broker
		broker.addConnector(cmd_url);
		broker.start();
	}

	public static void main(final String[] args) throws Exception {
		initCmdBroker();
	}
}
