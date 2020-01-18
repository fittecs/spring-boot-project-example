package com.fittecs.sbpe.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class IndexControllerTest implements ControllerTestHelper {

  @Autowired TestRestTemplate restTemplate;

  @Test
  public void testIndex1() {
    Map<String, Object> params = new HashMap<>();
    ResponseEntity<String> actual = restTemplate.getForEntity("/", String.class, params);

    assertEquals(actual.getStatusCode(), HttpStatus.OK);
    assertEquals(actual.getHeaders().getContentType(), CONTENT_TYPE);
    assertEquals(actual.getBody(), "{}");
  }
}
