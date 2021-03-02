class Solution {
    public int[] diStringMatch(String S) {
        int[] array = new int[S.length() + 1];
        char[] charArray = S.toCharArray();
        int index = 0;
        int small=0;
        int big = S.length();
        for (char character : charArray) {
            if (character == 'I') {
                array[index++] = small++;
            } else {
                array[index++] =big--;
            }
        }
        array[S.length()] = big;
        return array;
    }
}