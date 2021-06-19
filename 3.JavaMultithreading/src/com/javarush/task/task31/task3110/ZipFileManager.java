package com.javarush.task.task31.task3110;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            ZipEntry entry = new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(entry);

            try (InputStream fileInputStream = Files.newInputStream(source)) {
                byte[] bytes = new byte[8 * 1024];
                int len;
                while ((len = fileInputStream.read(bytes)) > 0) {
                    zipOutputStream.write(bytes, 0, len);
                }
            }
            zipOutputStream.closeEntry();
        }
    }
}
