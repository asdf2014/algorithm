/**
 * ClassName: Solution_43
 * Date:      2020/7/20 15:07
 * author:    Oh_MyBug
 * version:   V1.0
 */

/*
43. 字符串相乘
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
示例 1:
输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:
输入: num1 = "123", num2 = "456"
输出: "56088"
说明：
num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
通过次数73,963提交次数174,153
 */
public class Solution_43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        return len1 >= len2 ? add_res(multiply_res(num1, num2)) : add_res(multiply_res(num2, num1));
    }

    public String[] multiply_res(String max_num, String min_num){
        int pop;
        int max_len = max_num.length();
        int min_len = min_num.length();
        String[] res = new String[min_len];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = min_len - 1; i >= 0; i--) {

            stringBuilder.delete(0, stringBuilder.length());
            pop = 0;

            for (int j = 0; j < min_len - 1 - i; j++)
                stringBuilder.append('0');
            for (int j = max_len - 1; j >= 0; j--) {
                int temp = (max_num.charAt(j) - '0' ) * (min_num.charAt(i) - '0') + pop;
                pop = temp >= 10 ? temp / 10 : 0;
                stringBuilder.append(temp % 10);
            }

            if (pop != 0)
                stringBuilder.append(pop);

            res[i] = stringBuilder.toString();
        }
        return res;
    }

    public String add_res(String[] multiply_res){
        int pop = 0;
        int len = multiply_res.length;
        String res = multiply_res[0];
        for (int i = 1; i < len; i++)
            res = add(multiply_res[i], res);
        return new StringBuilder(res).reverse().toString();
    }

    public String add(String num1, String num2){
        int pop = 0;
        int len1 = num1.length();
        int len2 = num2.length();
        int index1 = 0, index2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index2 < len2 && index1 < len1){
            int temp = (num1.charAt(index1) - '0') + (num2.charAt(index2) - '0') + pop;
            pop = temp >= 10 ? 1 : 0;
            stringBuilder.append(temp % 10);
            index2 ++;
            index1 ++;
        }

        while (index1 < len1){
            int temp = (num1.charAt(index1) - '0') + pop;
            pop = temp >= 10 ? 1 : 0;
            stringBuilder.append(temp % 10);
            index1 ++;
        }

        while (index2 < len2){
            int temp = (num2.charAt(index2) - '0') + pop;
            pop = temp >= 10 ? 1 : 0;
            stringBuilder.append(temp % 10);
            index2 ++;
        }

        if (pop != 0)
            stringBuilder.append(pop);

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
//        Solution_43 solution_43 = new Solution_43();
//        System.out.println(solution_43.multiply("123", "456"));
        String num1 = new String("0"), num2 = new String("0");
        System.out.println(num1 == num2);
    }
}
