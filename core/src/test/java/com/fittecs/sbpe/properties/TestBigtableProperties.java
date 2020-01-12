package com.fittecs.sbpe.properties;

import com.fittecs.sbpe.util.TestResourceNaming;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
@ConfigurationProperties("bigtable")
@Data
public class TestBigtableProperties implements BigtableProperties, TestResourceNaming {

  private String projectId;
  private String instanceId;

  @Override
  public String getInstanceId() {
    return get(instanceId);
  }
}
