package leetcode;

import java.util.List;

/**
 * 题干：反转链表 II
 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/reverse-linked-list-ii/"></a>
 * ******************************************************
 */
class Q92 {
    // 顺序为 pre start end next
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode end = pre;
        ListNode start = pre.next;

        for (int i = 0; i < right - left + 1; i++) {
            end = end.next;
        }

        ListNode next = end.next;

        // 断开链表
        pre.next = null;
        end.next = null;

        pre.next = reverseList(start);
        start.next = next;
        return dummyHead.next;
    }
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

















