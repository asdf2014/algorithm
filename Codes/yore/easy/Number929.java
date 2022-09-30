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
        Set<String> union = new HashSet<>();
        for (String email : emails) {
            String[] content = email.split("@");
            String local = content[0];
            local = local.replaceAll("\\.", "");
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf("+"));
            }
            union.add(local + "@" + content[1]);
        }
        return union.size();
    }
}
