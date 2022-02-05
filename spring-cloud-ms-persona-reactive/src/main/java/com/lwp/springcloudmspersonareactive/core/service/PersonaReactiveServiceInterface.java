package com.lwp.springcloudmspersonareactive.core.service;

import com.lwp.springcloudmspersonareactive.dto.PersonaDto;
import java.util.List;
import reactor.core.publisher.Mono;

public interface PersonaReactiveServiceInterface {
  Mono<List<PersonaDto>> getPersona();
}
