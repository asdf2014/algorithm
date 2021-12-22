package com.yore.easy;

/**
 * Created on 2019/1/25
 *
 * @author jiabingwen
 */

public class Number657 {
    public static void main(String[] args) {
        Number657 number657 = new Number657();
        long startTime = System.currentTimeMillis();
        System.out.println(number657.judgeCircle("LLUUDDRLRR"));
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public boolean judgeCircle(String moves) {
        int level = 0;
        int vertical = 0;
        char[] array = moves.toCharArray();
        for (char character : array) {
            switch (character) {
                case 'U':
                    vertical++;
                    break;
                case 'D':
                    vertical--;
                    break;
                case 'L':
                    level++;
                    break;
                case 'R':
                    level--;
                    break;
                default:
            }
        }
        return (level == 0 && vertical == 0);
    }


}
