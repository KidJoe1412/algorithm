package leetcode;
/**
 * 题干：对称二叉树
 *给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * ******************************************************
 * 解法：dfs
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/symmetric-tree/"></a>
 * ******************************************************
 */
class Q101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode left,TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false; // 有一者不为空
        if (left.val != right.val) return false;
        return dfs(left.left,right.right) && dfs(left.right,right.left); // 递归比较
    }
}
