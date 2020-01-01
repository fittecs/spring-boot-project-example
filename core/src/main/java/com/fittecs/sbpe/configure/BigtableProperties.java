package com.fittecs.sbpe.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("bigtable")
@Data
public class BigtableProperties {

  private String projectId;
  private String instanceId;
}
