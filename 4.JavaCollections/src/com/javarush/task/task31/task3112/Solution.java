package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        Path tempFile = Files.createTempFile("download", ".tmp1");
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        // implement this method
        inputStream.close();

        if (!Files.exists(downloadDirectory)) Files.createDirectory(downloadDirectory);

        Path targetPath = Paths.get(downloadDirectory.toAbsolutePath().toString() + "/" + urlString.substring(urlString.lastIndexOf("/") + 1));
        return Files.move(tempFile, targetPath);
    }
}
