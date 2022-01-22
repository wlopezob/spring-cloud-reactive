package com.lwp.springcloudmspersona.core.dao;

import com.lwp.springcloudmspersona.dto.PersonaDto;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaDao implements PersonaDaoInterace {
  @Override
  public List<PersonaDto> getPersona() {
    return Arrays.asList(PersonaDto.builder().idPersona(1L).nombre("William")
        .build());
  }
}
