package leetcode;

/**
 * 题干：接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * ******************************************************
 * 解法：动态规划(记录i的左边，和记录i右边)
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/trapping-rain-water/description/"></a>
 * ******************************************************
 */
public class Q42 {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] left = new int[n]; // 从左往右的动态规划
        left[0] = height[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i-1],height[i]);

        int[] right = new int[n]; // 从右往左的动态规划
        right[n-1] = height[n-1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i+1],height[i]);

        int ans = 0; // 结果

        for (int i = 0; i < n; i++) {
            ans += Math.min(left[i],right[i]) - height[i];
        }
        return ans;
    }
}

















