package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Set;

/**
 * 题干：单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * ******************************************************
 * 解法：动态规划
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/word-break/"></a>
 * ******************************************************
 */
class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length() ;i++){
            for(int j = 0; j < i ;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}











