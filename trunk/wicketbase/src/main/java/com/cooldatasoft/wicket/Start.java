package com.cooldatasoft.wicket;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * 
 * @author Fatih Mehmet UCAR
 * 
 */
public class Start {
	
	private static Logger logger = Logger.getLogger(Start.class);
	
	private static ResourceBundle bundle = null;
	private Server server ;
	
	
	public static void main(String[] args) throws Exception {
		new Start();	
	}
	
	public Start(){		
		setBundle(ResourceBundle.getBundle("jetty"));
		String portStr = getBundle().getString("jetty.port");
		int port = 8888;		
		try{
			logger.info("Port number read from file : "+portStr);
			port = Integer.parseInt(portStr);
		}catch (Exception e) {
			port = 8888;
			logger.warn("Port from config file could not be parsed! Jetty will use default port 8080",e);
		}
		setServer(new Server());
		SocketConnector connector = new SocketConnector();

		// Set some timeout options to make debugging easier.
		connector.setMaxIdleTime(1000 * 60 * 60);
		connector.setSoLingerTime(-1);
		connector.setPort(port);
		server.setConnectors(new Connector[] { connector });

		WebAppContext webAppContext = new WebAppContext();
		webAppContext.setServer(server);
		webAppContext.setContextPath("/");
		webAppContext.setWar("src/main/webapp");
		
		// START JMX SERVER
		// MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		// MBeanContainer mBeanContainer = new MBeanContainer(mBeanServer);
		// server.getContainer().addEventListener(mBeanContainer);
		// mBeanContainer.start();

		server.addHandler(webAppContext);

		try {
			logger.info(">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP");
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(100);
		}
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
		Start.bundle = bundle;
	}
	
	
}
