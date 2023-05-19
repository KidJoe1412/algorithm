package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题干：子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * ******************************************************
 * 解法：1、递归 2、迭代
 * ******************************************************
 * 原题：<a href=""></a>
 * ******************************************************
 */
// 递归法+回溯法
class Q78 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0);
        return ans;
    }

    private void dfs(int[] nums, int cur) {
        if (cur == nums.length){
            ans.add(new ArrayList<>(temp)); // 这样写的原因是temp后续要回溯回去
            return;
        }
        temp.add(nums[cur]);
        dfs(nums,cur + 1);
        temp.remove(temp.size() - 1); // 回溯，这个remove方法是按照索引来移除的
        dfs(nums,cur + 1);
    }
}























