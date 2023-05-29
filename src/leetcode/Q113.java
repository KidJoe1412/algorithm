package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题干：路径总和 II
 *给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href=""></a>
 * ******************************************************
 */

class Q113 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return ans;
    }
    public void dfs(TreeNode root, int targetSum){
        if (root == null){
            return;
        }
        path.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0){
            ans.add(new ArrayList<>(path)); // 全局变量使用要记得新建，不然会以最后该变量的值填充
            // return; 此处如果return，则最后一行path.remove不会执行，会导致错误答案
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
        path.remove(path.size() - 1);
    }
}



















