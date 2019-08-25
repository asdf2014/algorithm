/**
 * 对输入数字取模运算，提取每一位数字，并构成新的数字
 * @param x
 * @return
 */
private static int reverse(int x) {
    long rev = 0;
    while (x != 0) {
        rev = rev * 10 + x % 10;
        x = x / 10;
    }
    return (rev == (int) rev) ? (int) rev : 0;
}

/**
 * 逆序按字符串拼接的方式生成数字  注意正负
 * @param x
 * @return
 */
private static int reverse2(int x) {
    String numberStr = String.valueOf(x);
    StringBuilder sb = new StringBuilder(33);
    try {
        boolean flag = false;
        for (int i = numberStr.length() - 1; i > 0; i--) {
            sb.append(numberStr.charAt(i));
        }
        if ('-' == numberStr.charAt(0)) {
            return -1 * Integer.parseInt(sb.toString());
        } else {
            sb.append(numberStr.charAt(0));
            return Integer.parseInt(sb.toString());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}