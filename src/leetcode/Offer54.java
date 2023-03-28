package leetcode;
/**
 * 题干：二叉搜索树的第k大节点
 *给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * ******************************************************
 * 解法：倒着中序遍历（左根右->右根左）
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/description/"></a>
 * ******************************************************
 */
class Offer54 {
    int count,res;
    public int kthLargest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if (root == null || count <= 0) return;
        dfs(root.right);
        // count为0说明找到了第k大的点
        count--;
        if (count == 0) res = root.val;
        dfs(root.left);
    }
}
