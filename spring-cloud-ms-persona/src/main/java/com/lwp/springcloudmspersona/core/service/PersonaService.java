package com.lwp.springcloudmspersona.core.service;

import com.lwp.springcloudmspersona.core.dao.PersonaDao;
import com.lwp.springcloudmspersona.core.dao.PersonaDaoInterace;
import com.lwp.springcloudmspersona.dto.PersonaDto;
import com.lwp.springcloudmspersona.util.AppException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements PersonaServiceInterface{

  @Autowired
  PersonaDaoInterace personaDao;

  @Override
  public List<PersonaDto> consultarPersona() throws AppException {
    return personaDao.getPersona();
  }
}
