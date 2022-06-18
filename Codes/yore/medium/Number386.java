package com.yore.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/4/18 9:23
 * @description
 */
public class Number386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            list.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return list;
    }
}
