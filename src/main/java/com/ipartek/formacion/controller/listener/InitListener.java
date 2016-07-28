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
public class InitListener implements ServletContextListener {
	
	public  static int contadorUsuarios=0;

	private final static Logger LOG = Logger.getLogger(InitListener.class);
	
	public final static String ATTRIBUTE_PROPS_NAME = "cons";
	
	private final static String PATH_LOG4J      = "/log4j.properties";
	private final static String PATH_CONSTANTES = "constantes.properties";


	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
        
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	loadLog4j(sce);
        loadProperties(sce);
    }

    /**
     * 
     * @param sce
     *          ServletContextEvent
     */
    private void loadProperties(ServletContextEvent sce) {
      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
      InputStream input = classLoader.getResourceAsStream(PATH_CONSTANTES);
      Properties props = new Properties();
      try {
        props.load(input);
      } catch (Exception e) {
        LOG.error("No se ha cargado el archivo constantes");
      }
      
      //Guardar como atributo en Contexto Servlets
      sce.getServletContext().setAttribute(ATTRIBUTE_PROPS_NAME, props);
    }

    /**
     * 
     * @param sce
     * @param sce
     *          ServletContextEvent
     */
    private void loadLog4j(ServletContextEvent sce) {      
      try {
    	Properties props = new Properties();
    	props.load(getClass().getResourceAsStream(PATH_LOG4J));
        PropertyConfigurator.configure(props);
        LOG.info("LOG CARGADO");

      } catch (Exception e) {
    	  e.printStackTrace();
      }
    }
	
}
