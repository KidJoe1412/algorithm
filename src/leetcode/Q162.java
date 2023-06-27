package leetcode;
/**
 * 题干：寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * ******************************************************
 * 解法：二分查找
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/find-peak-element/description/"></a>
 * ******************************************************
 */
class Q162 {
    public int findPeakElement(int[] nums) {
        int left = 0,right = nums.length - 1;
        while(left < right){
            int middle = (left + right) / 2;
            if(nums[middle] > nums[middle + 1]){
                right = middle;
            }else{
                left = middle + 1;
            }
        }
        return left;
    }
}
