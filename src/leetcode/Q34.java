package leetcode;
/**
 * 题干：在排序数组中查找元素的第一个和最后一个位置
 *给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * ******************************************************
 * 解法：两次二分
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/"></a>
 * ******************************************************
 */
class Q34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int first = -1, last = -1;

        while(left <= right){
            int middle = (right + left) / 2;
            if(nums[middle] == target){
                first = middle;
                right = middle - 1; // 重点，找到的可能不是最左边的那个，往前递归继续找找看
            }else if(nums[middle] > target){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
        // 重置，进行二次递归
        left = 0;
        right = nums.length - 1;

        while(left <= right){
            int middle = (right + left) / 2;
            if(nums[middle] == target){
                last = middle;
                left = middle + 1; // 重点，找到的可能不是最右边的那个，往后递归继续找找看
            }else if(nums[middle] > target){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }

        return new int[]{first,last};
    }
}
