/**
 * ClassName:   Solution_69
 * Data:        2020/7/25
 * author:      Oh_MyBug
 * version:     V1.0
 */
public class Solution_69 {

    // 调包侠
//    public int mySqrt(int x) {
//        return (int)Math.sqrt(x);
//    }

    // 牛顿迭代法
//    public int mySqrt(int x) {
//        double threshold = 0.000001;
//        double res = 1.0;
//        while (true){
//            double new_res = (res + x / res) / 2;
//            if (Math.abs(new_res - res) < threshold)
//                break;
//            res = new_res;
//        }
//        return (int) res;
//    }

    // 二分法
    public int mySqrt(int x) {
        if(x == 1) return 1;
        int min = 0;
        int max = x;
        while(max-min>1){
            int m = (max+min)/2;
            if(x/m<m)
                max = m;
            else
                min = m;
        }
        return min;
    }
    public static void main(String[] args) {
        Solution_69 solution_69 = new Solution_69();
        System.out.println(solution_69.mySqrt(8));
    }
}
