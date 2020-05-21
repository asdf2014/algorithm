//Given n non-negative integers representing the histogram's bar height where th
//e width of each bar is 1, find the area of largest rectangle in the histogram. 
//
// 
//
// 
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3
//]. 
//
// 
//
// 
//The largest rectangle is shown in the shaded area, which has area = 10 unit. 
//
// 
//
// Example: 
//
// 
//Input: [2,1,5,6,2,3]
//Output: 10
// 
// Related Topics Array Stack


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        // Time Limit Exceeded
//        return bf1(heights);

        // Runtime:1387 ms, faster than 5.00%
//        return bf2(heights);

        // monoton stack, improved from bf2
        // tO(n), sO(n)
        // Runtime:12 ms, faster than 33.07%
        return monotonStack(heights);
    }

    private int monotonStack(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1 ) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }

    private int bf2(int[] heights) {
        int left, right;
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            left = i;
            right = i;
            while (left >= 0 && heights[left] >= heights[i]) left--;
            while (right < heights.length && heights[right] >= heights[i]) right++;
            int area = (right - left - 1) * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    private int bf1(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int minHight = Integer.MAX_VALUE;
                for (int k = i; k <= j; ++k) {
                    minHight = heights[k] < minHight ? heights[k] : minHight;
                }
                int area = minHight * (j - i + 1);
                maxArea = area > maxArea ? area : maxArea;
            }
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
