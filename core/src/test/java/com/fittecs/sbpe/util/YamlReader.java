package com.fittecs.sbpe.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

public interface YamlReader {

  default Map<String, Object> read(String key) throws IOException {
    try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("application.yml")) {
      Map<String, Object> yaml = new Yaml().load(is);
      return (Map<String, Object>) yaml.get(key);
    }
  }
}
