package com.cooldatasoft.wicket;

import java.net.URL;
import java.security.ProtectionDomain;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class JettySelfStart {

	private static Logger logger = Logger.getLogger(JettySelfStart.class);

	public static void main(String[] args) throws Exception {
		new JettySelfStart();
	}

	private static ResourceBundle bundle = null;
	private Server server;

	public JettySelfStart() throws Exception {
		setBundle(ResourceBundle.getBundle("jetty"));
		String portStr = getBundle().getString("jetty.port");
		int port = 8888;
		try {
			logger.info("Port number read from file : " + portStr);
			port = Integer.parseInt(portStr);
		} catch (Exception e) {
			port = 8888;
			logger.warn(
					"Port from config file could not be parsed! Jetty will use default port "
							+ port, e);
		}
		logger.info("Starting server...");
		setServer(new Server(port));
		ProtectionDomain domain = JettySelfStart.class.getProtectionDomain();
		URL location = domain.getCodeSource().getLocation();
		WebAppContext webapp = new WebAppContext();
		webapp.setContextPath("/");
		logger.info("Location : " + location.toExternalForm());
		System.out.println("-Location : " + location.toExternalForm());
		webapp.setDescriptor(location.toExternalForm() + "/WEB-INF/web.xml");
		webapp.setServer(server);
		webapp.setWar(location.toExternalForm());

		getServer().setHandler(webapp);
		getServer().start();
		getServer().join();
		logger.info("Jetty server started at : " + location + ":" + port);
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public static ResourceBundle getBundle() {
		return bundle;
	}

	public static void setBundle(ResourceBundle bundle) {
		JettySelfStart.bundle = bundle;
	}
}
