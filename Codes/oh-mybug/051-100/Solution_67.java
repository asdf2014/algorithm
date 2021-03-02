/**
 * ClassName:   Solution_67
 * Data:        2020/7/25
 * author:      Oh_MyBug
 * version:     V1.0
 */
public class Solution_67 {
//    public String addBinary(String a, String b) {
//        int len_a = a.length();
//        int len_b = b.length();
//        if (len_a == 0 && len_b == 0) return "0";
//        StringBuilder stringBuilder = new StringBuilder();
//        char pop = '0';
//        while (len_a != 0 && len_b != 0){
//            len_a --;
//            len_b --;
//            stringBuilder.insert(0, (a.charAt(len_a) + b.charAt(len_b) + pop - 3 * '0') % 2);
//            if (a.charAt(len_a) + b.charAt(len_b) + pop - 3 * '0' > 1)
//                pop = '1';
//            else
//                pop = '0';
//        }
//        while (len_a != 0){
//            len_a --;
//            stringBuilder.insert(0, (a.charAt(len_a) + pop - 2 * '0') % 2);
//            pop = a.charAt(len_a) + pop - 2 * '0' > 1 ? '1' : '0';
//            if (pop == '0'){
//                stringBuilder.insert(0, a.substring(0, len_a));
//                break;
//            }
//        }
//        while (len_b != 0){
//            len_b --;
//            stringBuilder.insert(0, (b.charAt(len_b) + pop - 2 * '0') % 2);
//            pop = b.charAt(len_b) + pop - 2 * '0' > 1 ? '1' : '0';
//            if (pop == '0'){
//                stringBuilder.insert(0, b.substring(0, len_b));
//                break;
//            }
//        }
//        if (pop == '1')
//            stringBuilder.insert(0, pop);
//        return stringBuilder.toString();
//    }

    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

    public static void main(String[] args) {
        Solution_67 solution_67 = new Solution_67();
        System.out.println(solution_67.addBinary("100", "110010"));
    }
}
