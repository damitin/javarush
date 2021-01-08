package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        Queue<File> fileQueue = new LinkedList<>();
        fileQueue.add(new File(root));
        while (!fileQueue.isEmpty()) {
            File file = fileQueue.poll();
            for (File currentFile : file.listFiles()) {
                if (currentFile.isFile()) result.add(currentFile.getAbsolutePath());
                else if (currentFile.isDirectory()) fileQueue.add(currentFile);
            }
        }
        return result;

    }

    public static void main(String[] args) {

    }
}
