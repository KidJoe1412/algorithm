package leetcode;

/**
 * 题干：相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * ******************************************************
 * 解法：双指针
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/"></a>
 * ******************************************************
 */
public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (!(a == null && b == null)){ // 同时为空则说明遍历结束
            if (a == b) return a;
            a = (a != null) ? a.next : headB ;
            b = (b != null) ? b.next : headA ;
        }
        return null;
    }
}













