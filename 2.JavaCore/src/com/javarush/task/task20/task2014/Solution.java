package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Externalizable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));

        File saved = new File("D:\\123.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(saved);
        FileInputStream fileInputStream = new FileInputStream(saved);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Solution original = new Solution(100);
        objectOutputStream.writeObject(original);
        Solution loaded = (Solution) objectInputStream.readObject();

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(string);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        string = (String) in.readObject();
    }
}
