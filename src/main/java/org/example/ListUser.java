package org.example;

import java.util.ArrayList;
import java.util.List;

public class ListUser {
    public int main() {
        List<String> list = new ArrayList<>();
        list.add("original");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Item " + i);
            System.out.println(list.get(i));
        }
        return list.size();
    }

    public static String listItem() {
        List<String> list = new ArrayList<>();
        list.add("c");
        System.err.println(list);
        return list.get(0);
    }
}
