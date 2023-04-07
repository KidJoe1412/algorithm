package leetcode;

/**
 * 题干：删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * ******************************************************
 * 解法：双指针
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/"></a>
 * ******************************************************
 */
class Q83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == pre.val){
                ListNode next = cur.next;
                pre.next = next;
                cur = next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
