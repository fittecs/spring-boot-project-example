package com.fittecs.sbpe.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.RandomStringUtils;

public interface TestResourceNaming {

  String DEFAULT_DELIMITER = "-";
  int DEFAULT_RANDOM_LENGTH = 6;

  default String get(String namePrefix) {
    return get(namePrefix, DEFAULT_DELIMITER, DEFAULT_RANDOM_LENGTH);
  }

  default String get(String namePrefix, String delimiter) {
    return get(namePrefix, delimiter, DEFAULT_RANDOM_LENGTH);
  }

  default String get(String namePrefix, int randomLength) {
    return get(namePrefix, DEFAULT_DELIMITER, randomLength);
  }

  default String get(String namePrefix, String delimiter, int randomLength) {
    return namePrefix
        + delimiter
        + RandomStringUtils.randomAlphanumeric(randomLength)
        + delimiter
        + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
  }
}
