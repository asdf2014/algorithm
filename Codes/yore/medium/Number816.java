package com.yore.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yore
 * @date 2021/3/9 19:52
 * @description
 */
public class Number816 {
    public static void main(String[] args) {
        String s = "(12345)";
        Number816 number=new Number816();
        for(String res : number.ambiguousCoordinates(s)){
            System.out.println(res);
        }
//        System.out.println(number.ambiguousCoordinates(s));
    }

    public List<String> ambiguousCoordinates(String S) {
        List<String> result = new ArrayList<>();
        int length = S.length();
        for (int i = 2; i < length - 1; i++) {
            for (String leftCoordinate : generate(S, 1, i)) {
                for (String rightCoordinate : generate(S, i, length - 1)) {
                    result.add("(" + leftCoordinate + "" + rightCoordinate + ")");
                }
            }
        }
        return result;
    }

    public List<String> generate(String coordinate, int i, int j) {
        List<String> enableList = new ArrayList<>();
        String leftCoordinate, rightCoordinate;
        for (int d = 1; d <= j - i; d++) {
            leftCoordinate = coordinate.substring(i, i + d);
            rightCoordinate = coordinate.substring(i + d, j);
            if ((!leftCoordinate.startsWith("0") || "0".equals(leftCoordinate))
                    && !rightCoordinate.endsWith("0")) {
                enableList.add(leftCoordinate + (d < j - i ? "." : "") + rightCoordinate);
            }
        }
        return enableList;
    }

}
