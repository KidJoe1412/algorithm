package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 题干：
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * ***********************************************************
 * 解法：
 * 快速排序(手撕)然后返回第k大值
 * ***********************************************************
 * 原题：
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/description/"></a>
 */
// 手写快排做法
class Q215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    public void quickSort(int[] nums,int left,int right){
        if (left > right)
            return;
        int p = nums[left];
        int i = left;
        int j = right;
        while (i < j){
            while (nums[j] >= p && i < j)
                j--;
            while (nums[i] <= p && i < j)
                i++;
            if (i < j)
                swap(nums,i,j);
        }
        // nums[left]=nums[i];
        // nums[i] = p;
        swap(nums,left,i);
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }

    public void swap(int[] arr,int i ,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}


// 小顶堆做法
//class Q215 {
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        for(int x : nums){
//            queue.add(x);
//            while (queue.size() > k){
//                queue.poll();
//            }
//        }
//        return queue.peek();
//    }
//}















