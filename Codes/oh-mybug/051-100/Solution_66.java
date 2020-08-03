import java.util.Arrays;

/**
 * ClassName:   Solution_65
 * Data:        2020/7/25
 * author:      Oh_MyBug
 * version:     V1.0
 */
public class Solution_66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0) return new int[]{1};
        digits[len - 1] = (digits[len - 1] + 1) % 10;
        int pop = digits[len - 1] == 0 ? 1 : 0;
        for (int i = len - 2; i >= 0 && pop != 0; i--) {
            digits[i] = (digits[i] + pop) % 10;
            pop = digits[i] == 0 ? 1 : 0;
        }
        if (pop == 0)
            return digits;
        else{
            int[] res = new int[len + 1];
            res[0] = pop;
            System.arraycopy(digits, 0, res, 1, len);
            return res;
        }
    }

    public static void main(String[] args) {
        Solution_66 solution_66 = new Solution_66();
        System.out.println(Arrays.toString(solution_66.plusOne(new int[]{9, 9})));
    }
}
