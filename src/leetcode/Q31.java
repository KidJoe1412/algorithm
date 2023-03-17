package leetcode;

import java.util.Arrays;

/**
 * 题干：下一个排列
 *整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 * ******************************************************
 * 解法：<a href="https://leetcode.cn/problems/next-permutation/solutions/80560/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/">...</a>
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/next-permutation/description/"></a>
 * ******************************************************
 */
// 看上面**解法**一栏理解
class Q31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)return;
        int a = nums.length - 2;
        int b = nums.length - 1;
        int c = nums.length - 1;
        int end = nums.length - 1;

        while (a >= 0 && nums[a] >= nums[b] ) {
            a--;b--;
        }
        if (a >= 0){
            while (nums[a] >= nums[c]){
                c--;
            }
            swap(nums,a,c);
        }
        reverse(nums,b,end);
    }

    public void reverse(int[] nums,int left,int right){
        while (left < right){
            swap(nums,left,right);
            left++;right--;
        }
    }


    public void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}













