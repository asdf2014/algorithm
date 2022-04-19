package com.yore.easy;

/**
 * @author Yore
 * @date 2022/3/7 22:04
 * @description
 */
public class Number415 {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int i = l1 - 1;
        int j = l2 - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder("");
        while (i >= 0 || j >= 0) {
            int a = 0;
            int b = 0;
            if (i >= 0) {
                a = Integer.valueOf(String.valueOf(num1.charAt(i--)));
            }
            if (j >= 0) {
                b = Integer.valueOf(String.valueOf(num2.charAt(j--)));
            }
            int sum = a + b + carry;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            sum = sum % 10;
            sb.append(sum);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
