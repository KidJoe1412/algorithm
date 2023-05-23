package leetcode;
/**
 * 题干：二叉树的直径
 *给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 * ******************************************************
 * 解法：dfs
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/diameter-of-binary-tree/"></a>
 * ******************************************************
 */
class Q543 {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(left + right,ans);
        return Math.max(left,right) + 1;
    }
}









