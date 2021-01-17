package com.javarush.task.task21.task2107;

import javax.jws.soap.SOAPBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
        System.out.println(solution.users == clone.users);
    }

    protected Map<String, User> users = new LinkedHashMap();

    public Object clone() throws CloneNotSupportedException {
        Solution solution1 = (Solution) super.clone();
        Map<String, User> userMap = new LinkedHashMap<>();
        for (Map.Entry<String, User> entry : users.entrySet()) {
            String str = entry.getKey();
            User user = (User) entry.getValue().clone();
            userMap.put(str, user);
        }
        solution1.users = userMap;
        return solution1;
    }

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return age == user.age && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
