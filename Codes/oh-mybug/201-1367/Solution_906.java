import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution_906
 * Date:      2020/4/5 22:02
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
906. 超级回文数
如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。
现在，给定两个正整数 L 和 R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。
示例：
    输入：L = "4", R = "1000"
    输出：4
解释：
    4，9，121，以及 484 是超级回文数。
    注意 676 不是一个超级回文数： 26 * 26 = 676，但是 26 不是回文数。
提示：
    1 <= len(L) <= 18
    1 <= len(R) <= 18
    L 和 R 是表示 [1, 10^18) 范围的整数的字符串。
    int(L) <= int(R)

 */
public class Solution_906 {
    @Test
    public void test() {
        System.out.println(superpalindromesInRange("38455498359", "999999999999999999"));
    }

    /**
     * 生成[sqrt_L,sqrt_R]范围内的所有回文数并装入palindromes容器中，
     * 然后将这些回文数求平方，判断平方后的数是否仍为回文数，
     * 若是，则count计数器自增，直至结束
     * @Function superpalindromesInRange
     * @author   Oh_MyBug
     * @Date     2020/4/6 3:44
     * @param
     * @return
     */
    public int superpalindromesInRange(String L, String R) {
        long L_sqrt = (long)Math.sqrt(Long.parseLong(L));
        long R_sqrt = (long)Math.sqrt(Long.parseLong(R));
        int L_len = Long.toString(L_sqrt).length();
        int R_len = Long.toString(R_sqrt).length();
        int count = 0;
        List<String> palindromes;
        for (int i = L_len; i <= R_len; i ++){
            palindromes = getPalindromes(i);
            for (String palindrome:palindromes) {
                long temp = Long.parseLong(palindrome) * Long.parseLong(palindrome);
                if (temp >= Long.parseLong(L) && temp <= Long.parseLong(R)) {
                    if (isPalindromes(temp)) {
                        count++;
                        System.out.println(temp);
                    }
                }
                if (temp > Long.parseLong(R)) break;
            }
            palindromes.clear();
        }
        return count;
    }

    /**
     * 生成长度为length的回文数
     * 比如长度为2的回文数有11 22 33 44 55 66 77 88 99
     * @Function getPalindromes
     * @author   Oh_MyBug
     * @Date     2020/4/6 3:46
     * @param
     * @return
     */
    public List<String> getPalindromes(int length){
        List<String> palindromes = new ArrayList<>();
        if (length == 1){
            for (int j = 0; j <= 9; j ++){
                palindromes.add(Integer.toString(j));
            }
            return palindromes;
        }
        for (int i = (int) Math.pow(10,length/2 - 1); i < Math.pow(10,length/2); i ++){
            if (length % 2 == 1){
                for (int j = 0; j <= 9; j ++){
                    palindromes.add(Integer.toString(i) + Integer.toString(j) + reverse(i));
                }
            }else{
                palindromes.add(Integer.toString(i) + reverse(i));
            }
        }
        return palindromes;
    }

    /**
     * 将数字num反转并返回字符串，如10返回“01”
     * @Function reverse
     * @author   Oh_MyBug
     * @Date     2020/4/6 3:45
     * @param
     * @return
     */
    public String reverse(int num){
        char[] chars = Integer.toString(num).toCharArray();
        char temp;
        for (int i = 0; i < chars.length/2; i ++){
            temp = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = temp;
        }
        return String.valueOf(chars);
    }

    /**
     * 判断num是否为回文数
     * @Function isPalindromes
     * @author   Oh_MyBug
     * @Date     2020/4/6 3:45
     * @param    num
     * @return
     */
    public boolean isPalindromes(long num) {
        char[] chars = Long.toString(num).toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
