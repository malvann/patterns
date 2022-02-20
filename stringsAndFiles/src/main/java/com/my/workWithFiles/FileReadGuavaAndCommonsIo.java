package com.my.workWithFiles;

import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileReadGuavaAndCommonsIo {

    public List<String> readByGuava(File file) throws IOException {
        return Files.readLines(file, StandardCharsets.UTF_8);
    }

    public List<String> readByCommon(File file) throws IOException {
        return FileUtils.readLines(file, StandardCharsets.UTF_8);
    }
}
