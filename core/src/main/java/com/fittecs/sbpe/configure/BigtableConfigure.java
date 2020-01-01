package com.fittecs.sbpe.configure;

import com.google.cloud.bigtable.hbase.BigtableConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BigtableConfigure {

  @Autowired BigtableProperties props;

  @Bean
  public org.apache.hadoop.conf.Configuration conf() {
    return BigtableConfiguration.configure(props.getProjectId(), props.getInstanceId());
  }
}
