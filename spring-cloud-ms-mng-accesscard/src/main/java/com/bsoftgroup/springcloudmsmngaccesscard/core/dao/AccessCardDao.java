package com.bsoftgroup.springcloudmsmngaccesscard.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bsoftgroup.springcloudmsmngaccesscard.core.dao.util.MngConnectionRedis;
import com.bsoftgroup.springcloudmsmngaccesscard.dto.Transaccion;

import redis.clients.jedis.Jedis;

@Repository
public class AccessCardDao implements AccessCardDaoInterface{
	
	@Autowired
	private MngConnectionRedis redis;
	
	@Override
	public Transaccion registroCard(String card,int segundos) {
		// TODO Auto-generated method stub
		Jedis jedis = redis.getConecctionRedis();
		jedis.setex(card, segundos, card);
		jedis.close();
		Transaccion tx = new Transaccion();
		tx.setCodigo("000");
		tx.setDescripcion("registro conforme");
		return tx;
	}

	@Override
	public Transaccion validacion(String card) {
		// TODO Auto-generated method stub
		Transaccion tx = new Transaccion();
		Jedis jedis = redis.getConecctionRedis();
		if(jedis.exists(card)) {
			
			tx.setCodigo("000");
			tx.setDescripcion("token autorizacion existe");
        }else {
        	tx.setCodigo("888");
			tx.setDescripcion("token autorizacion no existe");
        }
        
		jedis.close();
        
		return tx;
	}
	
}
	
	