//English description is not available for the problem. Please switch to
//Chinese. Related Topics 栈 设计 👍 179 👎 0

//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

//示例:
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.

//提示：
//各函数的调用总次数不超过 20000 次

//注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/

package main

//leetcode submit region begin(Prohibit modification and deletion)

type ListNode struct {
	next *ListNode
	val  int
}

type MinStack struct {
	min int
	top *ListNode
}

/** initialize your data structure here. */
func Constructor() MinStack {
	return MinStack{
		min: 0,
		top: nil,
	}
}

func (stack *MinStack) Push(x int) {
	if stack.top == nil {
		stack.min = x
		stack.top = &ListNode{
			next: nil,
			val:  x,
		}
	} else {
		if x < stack.min {
			stack.min = x
		}
		stack.top = &ListNode{
			next: stack.top,
			val:  x,
		}
	}
}

func (stack *MinStack) Pop() {
	if stack.top != nil {
		poppedVal := stack.top.val
		stack.top = stack.top.next
		if poppedVal == stack.min && stack.top != nil {
			stack.min = stack.top.val
			for p := stack.top; p != nil; p = p.next {
				if p.val < stack.min {
					stack.min = p.val
				}
			}
		}
	} else {
		stack.min = 0
	}

}

func (stack *MinStack) Top() (res int) {
	if stack.top != nil {
		res = stack.top.val
	}
	return
}

func (stack *MinStack) Min() int {
	return stack.min
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.Min();
 */
//leetcode submit region end(Prohibit modification and deletion)

func main() {
	obj := Constructor()
	obj.Push(-2)
	obj.Push(0)
	obj.Push(-3)
	obj.Min()
	obj.Pop()

}
