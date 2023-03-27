package leetcode;

import java.util.*;
//public class Main {
//    public ListNode reorderList(ListNode head) {
//        if (head == null || head.next == null || head.next.next == null) {
//            return head;
//        }
//        if (head.next.next.next == null) {
//            head.next.next.next = head;
//            head.next.next = null;
//            return head;
//        }
//        ListNode temp = new ListNode(0);
//        temp.next = head;
//        ListNode pre = temp;
//        ListNode end = temp;
//
//        int flag = 0;
//
//        while (end != null) {
//            for (int i = 0; i < 4 && end.next != null; i++) {
//                end = end.next;
//                flag = i + 1;
//            }
//
//            ListNode endT = end;
//            if (flag == 1 || flag == 2) {
//                ;
//            } else if (flag == 3) {
//                end.next = pre.next;
//                pre.next = end;
//                end.next.next.next = null;
//                return temp.next;
//            }else {
//                ListNode node3 = pre.next.next.next;
//                ListNode node2 = pre.next.next;
//                end.next = pre.next;
//                pre.next = node3;
//                node2.next = null;
//            }
//            end = endT;
//            pre = endT;
//        }
//        return temp.next;
//    }
//}

public class Main {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left != null && right != null) return root;
        else if (left != null) return left;
        else return right;
    }
}







