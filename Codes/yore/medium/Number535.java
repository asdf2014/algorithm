package com.yore.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2022/6/29 8:38
 * @description
 */
public class Number535 {

    int counter = 0;
    Map<Integer, String> dataBase = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        counter++;
        dataBase.put(counter, longUrl);
        return "http://tinyurl.com/" + counter;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] s = shortUrl.split("/");
        int idx = Integer.parseInt(s[s.length - 1]);
        return dataBase.get(idx);
    }
}
