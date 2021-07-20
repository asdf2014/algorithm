package com.yore.medium;

/**
 * Created on 2019/1/29
 *
 * @author jiabingwen
 */

public class Number8 {
    public static void main(String[] args) {
        System.out.println(myAtoi(" -3"));
    }

    /**
     * 根据题意 排出非法条件即可
     * @param str
     * @return
     */
    private static int myAtoi(String str) {
        int i = 0;
        int j = 0;
        if (str.length() == 0) {
            return 0;
        }
        try {
            for (char character : str.toCharArray()) {
                if (j == 0) {
                    if (character == 32) {
                        i++;
                    } else if (character == 45 || character == 43 ||
                            character >= 48 && character <= 57) {
                        j = i + 1;
                    } else {
                        break;
                    }
                } else {
                    if (character == 45 || character == 43) {
                        break;
                    }
                    if (character >= 48 && character <= 57) {
                        j++;
                    } else {
                        break;
                    }
                }
            }
            if (i == 0 && j == 0) {
                return 0;
            }
            String result = str.substring(i, j);
            if ("-".equals(result) || "+".equals(result)) {
                return 0;
            }
            return Integer.valueOf(result);
        } catch (Exception e) {
            if (e instanceof NumberFormatException) {
                if (str.charAt(i) == 45) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return 0;
    }
}
