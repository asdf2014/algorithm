//English description is not available for the problem. Please switch to
//Chinese. Related Topics 数组 二分查找 👍 413 👎 0

package main

//leetcode submit region begin(Prohibit modification and deletion)
func minArray(numbers []int) int {
	if len(numbers) == 0 {
		return 0
	}
	for i := 0; i < len(numbers)-1; i++ {
		if numbers[i] > numbers[i+1] {
			return numbers[i+1]
		}
	}
	return numbers[0]
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {

}
