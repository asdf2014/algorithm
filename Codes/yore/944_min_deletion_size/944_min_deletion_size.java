class Solution {
    public int minDeletionSize(String[] A) {
        int count = 0;
        int rowLength = A.length;
        if (rowLength == 1) {
            return 0;
        }
        int colLength = A[0].length();
        for (int col = 0; col < colLength; col++) {
            for (int row = 1; row < rowLength; row++) {
                if (A[row].charAt(col) < A[row - 1].charAt(col)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}