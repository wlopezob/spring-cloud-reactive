package com.bsoftgroup.springcloudmsmngaccesscard.core.service;

import com.bsoftgroup.springcloudmsmngaccesscard.dto.Transaccion;

public interface AccessCardServiceInterface {

	public Transaccion registroCard(String card,int segundos);
	public Transaccion validacion(String card);
}
