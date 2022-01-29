package com.bsoftgroup.springcloudmssecurity.core.dao;

import com.bsoftgroup.springcloudmssecurity.core.service.Usuario;

public interface UserDetailDaoInterface {
	
	public Usuario getUsuario(String username);

}
