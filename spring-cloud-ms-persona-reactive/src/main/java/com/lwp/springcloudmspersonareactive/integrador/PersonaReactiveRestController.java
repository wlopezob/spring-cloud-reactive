package com.lwp.springcloudmspersonareactive.integrador;

import com.lwp.springcloudmspersonareactive.core.service.PersonaReactiveService;
import com.lwp.springcloudmspersonareactive.dto.PersonaDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PersonaReactiveRestController {

  @Autowired
  private PersonaReactiveService personaReactiveService;

  @GetMapping(path="/personas")
  public Mono<List<PersonaDto>> getPersonas(){
    return personaReactiveService.getPersona();
  }

}
