package com.lwp.springcloudmspersona.integracion;

import com.lwp.springcloudmspersona.core.service.PersonaService;
import com.lwp.springcloudmspersona.dto.PersonaDto;
import com.lwp.springcloudmspersona.util.AppException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaRestController {

  private Logger log = LoggerFactory.getLogger(PersonaRestController.class);
  @Autowired
  PersonaService personaService;

  @GetMapping("consultar")
  public List<PersonaDto> consultar() throws AppException {
    return  personaService.consultarPersona();
  }
}
