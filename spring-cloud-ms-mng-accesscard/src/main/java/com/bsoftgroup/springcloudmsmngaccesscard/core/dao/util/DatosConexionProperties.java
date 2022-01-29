package com.bsoftgroup.springcloudmsmngaccesscard.core.dao.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix="app.mng.card")
public class DatosConexionProperties implements InitializingBean{
	
	private Logger logger = LoggerFactory.getLogger(DatosConexionProperties.class);

	private String hostname;
    
	private Integer port;

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("DatosConexionProperties.hostname {} ",this.hostname);
		logger.info("DatosConexionProperties.port {} ",this.port);
		
		
	}

	@Override
    public String toString() {
		return "Clase "+this.hostname+"-"+this.port;
    	
    }
	
    
}
