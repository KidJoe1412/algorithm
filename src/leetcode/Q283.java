package leetcode;
/**
 * 题干：移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * ******************************************************
 * 解法：覆盖
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/move-zeroes/description/"></a>
 * ******************************************************
 */
class Q283 {
    public void moveZeroes(int[] nums) {
        int i = 0,j = 0,n = nums.length;
        while(j < n){
            if(nums[j] != 0){ // 只要不等于0就往前换
                swap(nums,i,j);
                i++;
            }
            j++;
        }
    }
    public void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}




















