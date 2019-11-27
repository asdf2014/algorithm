class Solution {
    public int lengthOfLongestSubstring(String s) {
        //加一个判空操作
        if(s.equals("")||s==null) return 0;

        //设置一个map存储每一个字符及其对应的位置，便于l的移动
        Map<Character,Integer> isHave=new HashMap<Character,Integer>();

        //设置左指针
        int l=0;

        int max=1;

        for(int r=0;r<s.length();r++){
            char cur=s.charAt(r);

            if(isHave.containsKey(cur)){
                int idx=isHave.get(cur);
                //这里必须是当这个重复点的位置在l或者l的后面l才移动
                if(l<=idx) {
                    l=idx+1;
                }
            }
            isHave.put(cur,r);

            max=Math.max(r-l+1,max);
        }

        return max;
    }
}