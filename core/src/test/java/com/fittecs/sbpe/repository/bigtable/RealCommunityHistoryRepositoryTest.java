package com.fittecs.sbpe.repository.bigtable;

import static org.junit.jupiter.api.Assertions.*;

import com.fittecs.sbpe.entity.bigtable.CommitHistory;
import com.fittecs.sbpe.junit.WithGcpServices;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
@WithGcpServices
public class RealCommunityHistoryRepositoryTest {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  @Autowired CommitHistoryRepository repository;

  @Disabled
  @Test
  void testOperation() throws IOException {
    try {
      repository.createTable();
      repository.put(1L, 1L, "str", "str");
      CommitHistory expected = new CommitHistory(1L, 1L, "str", "str");
      CommitHistory actual = repository.get(1L, 1L).get();
      assertEquals(MAPPER.writeValueAsString(expected), MAPPER.writeValueAsString(actual));
    } finally {
      repository.deleteTable();
    }
  }
}
