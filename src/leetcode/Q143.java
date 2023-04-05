package leetcode;

/**
 * 题干：重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * ******************************************************
 * 解法：链表中点+反转链表+合并链表
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/reorder-list/description/"></a>
 * ******************************************************
 */
class Q143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode middle = middleList(head);
        ListNode next = middle.next;
        middle.next = null;
        ListNode l2 = reverseList(next);
        mergeList(head,l2);
    }

    public void mergeList(ListNode l1,ListNode l2){
        while (l1 != null && l2 != null){
            ListNode t1 = l1.next;
            ListNode t2 = l2.next;

            l1.next = l2;
            l1 = t1;

            l2.next = l1;
            l2 = t2;
        }
    }

    public ListNode middleList(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head){
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
















