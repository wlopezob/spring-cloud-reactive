package com.bsoftgroup.springcloudmsmngaccesscard.core.dao;

import com.bsoftgroup.springcloudmsmngaccesscard.dto.Transaccion;

public interface AccessCardDaoInterface {
	
	public Transaccion registroCard(String card,int segundos);
	public Transaccion validacion(String card);

}
