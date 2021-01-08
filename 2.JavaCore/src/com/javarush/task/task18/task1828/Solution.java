package com.javarush.task.task18.task1828;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static java.lang.String.format;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname = reader.readLine(); //Имя файла на диске
        reader.close();
        ArrayList<Product> productList = new ArrayList<>();//Список товаров
        if (args.length>0){//Если аргументы запуска есть
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fname)));
            while (fileReader.ready()){
                String input = fileReader.readLine();
                if (!input.equals("")) {
                    Product product = new Product(input);
                    productList.add(product);
                }
            }
            fileReader.close();
            Product findProduct = null;
            int num = 0;
            for (int i = 0; i < productList.size(); i++) {//Находим товар с нужным id
                if (productList.get(i).getId()==Integer.parseInt(args[1].replace(" ",""))){
                    findProduct = productList.get(i);
                    num = i;
                    break;
                }
            }
            fileReader.close();
            if (args[0].equals("-u")){//Изменяем товар в файле
                Product newproduct = new Product(findProduct.getId(),args[2],args[3].replace(" ",""),Integer.parseInt(args[4].replace(" ","")));
                productList.set(num,newproduct);
//                productList.remove(findProduct);
//                productList.add(newproduct);
            }
            if (args[0].equals("-d")){//Удаляем товар в файле
                productList.remove(findProduct);
            }
            BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fname)));
            for (int i = 0; i < productList.size(); i++) {//Пишем изменения в файл
                fileWriter.write(productList.get(i).getString());
                if (i<productList.size()-1) fileWriter.write("\n");
            }
            fileWriter.close();
        }
    }
}