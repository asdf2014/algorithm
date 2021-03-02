class Solution {
    public int[] sortedSquares(int[] A) {
         int length = A.length;
        int[] b = new int[length];
        int i = 0;
        int forward = 0;
        int backward = 0;
        for (; i < length; i++) {
            if (A[i] >= 0) {
                forward = i - 1;
                backward = i;
                break;
            }
        }
        if (i == length) {
            forward = length - 1;
            backward = length;
        }
        int index = 0;
        int data1;
        int data2;
        while (forward >= 0 || backward < length) {
            if (forward < 0) {
                b[index++] = A[backward] * A[backward];
                backward++;
            } else if (backward >= length) {
                b[index++] = A[forward] * A[forward];
                forward--;
            } else {
                data1 = A[forward] * A[forward];
                data2 = A[backward] * A[backward];
                if (data1 >= data2) {
                    b[index++] = data2;
                    backward++;
                } else {
                    b[index++] = data1;
                    forward--;
                }
            }
        }
        return b;
    }
}