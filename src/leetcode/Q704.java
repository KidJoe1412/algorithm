package leetcode;

/**
 * 题干：二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/binary-search/"></a>
 * ******************************************************
 */
class Q704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int middle = (left + right) / 2;
        while (left <= right){
            if (target == nums[middle]){
                return middle;
            }else if(target > nums[middle]){
                left = middle + 1;
                middle = (left + right) / 2;
            }else if(target < nums[middle]){
                right = middle - 1;
                middle = (left + right) / 2;
            }
        }
        return -1;
    }
}
















