package com.ipartek.formacion.controller.listener;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener                                                                                                                     implements ServletContextListener {

	public static int contadorUsuarios = 0;
	
	private final static Logger LOG = Logger.getLogger(InitListener.class);

	public final static String ATTRIBUTE_PROPS_NAME = "cons";

	private final static String PATH_LOG4J = "/log4j.properties";
	private final static String PATH_CONSTANTES = "constantes.properties";

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// cargamos las trazas
		loadLog4j(sce);
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	/**
	 * Cargar la configuracion de LOG4J de la carpeta de recursos "src/java/resources"
	 * @param sce
	 */
	private void loadLog4j(ServletContextEvent sce) {
		try {
			Properties props = new Properties();
			props.load(getClass().getResourceAsStream(PATH_LOG4J));
			PropertyConfigurator.configure(props);
			LOG.info("LOG cargado con exito");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
