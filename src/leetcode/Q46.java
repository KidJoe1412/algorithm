package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 题干：全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * ******************************************************
 * 解法：dfs回溯法
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/permutations/description/"></a>
 * ******************************************************
 */
class Q46 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length; // 长度
        List<List<Integer>> res = new ArrayList<>(); // 结果
        Deque<Integer> path = new ArrayDeque<>(); // 单条路径
        boolean[] used = new boolean[len]; // 该值是否用过
        if (len == 0) return res;
        dfs(nums,len,0,path,res,used);
        return res;
    }
    public void dfs(int[] nums,int len,int depth,Deque<Integer> path,List<List<Integer>> res,boolean[] used){
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]){
                path.addLast(nums[i]);
                used[i] = true;

                dfs(nums,len,depth+1,path,res,used);
                // 回溯
                used[i] = false;
                path.removeLast();
            }
        }
    }
}

















