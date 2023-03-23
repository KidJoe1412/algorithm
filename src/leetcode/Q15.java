package leetcode;

import java.util.*;

/**
 * 题干：三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/3sum/"></a>
 * ******************************************************
 */
class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        for (int k = 0; k < n - 2; k++) {
            if (nums[k] > 0) // 排序后，最小值小于0，加和才可能等于0
                break;
            if (k > 0 && nums[k] == nums[k - 1]) // 不能和前一个值相等
                continue;
            int i = k + 1,j = n - 1;

            while (i < j){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0){
                    while (i < j && nums[i] == nums[++i]);
                }else if(sum > 0){
                    while (i < j && nums[j] == nums[--j]);
                }else {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
                    ans.add(list);
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return ans;
    }
}












