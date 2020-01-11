package com.fittecs.sbpe.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
@ConfigurationProperties("bigtable")
@Data
public class DefaultBigtableProperties implements BigtableProperties {

  private String projectId;
  private String instanceId;
}
