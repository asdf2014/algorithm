class Solution {

	/**
	*通过双端队列来维护滑动窗口过程中的最大值
	*/
    public int[] maxSlidingWindow(int[] nums, int k) {
       if (nums == null || k < 1 || nums.length < k) {
            return new int[0];
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - k) {
                qmax.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[qmax.peekFirst()];
            }
        }
        return res;
    }
}