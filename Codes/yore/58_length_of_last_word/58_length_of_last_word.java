class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        String[] array = s.split(" ");
        int length = array.length;
        if (length > 0) {
            String str = array[length - 1];
            return str.length();
        }
        return 0;
    }
}