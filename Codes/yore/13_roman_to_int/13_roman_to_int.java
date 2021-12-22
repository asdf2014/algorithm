public int romanToInt(String s) {
   int number = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == 'M') {
            number += 1000;
        } else if (s.charAt(i) == 'D') {
            number += 500;
        } else if (s.charAt(i) == 'C') {
            if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                number += 400;
                i++;
            } else if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                number += 900;
                i++;
            } else {
                number += 100;
            }
        } else if (s.charAt(i) == 'L') {
            number += 50;
        } else if (s.charAt(i) == 'X') {
            if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                number += 40;
                i++;
            } else if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                number += 90;
                i++;
            } else {
                number += 10;
            }
        } else if (s.charAt(i) == 'V') {
            number += 5;
        } else if (s.charAt(i) == 'I') {
            if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                number += 4;
                i++;
            } else if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                number += 9;
                i++;
            } else {
                number += 1;
            }
        }
    }
    return number;
}