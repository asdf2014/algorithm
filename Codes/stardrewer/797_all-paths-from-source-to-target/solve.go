package main

import (
	"fmt"
)

//leetcode submit region begin(Prohibit modification and deletion)
func allPathsSourceTarget(graph [][]int) (res [][]int) {
	if len(graph) == 0 {
		return nil
	}
	// 预处理 用图的开始来初始化queue
	var pathsQueue [][]int
	for _, v := range graph[0] {
		pathsQueue = append(pathsQueue, append([]int{0}, v))
	}

	for i := 0; i < len(pathsQueue); i++ {
		thisPath := pathsQueue[i]
		thisPathTailNode := thisPath[len(thisPath)-1]

		// 根据slice最后一位，在graph中计算其后续1层放在队尾
		for _, nextNode := range graph[thisPathTailNode] {
			var nextPath []int // 强制重新分配内存
			nextPath = append(nextPath, thisPath...)
			nextPath = append(nextPath, nextNode)
			pathsQueue = append(pathsQueue, nextPath)
		}

		if thisPathTailNode == len(graph)-1 {
			res = append(res, thisPath)
		}
	}
	//fmt.Printf("queue:%v\n", pathsQueue)
	return res
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(allPathsSourceTarget([][]int{
		{1, 2}, // 0-1 0-2
		{3},    // 1-3
		{3},    // 2-3
		{},     // 3-null
	}))
	fmt.Println(allPathsSourceTarget([][]int{
		{4, 3, 1}, // 0-4 0-3 0-1
		{3, 2, 4}, // 1-3 1-2 1-4
		{3},       // 2-3
		{4},       // 3-4
		{},        // 4-
	}))
	fmt.Println(allPathsSourceTarget([][]int{
		{3, 1},
		{4, 6, 7, 2, 5},
		{4, 6, 3},
		{6, 4},
		{7, 6, 5},
		{6},
		{7},
		{},
	}))
}
