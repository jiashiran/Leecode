package code

import "fmt"

// Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var size int = 0
	var nextV int = 0
	var result *ListNode = &ListNode{}
	var head *ListNode
	for ; l1 != nil || l2 != nil; size++ {
		n1 := 0
		n2 := 0
		if l1 != nil {
			n1 = l1.Val
		}
		if l2 != nil {
			n2 = l2.Val
		}
		v := n1 + n2
		v += nextV
		if v >= 10 {
			v = v - 10
			nextV = 1
		} else {
			nextV = 0
		}
		if size == 0 {
			result = &ListNode{Val: v}
			head = result
		} else {
			result.Next = &ListNode{Val: v}
			result = result.Next
		}
		if l1 != nil {
			l1 = l1.Next
		}
		if l2 != nil {
			l2 = l2.Next
		}

	}
	if nextV == 1 {
		result.Next = &ListNode{Val: nextV}
	}
	return head
}

func TestAddTwoNumbers() {
	//234
	l1 := &ListNode{Val: 2}
	l1.Next = &ListNode{Val: 4}
	l1.Next.Next = &ListNode{Val: 3}
	//728
	l2 := &ListNode{Val: 5}
	l2.Next = &ListNode{Val: 6}
	l2.Next.Next = &ListNode{Val: 4}
	//9521
	l3 := addTwoNumbers(l1, l2)
	for l3 != nil {
		fmt.Println(l3.Val)
		l3 = l3.Next
	}
}
