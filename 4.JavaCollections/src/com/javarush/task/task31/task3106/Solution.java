package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> fileNames = new ArrayList<>();
        fileNames.addAll(Arrays.asList(args).subList(1, args.length));
        Collections.sort(fileNames);

        List<FileInputStream> fileInputStreams = new ArrayList<>();
        for (String name : fileNames) {
            fileInputStreams.add(new FileInputStream(name));
        }

        ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreams)));
        FileOutputStream fileOutputStream = new FileOutputStream(args[0]);
        ZipEntry zipEntry;
        byte[] buffer = new byte[1024 * 1024];
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            int bytesWereRead;
            while ((bytesWereRead = zipInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesWereRead);
            }
        }
        fileOutputStream.close();
        zipInputStream.close();
    }
}
