package test;

import algorithm.MyHashMap;

/**
 * Title: <br/>
 * Description: <br/>
 * Copyright: 2024 <br/>
 * Company:<br/>
 * Project: design-pattern <br/>
 *
 * @Author huanglian <br/>
 * Create Time:7/15/24 14:30 <br/>
 */
public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>(32);
        map.put("foo", "bar");
        map.put("bar", "baz");
        map.put("bar", "newBar");
        map.put("aa", "bb");

        System.out.println(map.get("bar"));

        System.out.println(map.remove("foo"));

        System.out.println(map.remove("foo"));
    }
}
