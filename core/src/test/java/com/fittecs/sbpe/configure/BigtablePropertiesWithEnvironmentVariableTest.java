package com.fittecs.sbpe.configure;

import static org.junit.jupiter.api.Assertions.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestPropertySource(
    properties = {"BIGTABLE_PROJECT_ID=projectId", "BIGTABLE_INSTANCE_ID=instanceId"})
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class BigtablePropertiesWithEnvironmentVariableTest {

  @Autowired BigtableProperties props;

  @Test
  void testProjectId() {
    assertEquals("projectId", props.getProjectId());
  }

  @Test
  void testInstanceId() {
    assertEquals("instanceId", props.getInstanceId());
  }
}
