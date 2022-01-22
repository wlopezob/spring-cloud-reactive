package com.lwp.springcloudmspersona.core.dao;

import com.lwp.springcloudmspersona.dto.PersonaDto;
import com.lwp.springcloudmspersona.util.AppException;
import java.util.List;

public interface PersonaDaoInterace {

  public List<PersonaDto> getPersona() throws AppException;
}
