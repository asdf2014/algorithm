public String intToRoman(int num) {
   StringBuilder sb = new StringBuilder();
   while (num > 0) {
       while (num >= 1000) {
           num -= 1000;
           sb.append('M');
       }
       if (num >= 900) {
           num -= 900;
           sb.append("CM");
       }
       if (num >= 500) {
           num -= 500;
           sb.append("D");
       }
       if (num >= 400) {
           num -= 400;
           sb.append("CD");
       }
       while (num >= 100) {
           num -= 100;
           sb.append("C");
       }
       if (num >= 90) {
           num -= 90;
           sb.append("XC");
       }
       if (num >= 50) {
           num -= 50;
           sb.append("L");
       }
       if (num >= 40) {
           num -= 40;
           sb.append("XL");
       }
       while (num >= 10) {
           num -= 10;
           sb.append("X");
       }
       if (num >= 9) {
           num -= 9;
           sb.append("IX");
       }
       if (num >= 5) {
           num -= 5;
           sb.append("V");
       }
       if (num >= 4) {
           num -= 4;
           sb.append("IV");
       }
       while (num > 0) {
           num -= 1;
           sb.append("I");
       }
   }
   return sb.toString();
}