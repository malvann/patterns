package com.my;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class WordSplitting {
  private static final String someText =
      "Apache NiFi supports powerful and scalable directed graphs of data routing, transformation, and system mediation logic. Some of the high-level capabilities and objectives of Apache NiFi include:\n"
          + "\n"
          + "Web-based user interface\n"
          + "Seamless experience between design, control, feedback, and monitoring\n"
          + "Highly configurable\n"
          + "Loss tolerant vs guaranteed delivery\n"
          + "Low latency vs high throughput\n"
          + "Dynamic prioritization\n"
          + "Flow can be modified at runtime\n"
          + "Back pressure\n"
          + "Data Provenance\n"
          + "Track dataflow from beginning to end\n"
          + "Designed for extension\n"
          + "Build your own processors and more\n"
          + "Enables rapid development and effective testing\n"
          + "Secure\n"
          + "SSL, SSH, HTTPS, encrypted content, etc...\n"
          + "Multi-tenant authorization and internal authorization/policy management";

  public static void main(String[] args) {
      Arrays.stream(splitToWords(someText)).forEach(System.out::println);
      splitToWordsBySymbol(someText).forEach(System.out::println);
  }

  public static String[] splitToWords (String someText){
      return StringUtils.split(someText);
  }

  public static List<String> splitToWordsBySymbol(String someText){
      return Splitter.on(',').trimResults().omitEmptyStrings().splitToList(someText);
  }
}
