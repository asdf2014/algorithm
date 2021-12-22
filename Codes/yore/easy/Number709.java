package com.yore.easy;

/**
 * Created on 2019/1/24
 * 转换成小写字母
 *
 * @author jiabingwen
 */

public class Number709 {

    public static void main(String[] args) {
        Number709 number709 = new Number709();
        long startTime = System.currentTimeMillis();
        System.out.println(number709.toLowerCase("aSafdADsSkjhhhhhhhhhhhhhhhhhhhhhhhhhhADDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"));
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        System.out.println(number709.toLowerCase2("aSafdADsSkjhhhhhhhhhhhhhhhhhhhhhhhhhhADDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"));
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c += 32;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public String toLowerCase2(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c |= 32;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
