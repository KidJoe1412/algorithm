package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题干：求根节点到叶节点数字之和
 *给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/sum-root-to-leaf-numbers/"></a>
 * ******************************************************
 */
class Q129 {
    List<Integer> list = new ArrayList<>();
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        for (Integer integer : list) {
            ans += integer;
        }
        return ans;
    }

    private void dfs(TreeNode root,int num) {
        num = root.val + num;
        if (root.left == null && root.right == null){
            list.add(num);
            return;
        }
        if (root.left != null){
            dfs(root.left,num * 10);
        }
        if (root.right != null){
            dfs(root.right,num * 10);
        }
    }
}




















