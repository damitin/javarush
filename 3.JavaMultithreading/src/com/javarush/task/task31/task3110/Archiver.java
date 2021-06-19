package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Введите полный путь файла архива:");
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(reader.readLine()));

        System.out.println("Введите полное имя файла для архивации:");
        zipFileManager.createZip(Paths.get(reader.readLine()));

        new ExitCommand().execute();
    }
}
