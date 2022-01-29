package com.bsoftgroup.springcloudmsmngaccesscard.core.dao.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

;


@Component
public class MngConnectionRedis {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    
	 @Autowired
	 @Qualifier("jedisredis")
	 private JedisPool jedisPool; 
	 
	 public Jedis getConecctionRedis() {
		 
		 Jedis jedis = jedisPool.getResource();
		 logger.info("conectandonos al redis ");
		 return jedis;
		 
	 }
    

}
