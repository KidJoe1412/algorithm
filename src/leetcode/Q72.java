package leetcode;
/**
 * 题干：编辑距离
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * ******************************************************
 * 解法：动态规划,dp[i][j]表示字符串1的前i个字符到字符串2的前j个字符的编辑距离
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/edit-distance/description/"></a>
 * ******************************************************
 */
class Q72 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // 如果有一个为空串
        if (n * m == 0) return n + m;

        int[][] dp = new int[n+1][m+1];
        // 初始化边界
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int x = dp[i-1][j]+1;
                int y = dp[i][j-1]+1;
                int z = dp[i-1][j-1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)){
                    z += 1;
                }
                dp[i][j] = Math.min(Math.min(x,y),z);
            }
        }
        return dp[n][m];
    }
}

















