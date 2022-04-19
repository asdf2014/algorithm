package com.yore.medium;

/**
 * @author Yore
 * @date 2022/2/25 9:22
 * @description
 */
public class Number537 {
    public String complexNumberMultiply(String num1, String num2) {
        int[] n1 = convert2Num(num1);
        int[] n2 = convert2Num(num2);
        int r = n1[0] * n2[0] - n1[1] * n2[1];
        int v = n1[1] * n2[0] + n1[0] * n2[1];
        return r + "+" + v + "i";
    }

    public int[] convert2Num(String number) {
        String[] sp = number.split("\\+");
        int[] res = new int[2];
        res[0] = Integer.valueOf(sp[0]);
        res[1] = Integer.valueOf(sp[1].substring(0, sp[1].length() - 1));
        return res;
    }
}
