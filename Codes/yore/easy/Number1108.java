package com.yore.easy;

/**
 * @author Yore
 * @date 2022/6/21 8:31
 * @description
 */
public class Number1108 {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[\\.]");
    }
}
