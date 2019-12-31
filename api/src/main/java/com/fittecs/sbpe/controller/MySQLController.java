package com.fittecs.sbpe.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fittecs.sbpe.service.MySQLService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/mysql", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class MySQLController {

  @Autowired MySQLService mySQLService;
  @Autowired ObjectMapper mapper;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index() throws JsonProcessingException {
    return mapper.writeValueAsString(mySQLService.allDevelopers());
  }
}
