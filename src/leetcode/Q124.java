package leetcode;
/**
 * 题干：二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * ******************************************************
 * 解法：递归
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/"></a>
 * ******************************************************
 */
class Q124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        func(root);
        return max;
    }

    public int func(TreeNode root){
        if (root == null)
            return 0;

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int left = Math.max(func(root.left),0);
        int right = Math.max(func(root.right),0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int price = root.val + left + right;
        // 更新答案
        max = Math.max(price,max);

        // 返回该结点的最大贡献值
        /* 最大贡献值：以该节点为根节点的子树中寻找以该节点为起点的一条路径
         使得该路径上的节点值之和最大。*/
        return root.val + Math.max(left,right);
    }
}



















