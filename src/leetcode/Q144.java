package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题干：二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/"></a>
 * ******************************************************
 */
class Q144 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if (root == null)
            return;
        ans.add(root.val);
        if (root.left != null)
            dfs(root.left);
        if (root.right != null)
            dfs(root.right);
    }
}








