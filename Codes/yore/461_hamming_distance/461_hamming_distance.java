class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int result = x ^ y;
        String binaryStr = Integer.toBinaryString(result);
        for(int i=0;i<binaryStr.length();i++){
            if(binaryStr.charAt(i) =='1'){
                count++;
            }
        }
        return count;
    }
}