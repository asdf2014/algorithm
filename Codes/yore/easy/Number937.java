package com.yore.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Yore
 * @date 2022/5/3 10:24
 * @description
 */
public class Number937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> numList = new ArrayList<>();
        List<Log> logList = new ArrayList<>();
        for (String log : logs) {
            int len = log.length();
            int index = 0;
            while (index < len && log.charAt(index) != ' ') {
                index++;
            }
            String key = log.substring(0, index);
            String content = log.substring(index + 1, len);
            char ch = content.charAt(0);
            boolean isLetter = Character.isLowerCase(ch);
            if (!isLetter) {
                numList.add(log);
            } else {
                logList.add(new Log(key, content));
            }
        }
        Collections.sort(logList, new Comparator<Log>() {
            @Override
            public int compare(Log l1, Log l2) {
                return l1.content.equals(l2.content) ? l1.key.compareTo(l2.key) : l1.content.compareTo(l2.content);
            }
        });
        String[] res = new String[logs.length];
        int idx = 0;
        for (Log log : logList) {
            res[idx++] = (log.key + ' ' + log.content);
        }
        for (String content : numList) {
            res[idx++] = content;
        }
        return res;
    }

    class Log {
        String key;
        String content;

        public Log(String key, String content) {
            this.key = key;
            this.content = content;
        }
    }
}
