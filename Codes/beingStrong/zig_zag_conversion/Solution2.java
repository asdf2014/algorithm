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

        int step=numRows*2-2;

        StringBuffer res=new StringBuffer();

        char[]arr=s.toCharArray();

        //遍历所有的行，一行一行的添加到结果中
        for(int i=0;i<numRows;i++){

            //设置一个变量保存当前的这一行的开始的坐标
            int start=i;
            int add=2*i;

            //循环将这一行的所有的字符添加进结果中
            while(start<n){
                res.append(arr[start]);

                add=step-add;

                //如果是第一行和最后一行，只需要累加step就好了
                if(i==0||i==numRows-1){
                    start+=step;
                }else{
                    start+=add;
                }
            }
        }

        return res.toString();
    }
}