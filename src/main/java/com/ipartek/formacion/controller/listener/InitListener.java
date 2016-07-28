package com.ipartek.formacion.controller.listener;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener {
public static int contadorUsuarios=0;

	//var de tipo log que escribe en un fich de text la sucesión de la aplicacion
private final static Logger LOG = Logger.getLogger(InitListener.class);
	
	public final static String ATTRIBUTE_PROPS_NAME = "cons";
	
	private final static String PATH_LOG4J      = "/log4j.properties";
	private final static String PATH_CONSTANTES = "constantes.properties";

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  {
    //cargamos las trazas
       loadLog4j(arg0);
       loadProperties(arg0);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
    
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
     * cambia la config load4j de la carpeta resources
     * @param sce
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
