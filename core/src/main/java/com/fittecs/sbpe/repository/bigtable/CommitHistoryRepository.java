package com.fittecs.sbpe.repository.bigtable;

import static com.fittecs.sbpe.entity.bigtable.CommitHistory.CF;
import static com.fittecs.sbpe.entity.bigtable.CommitHistory.COMMIT_HASH;
import static com.fittecs.sbpe.entity.bigtable.CommitHistory.DEVELOPER_ID;
import static com.fittecs.sbpe.entity.bigtable.CommitHistory.MESSAGE;
import static com.fittecs.sbpe.entity.bigtable.CommitHistory.TABLE_NAME;
import static com.fittecs.sbpe.entity.bigtable.CommitHistory.TIMESTAMP;

import com.fittecs.sbpe.entity.bigtable.CommitHistory;
import com.google.cloud.bigtable.hbase.BigtableConfiguration;
import java.io.IOException;
import java.util.Optional;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptor;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptorBuilder;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.client.TableDescriptor;
import org.apache.hadoop.hbase.client.TableDescriptorBuilder;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommitHistoryRepository {

  @Autowired Configuration conf;

  public void createTable() throws IOException {
    try (Connection conn = BigtableConfiguration.connect(conf)) {
      ColumnFamilyDescriptor cfd = ColumnFamilyDescriptorBuilder.newBuilder(CF).build();
      TableDescriptor descriptor =
          TableDescriptorBuilder.newBuilder(TABLE_NAME).setColumnFamily(cfd).build();
      conn.getAdmin().createTable(descriptor);
    }
  }

  public void deleteTable() throws IOException {
    try (Connection conn = BigtableConfiguration.connect(conf)) {
      conn.getAdmin().deleteTable(TABLE_NAME);
    }
  }

  public Optional<CommitHistory> get(Long developerId, Long timestamp) throws IOException {
    try (Connection conn = BigtableConfiguration.connect(conf)) {
      Table table = conn.getTable(TABLE_NAME);
      Result result = table.get(new Get(CommitHistory.hash(developerId, timestamp)));
      return result.isEmpty() ? Optional.empty() : Optional.of(CommitHistory.of(result));
    }
  }

  public void put(Long developerId, Long timestamp, String commitHash, String message)
      throws IOException {
    try (Connection conn = BigtableConfiguration.connect(conf)) {
      Table table = conn.getTable(TABLE_NAME);
      Put put = new Put(CommitHistory.hash(developerId, timestamp));
      put.addColumn(CF, DEVELOPER_ID, Bytes.toBytes(developerId));
      put.addColumn(CF, TIMESTAMP, Bytes.toBytes(timestamp));
      put.addColumn(CF, COMMIT_HASH, Bytes.toBytes(commitHash));
      put.addColumn(CF, MESSAGE, Bytes.toBytes(message));
      table.put(put);
    }
  }
}
