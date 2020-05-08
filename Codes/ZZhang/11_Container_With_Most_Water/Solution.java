//Given n non-negative integers a1, a2, ..., an , where each represents a point 
//at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
// line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis for
//ms a container, such that the container contains the most water. 
//
// Note: You may not slant the container and n is at least 2. 
//
// 
//
// 
//
// The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In thi
//s case, the max area of water (blue section) the container can contain is 49. 
//
// 
//
// Example: 
//
// 
//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49 Related Topics Array Two Pointers


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        // two pointers; O(n)
        // return twoPointer(height);

        // bf; O(n^2)
        return bf(height);
    }

    private int bf(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int currentArea = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, currentArea);
            }
        }
        return maxArea;
    }

    private int twoPointer(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = (right - left) * ( height[left] < height[right] ? height[left] : height[right]);
            maxArea = maxArea > area ? maxArea : area;
            if (height[left] <= height[right]) {
                int i = left;
                while (left < right && height[left] <= height[i]) left++;
            } else {
                int j = right;
                while (left < right && height[right] <= height[j]) right--;
            }
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
