package leetcode;
/**
 * 题干：二叉树的最近公共祖先
 *给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * ******************************************************
 * 解法：dfs
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/"></a>
 * ******************************************************
 */
public class Q236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        // 都不为空，说明p和q分散在左右子树上了
        if (left != null && right != null) return root;
        // left为空说明 p和q都在右子树上
        if (left == null) return right;
        return left;
    }
}












