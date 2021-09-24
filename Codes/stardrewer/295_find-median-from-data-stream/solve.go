//The median is the middle value in an ordered integer list. If the size of the
//list is even, there is no middle value and the median is the mean of the two
//middle values.
//
//
// For example, for arr = [2,3,4], the median is 3.
// For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
//
//
// Implement the MedianFinder class:
//
//
// MedianFinder() initializes the MedianFinder object.
// void addNum(int num) adds the integer num from the data stream to the data
//structure.
// double findMedian() returns the median of all elements so far. Answers
//within 10⁻⁵ of the actual answer will be accepted.
//
//
//
// Example 1:
//
//
//Input
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//Output
//[null, null, null, 1.5, null, 2.0]
//
//Explanation
//MedianFinder medianFinder = new MedianFinder();
//medianFinder.addNum(1);    // arr = [1]
//medianFinder.addNum(2);    // arr = [1, 2]
//medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
//medianFinder.addNum(3);    // arr[1, 2, 3]
//medianFinder.findMedian(); // return 2.0
//
//
//
// Constraints:
//
//
// -10⁵ <= num <= 10⁵
// There will be at least one element in the data structure before calling
//findMedian.
// At most 5 * 10⁴ calls will be made to addNum and findMedian.
//
//
//
// Follow up:
//
//
// If all integer numbers from the stream are in the range [0, 100], how would
//you optimize your solution?
// If 99% of all integer numbers from the stream are in the range [0, 100], how
//would you optimize your solution?
//
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 483 👎 0

package main

import (
	"container/heap"
	"fmt"
	"sort"
)

//leetcode submit region begin(Prohibit modification and deletion)

type MedianFinder struct {
	queMin, queMax hp
}

func Constructor() MedianFinder {
	return MedianFinder{}
}

func (mf *MedianFinder) AddNum(num int) {
	if mf.queMin.Len() == 0 || num <= (-mf.queMin.IntSlice[0]) {
		heap.Push(&mf.queMin, -num)
	} else {
		heap.Push(&mf.queMax, num)
	}
	if mf.queMin.Len()-mf.queMax.Len() > 1 {
		// 3 1 -> 2 2
		minHeapTop := -heap.Pop(&mf.queMin).(int)
		heap.Push(&mf.queMax, minHeapTop)
	} else if mf.queMin.Len() < mf.queMax.Len() {
		// 1 2 -> 2 1
		maxHeapTop := -heap.Pop(&mf.queMax).(int)
		heap.Push(&mf.queMin, maxHeapTop)
	}
}

func (mf *MedianFinder) FindMedian() float64 {
	if mf.queMin.Len() <= mf.queMax.Len() {
		return float64(-mf.queMin.IntSlice[0]+mf.queMax.IntSlice[0]) / 2
	}
	return float64(-mf.queMin.IntSlice[0])
}

func (mf *MedianFinder) GetVal() []int {
	var l []int
	for i := len(mf.queMin.IntSlice) - 1; i >= 0; i-- {
		l = append(l, -mf.queMin.IntSlice[i])
	}
	return append(l, mf.queMax.IntSlice...)
}

type hp struct {
	sort.IntSlice
}

func (h *hp) Push(v interface{}) {
	h.IntSlice = append(h.IntSlice, v.(int))
}
func (h *hp) Pop() interface{} {
	tmp := h.IntSlice
	v := tmp[len(tmp)-1]
	h.IntSlice = tmp[:len(tmp)-1]
	return v
}

// 数组二分查找的复杂度是 O(logN) 但是插数据太费时间了，所以TLE了
// 如果把数组改成其他数据结构应该就行了(比如红黑树)
//type MedianFinder struct {
//	val []int
//}
//
//func Constructor() MedianFinder {
//	return MedianFinder{
//		val: []int{},
//	}
//}
//
//func (mf *MedianFinder) AddNum(num int) {
//	if len(mf.val) == 0 {
//		mf.val = append(mf.val, num)
//		return
//	}
//
//	l, r := 0, len(mf.val)-1
//	for l != r {
//		mid := (l + r) / 2
//
//		if num <= mf.val[mid] {
//			r = mid
//		} else {
//			l = mid + 1
//		}
//	}
//
//	mid := (l + r) / 2
//	if num <= mf.val[mid] {
//		mf.val = append(mf.val[:mid], append([]int{num}, mf.val[mid:]...)...)
//	} else {
//		mf.val = append(mf.val[:mid+1], append([]int{num}, mf.val[mid+1:]...)...)
//	}
//}
//
//func (mf *MedianFinder) FindMedian() float64 {
//	if len(mf.val) == 0 {
//		return 0
//	}
//	l, r := 0, len(mf.val)-1
//	mid := (l + r) / 2
//	if (l+r)%2 == 1 {
//		return (float64(mf.val[mid]) + float64(mf.val[mid+1])) / 2
//	}
//	return float64(mf.val[mid])
//}
//
//func (mf *MedianFinder) GetVal() []int {
//	return mf.val
//}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AddNum(num);
 * param_2 := obj.FindMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

func main() {
	mf := Constructor()
	mf.AddNum(6)
	fmt.Println(mf.FindMedian())
	mf.AddNum(10)
	fmt.Println(mf.FindMedian())
	mf.AddNum(2)
	fmt.Println(mf.FindMedian())
	mf.AddNum(6)
	fmt.Println(mf.FindMedian())
	mf.AddNum(5)
	fmt.Println(mf.FindMedian())
	mf.AddNum(0)
	fmt.Println(mf.FindMedian())
	mf.AddNum(6)
	fmt.Println(mf.FindMedian())
	mf.AddNum(3)
	fmt.Println(mf.FindMedian())
	mf.AddNum(1)
	fmt.Println(mf.FindMedian())
	mf.AddNum(0)
	fmt.Println(mf.FindMedian())
	mf.AddNum(0)
	fmt.Println(mf.FindMedian())
	fmt.Println(mf.GetVal())
}
