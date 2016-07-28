package com.ipartek.formacion.controller;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.listener.InitListener;

/**
 * Application Lifecycle Listener implementation class ContadorSesionesListener
 *
 */
public class ContadorSesionesListener implements HttpSessionAttributeListener {

	private static final Logger LOG =Logger.getLogger(LoginServlet.class);

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	LOG.trace("atributo eliminado "+se.getName());
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
        LOG.trace("atributo añadido  "+se.getName());
        if("usuari_logueado".equals(se.getName())){
        InitListener.contadorUsuarios++;
        LOG.info(InitListener.contadorUsuarios+" usuarios logeados");
        }
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
        LOG.trace("atributo cambiado "+se.getName());
    }
	
}
