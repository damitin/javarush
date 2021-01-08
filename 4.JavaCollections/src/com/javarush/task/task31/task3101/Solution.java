package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //1. На вход метода main() подаются два параметра.
        //Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который будет содержать результат.
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        File source = new File(resultFileAbsolutePath);
        File dest = new File(source.getParent() + "/allFilesContent.txt");

        //2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(), и, если понадобится, FileUtils.isExist()).
        FileUtils.renameFile(source, dest);

        //3. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
        //Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
        ArrayList<String> files = (ArrayList<String>) getFileTree(path);

        //3.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
        MyStringComparator myStringComparator = new MyStringComparator();
        Collections.sort(files, myStringComparator);

        //3.2. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 3.1. После каждого тела файла записать "\n".
        FileWriter fileWriter = new FileWriter(dest, true);
        for (String currentFile : files) {
            BufferedReader reader = new BufferedReader(new FileReader(currentFile));
            while (reader.ready()) {
                String currentLine = reader.readLine();
                fileWriter.write(currentLine);
            }
            fileWriter.write("\n");
            reader.close();
        }
        fileWriter.close();
    }

    public static List<String> getFileTree(String root) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        Queue<File> fileQueue = new LinkedList<>();
        fileQueue.add(new File(root));
        while (!fileQueue.isEmpty()) {
            File file = fileQueue.poll();
            for (File currentFile : file.listFiles()) {
                if (currentFile.isFile() && currentFile.length() <= 50) result.add(currentFile.getAbsolutePath());
                else if (currentFile.isDirectory()) fileQueue.add(currentFile);
            }
        }
        return result;
    }
}
