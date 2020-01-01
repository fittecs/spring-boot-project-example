package com.fittecs.sbpe.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fittecs.sbpe.entity.Developer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class MySQLControllerTest {

  @Autowired ObjectMapper mapper;
  @Autowired TestRestTemplate restTemplate;

  static final MediaType CONTENT_TYPE =
      new MediaType(
          MediaType.APPLICATION_JSON.getType(),
          MediaType.APPLICATION_JSON.getSubtype(),
          Charset.forName("utf8"));

  @Test
  public void testIndex1() throws Exception {
    Map<String, Object> params = new HashMap<>();
    ResponseEntity<String> actual = restTemplate.getForEntity("/mysql/", String.class, params);
    assertEquals(actual.getStatusCode(), HttpStatus.OK);
    assertEquals(actual.getHeaders().getContentType(), CONTENT_TYPE);
    assertEquals(
        actual.getBody(),
        mapper.writeValueAsString(Arrays.asList(new Developer(1L, "developer1"))));
  }
}
