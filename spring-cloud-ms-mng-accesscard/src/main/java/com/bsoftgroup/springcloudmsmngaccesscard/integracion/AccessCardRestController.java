package com.bsoftgroup.springcloudmsmngaccesscard.integracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bsoftgroup.springcloudmsmngaccesscard.core.dao.util.DatosConexionProperties;
import com.bsoftgroup.springcloudmsmngaccesscard.core.service.AccessCardServiceInterface;
import com.bsoftgroup.springcloudmsmngaccesscard.dto.TarjetaDto;
import com.bsoftgroup.springcloudmsmngaccesscard.dto.Transaccion;

@RestController
public class AccessCardRestController {
	
	@Autowired
	private AccessCardServiceInterface service;
	

	
	@PostMapping(path="/registrar/tarjeta")
	public Transaccion registroCard(@RequestBody TarjetaDto tarjeta) {
		return service.registroCard(tarjeta.getCard(), tarjeta.getSegundos());
	}
	
	@PostMapping(path="/validar/tarjeta")
	public Transaccion validacion(@RequestBody TarjetaDto tarjeta) {
		return service.validacion(tarjeta.getCard());
	}
	

}