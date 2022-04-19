package com.yore.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/3/1 8:16
 * @description
 */
public class Number119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    t.add(1);
                } else {
                    t.add(list.get(j - 1) + list.get(j));
                }
            }
            list = t;
        }
        return list;
    }
}
