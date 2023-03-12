package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 题干：合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * ******************************************************
 * 解法：两两合并（递归版）
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/merge-k-sorted-lists/"></a>
 * ******************************************************
 */
//public class Q23 {
//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode res = null;
//        for (ListNode list : lists) {
//            res = merge2Lists(res, list);
//        }
//        return res;
//    }
//
//
//
//    // 合并两个有序链表（递归版）
//    private ListNode merge2Lists(ListNode a,ListNode b){
//        if (a == null) return b;
//        if (b == null) return a;
//
//        if (a.val < b.val){
//            a.next = merge2Lists(a.next,b);
//            return a;
//        }else{
//            b.next = merge2Lists(b.next,a);
//            return b;
//        }
//
//    }
//}


// 添加分治的两两合并
//public class Q23 {
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 0) return null;
//        return merge(lists, 0, lists.length - 1);
//    }
//
//    private ListNode merge(ListNode[] lists, int left, int right) {
//        if (left == right) return lists[left];
//        int middle = left + (right - left) / 2;
//        ListNode l1 = merge(lists,left,middle);
//        ListNode l2 = merge(lists,middle,right);
//        return merge2Lists(l1,l2);
//    }
//
//
//    // 合并两个有序链表（递归版）
//    private ListNode merge2Lists(ListNode a, ListNode b) {
//        if (a == null) return b;
//        if (b == null) return a;
//
//        if (a.val < b.val) {
//            a.next = merge2Lists(a.next, b);
//            return a;
//        } else {
//            b.next = merge2Lists(b.next, a);
//            return b;
//        }
//
//    }
//}

// 优先队列版本
class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummyHead.next;
    }
}










