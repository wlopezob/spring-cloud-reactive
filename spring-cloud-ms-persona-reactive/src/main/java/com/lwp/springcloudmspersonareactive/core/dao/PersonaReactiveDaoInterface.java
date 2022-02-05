package com.lwp.springcloudmspersonareactive.core.dao;

import com.lwp.springcloudmspersonareactive.dto.PersonaDto;
import java.util.List;
import reactor.core.publisher.Mono;

public interface PersonaReactiveDaoInterface {
  Mono<List<PersonaDto>> getPersona();
}
