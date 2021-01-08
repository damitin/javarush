package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        String URL=new BufferedReader(new InputStreamReader(System.in)).readLine().replaceAll("^(.*\\?)","");
        for(String s:URL.split("&")) System.out.print(s.replaceAll("=.*$","")+" ");
        System.out.println();
        for(String s:URL.split("&")){
            if(s.replaceAll("=.*$","").equals("obj")){
                try{
                    alert(Double.parseDouble(s=s.replaceAll("^[^=]*=","")));
                }catch(NumberFormatException e){
                    alert(s);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
