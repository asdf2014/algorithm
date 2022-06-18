package com.yore.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/3/1 8:16
 * @description
 */
public class Number118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        for (int i = 1; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            rowList.add(1);
            List<Integer> preRow = result.get(i - 1);
            int pre = preRow.get(0);
            for (int k = 1; k < preRow.size(); k++) {
                int cur = preRow.get(k);
                rowList.add(cur + pre);
                pre = cur;
            }
            rowList.add(1);
            result.add(rowList);
        }
        return result;
    }
}
