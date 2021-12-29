package com.my.workWithFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {
  public static List<String> read(String filePath) throws IOException {
    Path path = Paths.get(filePath);
    return Files.readAllLines(path);
  }

  public static List<String> readLargeFile(String filePath) throws IOException {
    Path path = Paths.get(filePath);
    try(BufferedReader reader = Files.newBufferedReader(path)){
      return reader.lines().collect(Collectors.toList());
    }
  }

  public static void write(String filePath, List<String> lines) throws IOException {
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){
      for (String line : lines) writer.append(line).append(" ");
    }
  }

  public static String joinLines(List<String> lines){
    return String.join(" ", lines);
  }
}
