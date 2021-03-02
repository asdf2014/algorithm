class Solution {
    public boolean isMonotonic(int[] array) {
       boolean increase = false;
        int begin = 0;
        int length = array.length;
        if (length <= 2) {
            return true;
        }
        if (array[0] < array[1]) {
            begin = 1;
            increase = true;
        }
        if (array[0] == array[1]) {
            for (int i = 1; i < length-1; i++) {
                if (array[i] > array[i + 1]) {
                    begin = i + 1;
                    break;
                }
                if (array[i] < array[i + 1]) {
                    increase = true;
                    begin = i + 1;
                    break;
                }
            }
        }
        for (int i = begin; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                continue;
            }
            if (array[i] < array[i + 1] && !increase) {
                return false;
            } else if (array[i] > array[i + 1] && increase) {
                return false;
            }
        }
        return true;
    }
}
