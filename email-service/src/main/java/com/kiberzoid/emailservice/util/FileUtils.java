package com.kiberzoid.emailservice.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileUtils {

    private FileUtils() {

    }

    public static File multipartToFile(MultipartFile multipartFile, String fileName) {
        File file = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return file;
    }

    public static void saveFile(List<MultipartFile> attachment) {
        if (attachment != null) {
            for (MultipartFile file : attachment) {
                if (file.isEmpty()) {
                    throw new IllegalArgumentException("File " + file.getOriginalFilename() + " is empty.Attachment can not contains empty file.");
                }
                if (!file.isEmpty()) {
                    FileUtils.multipartToFile(file, file.getOriginalFilename());
                }
            }
        }
    }
}
