package com.yore.medium;

/**
 * @author Yore
 * @date 2022/5/13 8:23
 * @description
 */
public class Interview0105 {

    public static void main(String[] args) {
        Interview0105 interview0105 = new Interview0105();
        System.out.println(interview0105.oneEditAway("teacher","beacher"));
    }



    public boolean oneEditAway(String first, String second) {
        return isSame(first, second, 0, 0,0);
    }

    public boolean isSame(String s1, String s2, int idx1, int idx2,int update) {
        if (idx1 >= s1.length() && idx2 >= s2.length()) {
            return update <= 1;
        }
        if (idx1 >= s1.length() || idx2 >= s2.length()) {
            return s2.length() - idx2 + s1.length() - idx1 + update <= 1;
        }
        if (update > 1) {
            return false;
        }
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return isSame(s1, s2, idx1 + 1, idx2 + 1,update);
        } else {
            update += 1;
            return isSame(s1, s2, idx1 + 1, idx2,update) || isSame(s1, s2, idx1, idx2 + 1,update) || isSame(s1, s2, idx1 + 1, idx2 + 1,update);
        }
    }
}
