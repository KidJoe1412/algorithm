package leetcode;

import org.junit.Test;
import org.junit.runner.manipulation.Ordering;

import java.util.*;

/**
 * 题干：删除排序链表中的重复元素 II
 *给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/"></a>
 * ******************************************************
 */
class Q82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;

        while (cur != null){
            ListNode next = cur.next;
            while (next != null && cur.val == next.val)
                next = next.next;
            if (cur.next == next) //next 没有移动过，pre 和 cur 向后移动一位
                pre = cur;
            else //next 移动过，说明中间存在重复元素，将 pre 的 next 指针指向当前的 next，这样就跳过了重复元素
                pre.next = next;
            cur = next;
        }
        return dummy.next;
    }
}













