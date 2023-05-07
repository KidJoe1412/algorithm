package leetcode;

import java.util.Arrays;

/**
 * 题干：零钱兑换
 *给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/coin-change/description/"></a>
 * ******************************************************
 */
class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        // 数组大小为 amount + 1，初始值也为 amount + 1
        dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int j = 0; j < coins.length; j++) {
                // 子问题无解，跳过
                if (i - coins[j] < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 :dp[amount];
    }
}














