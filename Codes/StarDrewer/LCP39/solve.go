package main
// https://leetcode-cn.com/problems/0jQkd0/
//leetcode submit region begin(Prohibit modification and deletion)
func minimumSwitchingTimes(source [][]int, target [][]int) (res int) {
	src, tar := map[int]int{}, map[int]int{}
	for _, ints := range source {
		for _, v := range ints {
			src[v]++
		}
	}
	for _, ints := range target {
		for _, v := range ints {
			tar[v]++
		}
	}
	for k, v := range tar {
		if v1, ok := src[k]; ok {
			//if v1 > v {
			//	res += v1-v
			//}
			if v1 < v {
				res += v - v1
			}
		} else {
			res += v
		}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
}
