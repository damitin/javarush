package com.javarush.task.task18.task1827;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        if (args.length == 0) {
            return;
        } else if (args[0].equals("-c")) {
            reader = new BufferedReader(new FileReader(fileName));
            int id;
            int max = 0;
            while (reader.ready()) {
                id = Integer.parseInt(reader.readLine().substring(0,8).trim());
                if (id > max) max = id;
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.newLine();
            writer.write(String.format("%-8d%-30.30s%-8.8s%-4.4s",max+1,args[1],args[2],args[3]));
            writer.close();
        }
    }
}
