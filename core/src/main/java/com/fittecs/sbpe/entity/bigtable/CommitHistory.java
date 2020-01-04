package com.fittecs.sbpe.entity.bigtable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommitHistory {

  public static final TableName TABLE_NAME = TableName.valueOf("commit_history");
  public static final String CF_NAME = "cf";
  public static final byte[] CF = Bytes.toBytes(CF_NAME);
  public static final byte[] DEVELOPER_ID = Bytes.toBytes("developer_id");
  public static final byte[] TIMESTAMP = Bytes.toBytes("timestamp");
  public static final byte[] COMMIT_HASH = Bytes.toBytes("commit_hash");
  public static final byte[] MESSAGE = Bytes.toBytes("message");

  public static byte[] hash(Long developerId, Long timestamp) {
    return Bytes.toBytes(String.format("%s_%s", developerId, timestamp));
  }

  private Long developerId;
  private Long timestamp;
  private String commitHash;
  private String message;

  public static CommitHistory of(Result result) {
    CommitHistory commitHistory = new CommitHistory();
    commitHistory.developerId = Bytes.toLong(result.getValue(CF, DEVELOPER_ID));
    commitHistory.timestamp = Bytes.toLong(result.getValue(CF, TIMESTAMP));
    commitHistory.commitHash = Bytes.toString(result.getValue(CF, COMMIT_HASH));
    commitHistory.message = Bytes.toString(result.getValue(CF, MESSAGE));
    return commitHistory;
  }
}
