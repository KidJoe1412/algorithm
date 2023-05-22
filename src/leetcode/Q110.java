package leetcode;
/**
 * 题干：平衡二叉树
 *给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/balanced-binary-tree/description/"></a>
 * ******************************************************
 */
class Q110 {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }
    public int dfs(TreeNode root){
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == -1) return -1;
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;
    }
}



















