package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题干：二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * ******************************************************
 * 解法：中序遍历
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/"></a>
 * ******************************************************
 */
class Q94 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        func(root);
        return ans;
    }

    public void func(TreeNode root){
        if (root == null)
            return;

        if (root.left != null){
            inorderTraversal(root.left);
        }

        ans.add(root.val);

        if (root.right != null){
            inorderTraversal(root.right);
        }
    }
}















