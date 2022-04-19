package com.yore.offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/22 17:08
 * @description
 */
public class Offer087 {
    public List<String> result = new ArrayList<String>();
    public List<String> path = new ArrayList<String>();
    public int IP_SEG = 4;

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return result;
        }
        process(s, 0);
        return result;
    }

    public void process(String s, int index) {
        if (index >= s.length() && path.size() == 4) {
            StringBuilder sb = new StringBuilder("");
            for (String str : path) {
                sb.append(str).append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
            return;
        }
        int len = index + 3 >= s.length() ? s.length() : index + 3;
        for (int i = index; i < len; i++) {
            String tmp = s.substring(index, i + 1);
            int num = Integer.valueOf(tmp);
            if (num > 255 || (num == 0 && tmp.length() > 1) || (num > 0 && tmp.charAt(0) - '0' == 0)) {
                continue;
            }
            path.add(tmp);
            process(s, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
