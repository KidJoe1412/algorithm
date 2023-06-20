package leetcode;
/**
 * 题干：最长重复子数组
 *给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * ******************************************************
 * 解法：动态规划，时间复杂度O（n²）
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description/"></a>
 * ******************************************************
 */
// 动态规划，dp[i][j]代表nums1[i]和nums2[j]的最长公共前缀
class Q718 {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int ans = 0;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(dp[i][j],ans);
            }
        }
        return ans;
    }
}
