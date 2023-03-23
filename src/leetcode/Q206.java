package leetcode;
/**
 * 题干：反转链表
 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/reverse-linked-list/"></a>
 * ******************************************************
 */
class Q206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}















