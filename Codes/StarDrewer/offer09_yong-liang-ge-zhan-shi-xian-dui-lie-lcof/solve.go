//English description is not available for the problem. Please switch to
//Chinese. Related Topics 栈 设计 队列 👍 302 👎 0

//用两个栈实现一个队列。
//队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
//(若队列中没有元素，deleteHead 操作返回 -1 )

//示例 1：
//输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]

//示例 2：
//输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]

//提示：
//1 <= values <= 10000
//最多会对 appendTail、deleteHead 进行 10000 次调用

package main

import (
	"container/list"
	"fmt"
)

//leetcode submit region begin(Prohibit modification and deletion)
type CQueue struct {
	stack, reversedStack *list.List
}

func Constructor() CQueue {
	return CQueue{
		stack:         list.New(),
		reversedStack: list.New(),
	}
}

func (queue CQueue) String() string {
	var tmp []interface{}
	for p := queue.reversedStack.Front(); p != nil; p = p.Next() {
		tmp = append([]interface{}{p.Value}, tmp...)
	}
	for p := queue.stack.Front(); p != nil; p = p.Next() {
		tmp = append(tmp, p.Value)
	}
	res := "[ "
	for i := 0; i < len(tmp); i++ {
		res += fmt.Sprintf("%v ", tmp[i])
	}
	res += "]"
	return res
}

func (queue *CQueue) AppendTail(value int) {
	queue.stack.PushBack(value)
}

// 删除后反转辅助栈 比较慢
func (queue *CQueue) SlowDeleteHead() int {
	if queue.stack.Len() == 0 {
		return -1
	}

	for queue.stack.Len() != 0 {
		queue.reversedStack.PushBack(queue.stack.Remove(queue.stack.Back()))
	}

	res := queue.reversedStack.Remove(queue.reversedStack.Back())

	for queue.reversedStack.Len() != 0 {
		queue.stack.PushBack(queue.reversedStack.Remove(queue.reversedStack.Back()))
	}

	return res.(int)
}

// 删除后不反转辅助栈
func (queue *CQueue) DeleteHead() int {
	if queue.stack.Len() == 0 && queue.reversedStack.Len() == 0 {
		return -1
	}
	if queue.reversedStack.Len() != 0 {
		return queue.reversedStack.Remove(queue.reversedStack.Back()).(int)
	}

	for queue.stack.Len() != 0 {
		queue.reversedStack.PushBack(queue.stack.Remove(queue.stack.Back()))
	}

	res := queue.reversedStack.Remove(queue.reversedStack.Back())

	for queue.reversedStack.Len() != 0 {
		queue.stack.PushBack(queue.reversedStack.Remove(queue.reversedStack.Back()))
	}

	return res.(int)
}

/**
 * Your CQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AppendTail(value);
 * param_2 := obj.DeleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

func main() {
	obj := Constructor()
	obj.AppendTail(3)
	fmt.Println(obj.DeleteHead())
	fmt.Println(obj.DeleteHead())
	fmt.Println(obj.DeleteHead())
	fmt.Println(obj)
	obj.AppendTail(1)
	obj.AppendTail(2)
	obj.AppendTail(3)
	obj.AppendTail(4)
	fmt.Println(obj.DeleteHead())
	fmt.Println(obj)
}
