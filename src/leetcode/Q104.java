package leetcode;
/**
 * 题干： 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/"></a>
 * ******************************************************
 */
class Q104 {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(dfs(root.left) ,dfs(root.right)) + 1;
    }
}





















