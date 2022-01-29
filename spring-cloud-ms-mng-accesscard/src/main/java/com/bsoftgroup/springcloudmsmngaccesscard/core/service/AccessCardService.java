package com.bsoftgroup.springcloudmsmngaccesscard.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsoftgroup.springcloudmsmngaccesscard.core.dao.AccessCardDaoInterface;
import com.bsoftgroup.springcloudmsmngaccesscard.dto.Transaccion;

@Service
public class AccessCardService implements AccessCardServiceInterface{
	
	@Autowired
	private AccessCardDaoInterface dao;

	@Override
	public Transaccion registroCard(String card, int segundos) {
		// TODO Auto-generated method stub
		return dao.registroCard(card, segundos);
	}

	@Override
	public Transaccion validacion(String card) {
		// TODO Auto-generated method stub
		return dao.validacion(card);
	}

}