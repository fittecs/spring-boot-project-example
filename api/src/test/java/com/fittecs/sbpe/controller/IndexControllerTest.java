package com.fittecs.sbpe.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fittecs.sbpe.service.MySQLService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = IndexController.class)
@Slf4j
public class IndexControllerTest {

  @Autowired MockMvc mvc;
  @Autowired ObjectMapper mapper;
  @MockBean MySQLService service;

  @Test
  public void testIndex1() throws Exception {
    this.mvc
        .perform(get("/"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("{}")));
  }
}
