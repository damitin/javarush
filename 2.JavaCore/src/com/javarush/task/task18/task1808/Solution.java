package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream otputStream1 = new FileOutputStream(reader.readLine());
        FileOutputStream otputStream2 = new FileOutputStream(reader.readLine());

        byte[] buffer = new byte[inputStream.available()];
        int sizeFilesReader = inputStream.read(buffer);
        int sizeFilesFirsHalf = sizeFilesReader - (sizeFilesReader / 2);

        otputStream1.write(buffer, 0, sizeFilesFirsHalf);
        otputStream2.write(buffer, sizeFilesFirsHalf, sizeFilesReader - sizeFilesFirsHalf);

        inputStream.close();
        otputStream1.close();
        otputStream2.close();
    }
}
