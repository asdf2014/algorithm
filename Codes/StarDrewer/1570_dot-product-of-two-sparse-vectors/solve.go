//Given two sparse vectors, compute their dot product.
//
// Implement class SparseVector:
//
//
// SparseVector(nums) Initializes the object with the vector nums
// dotProduct(vec) Compute the dot product between the instance of SparseVector
//and vec
//
//
// A sparse vector is a vector that has mostly zero values, you should store
//the sparse vector efficiently and compute the dot product between two SparseVector.
//
//
// Follow up: What if only one of the vectors is sparse?
//
//
// Example 1:
//
//
//Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
//Output: 8
//Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
//v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
//
//
// Example 2:
//
//
//Input: nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
//Output: 0
//Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
//v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0
//
//
// Example 3:
//
//
//Input: nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
//Output: 6
//
//
//
// Constraints:
//
//
// n == nums1.length == nums2.length
// 1 <= n <= 10^5
// 0 <= nums1[i], nums2[i] <= 100
//
// Related Topics 设计 数组 哈希表 双指针 👍 10 👎 0

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)
type SparseVector struct {
	length int
	values map[int]int
}

func Constructor(nums []int) SparseVector {
	v := map[int]int{}
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			v[i] = nums[i]
		}
	}
	return SparseVector{
		length: len(nums),
		values: v,
	}
}

// Return the dotProduct of two sparse vectors
func (thisVec *SparseVector) dotProduct(vec SparseVector) (res int) {
	for index, value := range thisVec.values {
		if anotherValue := vec.values[index]; anotherValue != 0 {
			res += value * anotherValue
		}
	}
	return
}

/**
 * Your SparseVector object will be instantiated and called as such:
 * v1 := Constructor(nums1);
 * v2 := Constructor(nums2);
 * ans := v1.dotProduct(v2);
 */
//leetcode submit region end(Prohibit modification and deletion)

func main() {
	v1 := Constructor([]int{1, 0, 0, 2, 3})
	v2 := Constructor([]int{0, 3, 0, 4, 0})
	fmt.Println(v1.dotProduct(v2))
	v1 = Constructor([]int{0,1,0,0,0})
	v2 = Constructor([]int{0,0,0,0,2})
	fmt.Println(v1.dotProduct(v2))
	v1 = Constructor([]int{0,1,0,0,2,0,0})
	v2 = Constructor([]int{1,0,0,0,3,0,4})
	fmt.Println(v1.dotProduct(v2))
}
