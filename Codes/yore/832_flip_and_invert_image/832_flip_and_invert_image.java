class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
         int rowLength = A.length;
        if (rowLength == 0) {
            return null;
        }
        int colLength = A[0].length;
        int begin = 0;
        int end = colLength - 1;
        int tmp = 0;
        for (int i = 0; i < rowLength; i++) {
            while (begin <= end) {
                if (begin == end) {
                    A[i][begin] = A[i][begin] == 0 ? 1 : 0;
                    break;
                } else {
                    tmp = A[i][begin];
                    A[i][begin++] = A[i][end] == 0 ? 1 : 0;
                    A[i][end--] = tmp == 0 ? 1 : 0;
                }
            }
            begin = 0;
            end = colLength - 1;
        }
        return A;
    }
}