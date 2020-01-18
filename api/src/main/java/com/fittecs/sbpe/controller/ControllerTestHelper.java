package com.fittecs.sbpe.controller;

import java.nio.charset.Charset;
import org.springframework.http.MediaType;

public interface ControllerTestHelper {

  static MediaType CONTENT_TYPE =
      new MediaType(
          MediaType.APPLICATION_JSON.getType(),
          MediaType.APPLICATION_JSON.getSubtype(),
          Charset.forName("utf8"));
}
