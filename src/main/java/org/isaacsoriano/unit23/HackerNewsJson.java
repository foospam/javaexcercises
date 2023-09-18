package org.isaacsoriano.unit23;

import java.util.Map;

public class HackerNewsJson {
    public static void main(String[] args) {
        Map<String, String> map = System.getenv();
        for (String key: map.keySet()
             ) {
            System.out.println(key+" : "+map.get(key));

        }

        System.out.println(System.getenv().getClass());
    }
}
