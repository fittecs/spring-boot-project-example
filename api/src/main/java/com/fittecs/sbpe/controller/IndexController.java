package com.fittecs.sbpe.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class IndexController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index() {
    return "{}";
  }
}
