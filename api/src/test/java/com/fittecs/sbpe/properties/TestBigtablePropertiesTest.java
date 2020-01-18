package com.fittecs.sbpe.properties;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class TestBigtablePropertiesTest {

  @Autowired BigtableProperties props;

  @Test
  void testProjectId() {
    assertEquals("projectId", props.getProjectId());
  }

  @Test
  void testInstanceId() {
    assertLinesMatch(
        Arrays.asList("instanceId-[a-zA-Z0-9]{6}-[0-9]{14}"), Arrays.asList(props.getInstanceId()));
  }
}
