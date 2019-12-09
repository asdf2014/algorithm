class Solution {
    public String convert(String s, int numRows) {
        if (s == null)
            return s;

        int n = s.length();

        if (n == 0)
            return s;

        if(numRows==1)
            return s;

        if(n<=numRows)
            return s;

        StringBuffer[] res = new StringBuffer[numRows];
        for (int i = 0; i < res.length; i++)
            res[i] = new StringBuffer();

        boolean flag = false;
        int rows = 0;

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            res[rows].append(arr[i]);
            if(rows==0||rows==numRows-1) flag=!flag;
            rows+=flag?1:-1;
        }

        StringBuffer ans=new StringBuffer();
        for(StringBuffer cur:res) {
            ans.append(cur);
        }

        return ans.toString();
    }
}