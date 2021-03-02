class Solution {
    public int[] sortArrayByParity(int[] A) {
            int length = A.length;
        int begin = 0;
        int end = length - 1;
        while (begin < end) {
            int num1 = A[begin];
            if (num1 % 2 == 0) {
                begin++;
            } else if (A[end] % 2 == 1) {
                end--;
            } else {
                A[begin] = A[end];
                A[end] = num1;
                begin++;
                end--;
            }
        }
        return A;
    }
}