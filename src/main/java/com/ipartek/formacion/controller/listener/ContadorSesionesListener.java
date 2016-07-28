package com.ipartek.formacion.controller.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Application Lifecycle Listener implementation class ContadorSesionesListener
 *
 */
public class ContadorSesionesListener implements HttpSessionAttributeListener {

	private final static Logger LOG = Logger.getLogger(InitListener.class);
   

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	 LOG.trace("Atributo eliminado"+se.getName() );
        
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
        LOG.trace("Atributo añadido"+se.getName() );
        
        if ("usuario_logeado.e) {
			
		}
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	 LOG.trace("Atributo cambiadoo"+se.getName() );
    }
	
}
