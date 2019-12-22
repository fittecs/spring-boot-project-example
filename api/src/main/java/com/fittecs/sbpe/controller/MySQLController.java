package com.fittecs.sbpe.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mysql")
@Slf4j
public class MySQLController {

  //  @Autowired MySQLService mySQLService;
  @Autowired ObjectMapper mapper;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index() throws JsonProcessingException {
    //    return mapper.writeValueAsString(mySQLService.allMembers());
    return "[]";
  }
}
