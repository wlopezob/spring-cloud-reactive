package com.bsoftgroup.springcloudmsmngaccesscard.core.dao.util;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;



@Configuration
public class DataSourceRedisConfiguration {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Bean(name = "propertiesredis")
	@ConfigurationProperties("app.mng.card")
	public DatosConexionProperties dataSourcePropertiesRedis() {
	    return new DatosConexionProperties();
	}
	
	
	@Bean(name="jedisredis")
	public JedisPool redisConnectionFactory() {
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		poolConfig.setTestOnBorrow(true);
		poolConfig.setMaxTotal(100);//numero maximo de conexiones
		DatosConexionProperties properties = dataSourcePropertiesRedis();
		logger.info("información hostanme {} ", properties.toString());
		JedisPool jedisPool = new JedisPool(poolConfig,properties.getHostname(),properties.getPort(),3000);
		
		/*
		 *  poolConfig.setBlockWhenExhausted(config.getBoolean("blockWhenExhausted"));
			 poolConfig.setEvictionPolicyClassName(config.getString("evictionPolicyClassName"));
			 poolConfig.setJmxEnabled(config.getBoolean("jmxEnabled"));
			 poolConfig.setJmxNamePrefix(config.getString("jmxNamePrefix"));
			 poolConfig.setLifo(config.getBoolean("lifo"));
			 poolConfig.setMaxIdle(config.getInt("maxIdle"));
			 poolConfig.setMaxTotal(config.getInt("maxTotal"));
			 poolConfig.setMaxWaitMillis(config.getDuration("maxWait", TimeUnit.MILLISECONDS));
			 poolConfig.setMinEvictableIdleTimeMillis(config.getDuration("minEvictableIdle",
			   TimeUnit.MILLISECONDS));
			 poolConfig.setMinIdle(config.getInt("minIdle"));
			 poolConfig.setNumTestsPerEvictionRun(config.getInt("numTestsPerEvictionRun"));
			 poolConfig.setSoftMinEvictableIdleTimeMillis(
			   config.getDuration("softMinEvictableIdle", TimeUnit.MILLISECONDS));
			 poolConfig.setTestOnBorrow(config.getBoolean("testOnBorrow"));
			 poolConfig.setTestOnReturn(config.getBoolean("testOnReturn"));
			 poolConfig.setTestWhileIdle(config.getBoolean("testWhileIdle"));
			 poolConfig.setTimeBetweenEvictionRunsMillis(config.getDuration("timeBetweenEvictionRuns", TimeUnit.MILLISECONDS));
		*/
	    
	    return jedisPool;
	  }
	
}
