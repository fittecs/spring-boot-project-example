package com.fittecs.sbpe.properties;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestBigtablePropertiesTest {

  @Autowired BigtableProperties props;

  @Test
  void testProjectId() {
    assertEquals("test-sbpe", props.getProjectId());
  }

  @Test
  void testInstanceId() {
    assertTrue(props.getInstanceId().matches("test-instance-[a-zA-Z0-9]{6}-[0-9]{14}"));
  }
}
