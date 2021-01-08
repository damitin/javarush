package com.javarush.task.task19.task1918;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Знакомство с тегами
*/

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
        while (reader1.ready()) {
            stringBuilder.append(reader1.readLine());
        }
        reader1.close();

        Document document = Jsoup.parse(stringBuilder.toString(), "", Parser.xmlParser());
        Elements elements = document.select(args[0]);
        for (Element element : elements) {
            System.out.println(element);
        }
    }
}
