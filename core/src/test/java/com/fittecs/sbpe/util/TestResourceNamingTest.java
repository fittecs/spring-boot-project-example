package com.fittecs.sbpe.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestResourceNamingTest implements TestResourceNaming {

  @Test
  public void testGet1() {
    assertTrue(get("test").matches("test-[a-zA-Z0-9]{6}-[0-9]{14}"));
  }

  @Test
  public void testGet2() {
    assertTrue(get("test", "_").matches("test_[a-zA-Z0-9]{6}_[0-9]{14}"));
  }

  @Test
  public void testGet3() {
    assertTrue(get("test", 1).matches("test-[a-zA-Z0-9]{1}-[0-9]{14}"));
  }

  @Test
  public void testGet4() {
    assertTrue(get("test", "_", 1).matches("test_[a-zA-Z0-9]{1}_[0-9]{14}"));
  }
}
