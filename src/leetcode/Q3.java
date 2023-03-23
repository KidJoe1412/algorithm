package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题干：无重复字符的最长子串
 * ******************************************************
 * 解法：双指针+map
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/"></a>
 * ******************************************************
 */
class Q3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int left = 0,max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                left = Math.max(left,map.get(c) + 1);
            }
            map.put(c,i);
            max = Math.max(max,i - left + 1);
        }
        return max;
    }
}













