package leetcode;

/**
 * 题干：排序数组
 *给你一个整数数组 nums，请你将该数组升序排列。
 * ******************************************************
 * 解法：快排
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/sort-an-array/"></a>
 * ******************************************************
 */
class Q912 {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums,int left,int right){
        if(left >= right){
            return;
        }
        int guard = nums[left];
        int i = left;
        int j = right;
        while (i < j){
            while (i < j && nums[j] >= guard) j--;
            while (i < j && nums[i] <= guard) i++;
            swap(nums,i,j);
        }
        swap(nums,i,left);
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }

    public void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}













