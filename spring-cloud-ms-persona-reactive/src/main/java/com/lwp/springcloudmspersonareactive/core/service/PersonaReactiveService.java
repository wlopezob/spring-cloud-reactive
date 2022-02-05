package com.lwp.springcloudmspersonareactive.core.service;

import com.lwp.springcloudmspersonareactive.core.dao.PersonaReactiveDao;
import com.lwp.springcloudmspersonareactive.dto.PersonaDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PersonaReactiveService implements PersonaReactiveServiceInterface {
  @Autowired
  private PersonaReactiveDao personaReactiveDao;
  @Override
  public Mono<List<PersonaDto>> getPersona() {
    return personaReactiveDao.getPersona();
  }
}
