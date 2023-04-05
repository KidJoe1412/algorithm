package leetcode;

import java.util.Arrays;

/**
 * 题干：买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * ******************************************************
 * 解法：动态规划
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description/"></a>
 * ******************************************************
 */
class Q188 {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k+1]; // 记录第几次j购买的最大利益
        int[] sell = new int[k+1]; //记录第几次j出售的最大利益
        Arrays.fill(buy,Integer.MIN_VALUE);
        Arrays.fill(sell,0);

        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j],sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j],buy[j] + prices[i]);
            }
        }
        return sell[k];
    }
}







