package com.ipartek.formacion.controller.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class ContadorSessionesListener
 *
 */
public class ContadorSessionesListener implements HttpSessionAttributeListener {
	
	private static final Logger LOG = Logger.getLogger(ContadorSessionesListener.class);

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
        LOG.trace("Atributo añadido " + se.getName() );
        
        if ( "usuario_logeado".equals(se.getName())){
        	InitListener.contadorUsuarios++;
        	LOG.info( InitListener.contadorUsuarios + " usuarios logeados");
        }
        
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	LOG.trace("Atributo eliminado" + se.getName() );
    	
    	if ( "usuario_logeado".equals(se.getName())){
        	InitListener.contadorUsuarios--;
        	LOG.info( InitListener.contadorUsuarios + " usuarios logeados");
        }
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	LOG.trace("Atributo reemplazado" + se.getName() );
    	
    	if ( "usuario_logeado".equals(se.getName())){
        	InitListener.contadorUsuarios--;
        	LOG.info( InitListener.contadorUsuarios + " usuarios logeados");
        }
    }
	
}