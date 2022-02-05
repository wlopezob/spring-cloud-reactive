package com.lwp.springcloudmspersonareactive.core.dao;

import com.lwp.springcloudmspersonareactive.dto.PersonaDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class PersonaReactiveDao implements PersonaReactiveDaoInterface{

  private String baseUrl = "http://spring-cloud-ms-persona/ms-persona/consultar";

  @Autowired
  private WebClient.Builder webClient;

  @Override
  public Mono<List<PersonaDto>> getPersona() {
    return webClient.build()
        .get()
        .uri(baseUrl)
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<List<PersonaDto>>() {});
  }
}
