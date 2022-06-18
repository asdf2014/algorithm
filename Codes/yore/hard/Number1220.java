package com.yore.hard;

/**
 * @author Yore
 * @date 2022/1/17 9:00
 * @description
 */
public class Number1220 {
    public long res = 0L;
    public long mod = 1000000007L;

    public int countVowelPermutation(int n) {

        String choice = "aeiou";
        long[][] record = new long[26][n];
        for (int i = 0; i < 5; i++) {
            res += process(n, 1, choice.charAt(i), record);
        }
        return (int) (res % mod);
    }

    public long process(int n, int done, char cur, long[][] record) {
        if (done == n) {
            return 1L;
        }
        if (record[cur - 'a'][n - done] != 0) {
            return record[cur - 'a'][n - done];
        }
        long count = 0L;
        switch (cur) {
            case 'a':
                count += (process(n, done + 1, 'e', record)) % mod;
                break;
            case 'e':
                count += (process(n, done + 1, 'a', record)) % mod +
                        (process(n, done + 1, 'i', record) % mod);
                break;
            case 'i':
                count += (process(n, done + 1, 'a', record) % mod) +
                        (process(n, done + 1, 'e', record) % mod) +
                        (process(n, done + 1, 'o', record) % mod) +
                        (process(n, done + 1, 'u', record) % mod);
                break;
            case 'o':
                count += (process(n, done + 1, 'i', record) % mod) +
                        (process(n, done + 1, 'u', record) % mod);
                break;
            case 'u':
                count += process(n, done + 1, 'a', record) % mod;
                break;
            default:
        }
        record[cur - 'a'][n - done] = count % mod;
        return record[cur - 'a'][n - done];
    }
}
