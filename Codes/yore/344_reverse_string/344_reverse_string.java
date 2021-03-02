class Solution {
    public void reverseString(char[] s) {
        int length = s.length;
        int i = 0;
        int j = length - 1;
        char tmp;
        while (i < j) {
            tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
    }
}