package com.yore.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 2019/1/24
 * 独特的电子邮件地址
 *
 * @author jiabingwen
 */

public class Number929 {

    public static void main(String[] args) {
        Number929 number929 = new Number929();
        long startTime = System.currentTimeMillis();
        System.out.println(number929.numUniqueEmails(new String[]{
                "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> targetSet = new HashSet<>();
        for (String email : emails) {
            boolean domainFlag = false;
            boolean plusFlag = false;
            char[] emailCharArray = email.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char singleChar : emailCharArray) {
                if (domainFlag) {
                    sb.append(singleChar);
                    continue;
                }
                if (singleChar == '@') {
                    sb.append(singleChar);
                    domainFlag = true;
                    continue;
                }
                if (plusFlag && !domainFlag) {
                    continue;
                }
                if (singleChar == '+') {
                    plusFlag = true;
                    continue;
                }
                if (singleChar == '.') {
                    continue;
                }
                sb.append(singleChar);
            }
            targetSet.add(sb.toString());
        }
      //  System.out.println(targetSet);
        return targetSet.size();
    }

}
