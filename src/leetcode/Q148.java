package leetcode;

import java.util.List;

/**
 * 题干：排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * ******************************************************
 * 解法：归并排序
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/sort-list/description/"></a>
 * ******************************************************
 */
class Q148 {
    public ListNode sortList(ListNode head) {
        // 跳出条件
        if (head == null || head.next == null)
            return head;
        // 找中点
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode start = slow.next;
        slow.next = null;
        // 递归
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(start);
        // 合并
        ListNode ans = merge(l1, l2);
        return ans;

    }
    public ListNode merge(ListNode l1,ListNode l2){
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }else {
            l2.next = merge(l2.next,l1);
            return l2;
        }
    }
}




















