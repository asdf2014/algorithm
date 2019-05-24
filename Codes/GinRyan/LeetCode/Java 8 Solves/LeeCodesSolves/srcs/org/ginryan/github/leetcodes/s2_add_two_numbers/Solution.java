package org.ginryan.github.leetcodes.s2_add_two_numbers;

import java.util.ArrayList;

/**
 * 
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 
 * 输出：7 -> 0 -> 8
 * 
 * 原因：342 + 465 = 807
 *
 * @author GinRyan
 */
class Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode retListNode = new ListNode(0);
		ListNode latestRetListNode = retListNode;
		ListNode currentNode1 = l1;
		ListNode currentNode2 = l2;
		// 满位进制准备值
		int carry = 0;

		while (currentNode1 != null || currentNode2 != null) {
			// 一旦遇到单个空节点，则说明高位为0，则填充高位为0
			currentNode1 = currentNode1 == null ? new ListNode(0) : currentNode1;
			currentNode2 = currentNode2 == null ? new ListNode(0) : currentNode2;
			// 新建一个节点，并且填充两数字之和，并且加上上一节点进位值。如无进位这个值为0
			int cSum = currentNode1.val + currentNode2.val + carry;
			// 取余做填充数值
			int cMod = cSum % 10;
			// 取整除值做进位值写入到to_upper_pos变量中，用于下次将进位值加和
			carry = cSum / 10;

			ListNode createMode = new ListNode(cMod);
			//挂接到结果链表节点下
			latestRetListNode.next = createMode;
			//挂接到结果链表节点下之后还要向前推latestRetListNode到下一个节点
			latestRetListNode = latestRetListNode.next;
			//次级节点递送
			currentNode1 = currentNode1.next;
			currentNode2 = currentNode2.next;

		}
		//最高位如果升位，需要增加一位节点，放1
		if (carry > 0) {
			ListNode createMode = new ListNode(carry);
			latestRetListNode.next = createMode;
		}
		return retListNode.next;
	}

	public static void main(String[] args) {

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}