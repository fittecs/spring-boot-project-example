package com.fittecs.sbpe.properties;

import static org.junit.jupiter.api.Assertions.*;

import com.fittecs.sbpe.util.YamlReader;
import java.io.IOException;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DefaultBigtablePropertiesTest implements YamlReader {

  Map<String, Object> props;

  @PostConstruct
  void init() throws IOException {
    this.props = read("bigtable2");
  }

  @Test
  void testProjectId() {
    assertEquals("${BIGTABLE_PROJECT_ID:test-sbpe}", props.get("project-id"));
  }

  @Test
  void testInstanceId() {
    assertEquals("${BIGTABLE_INSTANCE_ID:test-instance}", props.get("instance-id"));
  }
}
