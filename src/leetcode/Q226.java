package leetcode;
/**
 * 题干：翻转二叉树
 *给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * ******************************************************
 * 解法：dfs
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/invert-binary-tree/"></a>
 * ******************************************************
 */
class Q226 {
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }
    public TreeNode dfs(TreeNode root){
        if (root == null) return null;
        TreeNode l = dfs(root.left);
        TreeNode r = dfs(root.right);
        root.left = r;
        root.right = l;
        return root;
    }
}
