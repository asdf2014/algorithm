class Solution {
    public int repeatedNTimes(int[] A) {
         if (A == null || A.length == 0) {
            return 0;
        }
        if (A[0] == A[A.length - 1]) {
            return A[0];
        }
        for (int i = 2; i < A.length; i++) {
            if (A[i] == A[i - 1] || A[i] == A[i - 2]) {
                return A[i];
            }
        }
        return -1;
    }
}