package leetcode;
/**
 * 题干： 路径总和
 *给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 * ******************************************************
 * 解法：dfs
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/path-sum/description/"></a>
 * ******************************************************
 */
class Q112 {
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        dfs(root,targetSum);
        return flag;
    }
    public void dfs(TreeNode root, int targetSum){
        if(root.left == null && root.right == null){
            if(targetSum == root.val)
                flag = true;
            return;
        }
        if(root.left != null) dfs(root.left,targetSum - root.val);
        if(root.right != null) dfs(root.right,targetSum - root.val);
    }
}
