package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        // 3. Для первого файла создай поток для чтения и считай его содержимое.
        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        byte[] bytes1 = new byte[fileInputStream1.available()];
        fileInputStream1.read(bytes1);
        fileInputStream1.close();

        // 4. Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
        FileInputStream fileInputStream2 = new FileInputStream(fileName2);

        // 5. Содержимое первого и второго файла нужно объединить в первом файле.
        // 6. Сначала должно идти содержимое второго файла, затем содержимое первого.
        byte[] bytes2 = new byte[fileInputStream2.available()];
        fileInputStream2.read(bytes2);

        fileInputStream2.close();

        byte[] result = new byte[bytes1.length + bytes2.length];
        System.arraycopy(bytes2, 0, result, 0, bytes2.length);
        System.arraycopy(bytes1, 0, result, bytes2.length, bytes1.length);

        fileOutputStream.write(result);
        fileOutputStream.close();
    }
}
