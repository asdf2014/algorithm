package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/7/8 7:54
 * @description
 */
public class Offer67 {
    public int strToInt(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int len = str.length();
        int index = 0;
        while (str.charAt(index) == ' ') {
            index++;
            if (index >= len) {
                return 0;
            }
        }
        String result;
        boolean flag = false;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            flag = true;
            index++;
        }
        result = convert(str, index);
        if ("".equals(result)) {
            return 0;
        }
        try {
            int value = Integer.parseInt(result);
            if (flag) {
                value = -value;
            }
            return value;
        } catch (Exception e) {
            if (e instanceof NumberFormatException) {
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return 0;
    }

    public String convert(String str, int index) {
        StringBuilder sb = new StringBuilder();
        while (index < str.length() && '0' <= str.charAt(index) && str.charAt(index) <= '9') {
            sb.append(str.charAt(index));
            index++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Offer67 o = new Offer67();
        System.out.println(o.strToInt("   -423  adf"));
    }
}
