package leetcode;

import java.util.Arrays;

/**
 * 题干：最大数
 *给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * ******************************************************
 * 解法：贪心，用结果反推
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/largest-number/description/"></a>
 * ******************************************************
 */
class Q179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];
        for(int i = 0; i < n ;i++)
            s[i] = nums[i] + "";
        Arrays.sort(s,(a,b) -> {
            String s1 = a + b,s2 = b + a;
            return s1.compareTo(s2);
        });
        StringBuffer sb = new StringBuffer();
        for(String str:s)
            sb.append(str);
        int index = 0; // 处理像[0,0,0]组成000这样的问题，这种需要返回0
        while(index < n - 1 && sb.charAt(index) == '0')
            index++;
        return sb.toString().substring(index);
    }
}
