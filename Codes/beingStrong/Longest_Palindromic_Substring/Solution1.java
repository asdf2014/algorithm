/*
这里我们假设dp[i][j]表示的是对于[i,j]的字符串是不是回文串
状态转移方程为dp[i][j]=(s[i]==s[j])&&(dp[i+1][j-1]);
这里如果j-i-1>1才需要后面的dp[i+1][j-1]的判断，如果这两个里面只有一个字符或者没有字符，直接只需要判断前半部分就好了也就是j-i<=2时不需要做判断
*/
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();

        if(n==0||n==1) return s;

        boolean[][]dp=new boolean[n][n];

        String res=s.charAt(0)+"";

        //这里要算以j为结尾的最长的回文串，如果算以j为开头的，会产生未知条件
        for(int j=1;j<n;j++) {
            for(int i=0;i<j;i++) {

                if(s.charAt(j)==s.charAt(i)&&(i-j<=2||dp[i+1][j-1])) {
                    dp[i][j]=true;

                    //如果这个回文串的长度大于res的长度，就改变res
                    if(j-i+1>res.length()) {
                        res=s.substring(i,j+1);
                    }
                }
            }
        }

        return res;
    }
}