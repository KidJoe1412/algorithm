package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题干：组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/combination-sum/description/"></a>
 * ******************************************************
 */
class Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); // 排序便于后面剪枝
        dfs(candidates,0,target,path,ans);
        return ans;
    }
    public void dfs(int[] candidates,int begin,int target,List<Integer> path,               List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList(path));
            return;
        }
        for(int i = begin; i < candidates.length; i++){
            if(target - candidates[i] < 0){ // 小于0直接剪枝
                return;
            }
            path.add(candidates[i]);
            dfs(candidates,i,target-candidates[i],path,ans); // 这里begin参数不能再从0开始了，避免重复，要从i开始
            path.remove(path.size()-1); //回溯
        }
    }
}
