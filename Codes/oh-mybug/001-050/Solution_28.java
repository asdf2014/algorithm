/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_28
 * Data:        2020/7/16
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
28. 实现 strStr()
实现 strStr() 函数。
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
示例 1:
输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:
输入: haystack = "aaaaa", needle = "bba"
输出: -1
 */
public class Solution_28 {
    public static int BF(String haystack, String needle) {
        int haystack_len = haystack.length(),
                needle_len = needle.length();
        if (needle_len == 0) return 0;
        if (haystack_len ==0) return -1;
        int res, haystack_cur = 0;
        while (haystack_cur < haystack_len){
            if (haystack.charAt(haystack_cur) == needle.charAt(0)){
                res = haystack_cur;
                for (int i = 0; i < needle_len; i++) {
                    if (haystack_cur + i >= haystack_len) return -1;
                    if (haystack.charAt(haystack_cur + i) != needle.charAt(i))  break;
                    if (i == needle_len - 1 && haystack.charAt(haystack_cur + i) == needle.charAt(i))
                        return res;
                }
            }
            ++ haystack_cur;
        }
        return -1;
    }

    public static int[] get_next(String needle){
        int len = needle.length();  // 获取字符串长度
        int[] next = new int[len];
        next[0] = -1;   // 人为规定为-1
        int index = 0, k = -1;  // 可以将index理解为当前右指针，k理解为左指针
        while (index < len - 1){
            // 当k = -1时，特殊情况，前缀和后缀不能为字符串本身
            // 当左右指针所指元素相同时，右指针右移，值为左指针右移后的值
            if (k == -1 || needle.charAt(index) == needle.charAt(k))
                next[++ index] = ++k;
            else    // 当左右指针所指元素不相同时
                k = next[k];    // 左指针则指向当前左指针所指字符的对应next值对应的字符
        }
        return next;
    }

    public static int KMP(String haystack, String needle){
        int haystack_len = haystack.length(),
                needle_len = needle.length();
        if (needle_len == 0) return 0;          // 触发边界返回值
        int haystack_cur = 0, needle_cur = 0;   // 两个字符串指针
        int[] next = get_next(needle);          // 获取next数组
        while(haystack_cur < haystack_len && needle_cur < needle_len){
            // 如果两个指针所指的字符相同
            if (haystack.charAt(haystack_cur) == needle.charAt(needle_cur)){
                // 两个指针右移
                ++ haystack_cur;
                ++ needle_cur;
            }else{
                if (needle_cur == 0)    // needle_cur 已经到了第一个字符了，退无可退
                    ++ haystack_cur;    // haystack_cur 老老实实后移
                else
                    needle_cur = next[needle_cur];  // // needle 的 needle_cur 还能后移
            }
        }
        return needle_cur == needle_len ? haystack_cur - needle_len : -1;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            // 测试KMP算法
            KMP("111111111111111111111111110", "111111110");
        }
        end = System.currentTimeMillis();
        System.out.println("KMP算法耗时: " + (end-start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            // 测试BF算法
            BF("111111111111111111111111110", "111111110");
        }
        end = System.currentTimeMillis();
        System.out.println("BF算法耗时: " + (end-start));
    }
}
