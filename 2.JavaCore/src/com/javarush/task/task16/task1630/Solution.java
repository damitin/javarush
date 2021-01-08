package com.javarush.task.task16.task1630;

import java.io.*;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private String fileContent = "";
        @Override
        public void setFileName(String fullFileName) {
            fileName=fullFileName;
        }
        @Override
        public String getFileContent() {
            return fileContent;
        }
        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))){
                String str;
                while ((str=reader.readLine())!=null){
                    fileContent+=str+" ";
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("ошибка");
            }
        }
    }
}
