package com.leetcode;
import java.lang.StringBuilder;

public class Solution0006 {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<numRows;i++) {
            int idx = i;
            if(i == 0 ||i == numRows - 1) {
                
                while(idx < s.length()){
                    sb.append(s.substring(idx, idx+1));
                    idx +=2 * (numRows - 1);
                }
            } else {
                while(idx < s.length()){
                    sb.append(s.substring(idx, idx+1));
                    idx += 2 * (numRows - 1 - i);
                    if(idx < s.length()) {
                        sb.append(s.substring(idx, idx+1));
                        idx += 2*i;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution0006 instance = new Solution0006();
        System.out.println(instance.convert("PAYPALISHIRING", 2));
    }
}