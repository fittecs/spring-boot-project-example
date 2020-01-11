package com.fittecs.sbpe.junit;

import com.google.common.collect.Sets;
import java.util.Map;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.kohsuke.MetaInfServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@MetaInfServices(org.junit.jupiter.api.extension.Extension.class)
public class TestExecutionConditionExtension implements ExecutionCondition {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(TestExecutionConditionExtension.class);

  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
    Map<String, String> env = System.getenv();
    Environment springEnv = SpringExtension.getApplicationContext(context).getEnvironment();

    if (Sets.newHashSet("prd", "stg").contains(env.get("ENV"))) {
      return ConditionEvaluationResult.disabled(
          "It doesn't allow to run a test with ENV=" + env.get("ENV"));
    }

    return ConditionEvaluationResult.enabled("A test will start soon ...");
  }
}
