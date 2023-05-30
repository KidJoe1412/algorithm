package leetcode;
/**
 * 题干：验证二叉搜索树
 *给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * ******************************************************
 * 解法：中序遍历递归
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/validate-binary-search-tree/description/"></a>
 * ******************************************************
 */
class Q98 {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }
    public boolean dfs(TreeNode root){ // 中序遍历
        if (root == null) return true;
        boolean left = dfs(root.left); // 先遍历左子树
        if (root.val <= pre) return false; // 处理根结点
        pre = root.val; // 更新前一个的值
        boolean right = dfs(root.right); // 最后遍历右子树
        return left && right;
    }
}





















