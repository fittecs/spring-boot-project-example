package com.fittecs.sbpe.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MySQLServiceTest {

  @Autowired MySQLService service;

  @Test
  public void testAllDevelopers1() {
    assertNotNull(service.allDevelopers());
  }
}
