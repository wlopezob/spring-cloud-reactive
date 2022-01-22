package com.lwp.springcloudmspersona.core.service;

import com.lwp.springcloudmspersona.dto.PersonaDto;
import com.lwp.springcloudmspersona.util.AppException;
import java.util.List;

public interface PersonaServiceInterface {
  public List<PersonaDto> consultarPersona() throws AppException;
}
